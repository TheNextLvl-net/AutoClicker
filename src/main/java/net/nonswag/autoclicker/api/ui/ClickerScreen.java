package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.Clicker;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.util.concurrent.TimeUnit;

@Getter
public abstract class ClickerScreen extends Screen {
    protected JSpinner milliseconds, seconds, minutes;
    protected JLabel power, back, key;
    protected JPanel panel, interval;
    protected final Clicker clicker;
    protected boolean locked;

    // Maximum interval of 60 minutes (in milliseconds)
    private final long maximum = TimeUnit.MINUTES.toMillis(60);

    protected ClickerScreen(Clicker clicker) {
        renderInterval((this.clicker = clicker).interval());
        initPanel();
        initIntervalPanel();
        initIntervalSpinner();
        initBackButton();
        initPowerButton();
        initKeyButton();
    }

    private void initIntervalPanel() {
        interval.setBackground(panel.getBackground());
        interval.setVisible(false);
    }

    // calculates the interval in milliseconds based on the user input
    private long getInterval() {
        return Math.max(1, Math.min(maximum, TimeUnit.MINUTES.toMillis(((Number) minutes.getValue()).longValue()) +
                TimeUnit.SECONDS.toMillis(((Number) seconds.getValue()).longValue()) +
                ((Number) milliseconds.getValue()).longValue()));
    }

    private void initIntervalSpinner() {
        initSpinner(milliseconds);
        initSpinner(seconds);
        initSpinner(minutes);
    }

    private void initSpinner(JSpinner spinner) {
        spinner.addChangeListener(event -> SwingUtilities.invokeLater(() -> {
            if (!(spinner.getValue() instanceof Number)) return;
            long interval = getInterval();
            getClicker().interval(interval);
            renderInterval(interval);
        }));
    }

    // renders the interval from milliseconds back to the ui
    protected void renderInterval(long interval) {
        minutes.setValue(Math.max(0, Math.min(60, TimeUnit.MILLISECONDS.toMinutes(interval))));
        seconds.setValue(Math.max(0, TimeUnit.MILLISECONDS.toSeconds(interval) % 60));
        milliseconds.setValue(Math.max(0, interval % 1000));
    }

    private void initBackButton() {
        init(back, Images.BACK, () -> Window.init(MainScreen.getInstance()));
        back.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(10, 10, 10, 10)));
    }

    private void initPowerButton() {
        init(power, Images.POWER_ACTIVATE, () -> {
            clicker.setRunning(!clicker.isRunning());
            if (clicker.isRunning()) power.setIcon(Images.POWER_DEACTIVATE.getIcon());
            else power.setIcon(Images.POWER_ACTIVATE.getIcon());
            updateInterval();
        });
        power.setVisible(false);
    }

    private void updateInterval() {
        minutes.setVisible(!clicker.isRunning());
        seconds.setVisible(minutes.isVisible());
        milliseconds.setVisible(seconds.isVisible());
    }

    protected abstract void initKeyButton();
}
