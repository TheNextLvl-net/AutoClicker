package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.Clicker;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;

import javax.annotation.Nullable;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;
import java.util.concurrent.TimeUnit;

@Getter
public abstract class ClickerScreen extends Screen {
    protected JSpinner milliseconds, seconds, minutes;
    protected JLabel power, back, key;
    protected JPanel panel, interval;
    private JLabel minutesLabel;
    private JLabel secondsLabel;
    private JLabel millisLabel;
    protected final Clicker clicker;
    protected boolean locked;

    // Maximum interval of 60 minutes (in milliseconds)
    private final long maximum = TimeUnit.MINUTES.toMillis(60);

    protected ClickerScreen(Clicker clicker) {
        this.clicker = clicker;
        initPanel();
        initIntervalPanel();
        initIntervalSpinner();
        initBackButton(back);
        initPowerButton();
        initKeyButton();
    }

    private void initIntervalPanel() {
        minutesLabel.setText(Messages.MINUTES.message(Settings.getInstance().getLanguage()));
        secondsLabel.setText(Messages.SECONDS.message(Settings.getInstance().getLanguage()));
        millisLabel.setText(Messages.MILLISECONDS.message(Settings.getInstance().getLanguage()));
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
        spinner.setToolTipText(Messages.SCROLL_TOOL_TIP.message(Settings.getInstance().getLanguage()));
        spinner.setModel(new SpinnerNumberModel());
        updateAppearance(spinner.getEditor());
        spinner.setUI(new BasicSpinnerUI() {
            @Override
            @Nullable
            protected Component createNextButton() {
                return null;
            }

            @Override
            @Nullable
            protected Component createPreviousButton() {
                return null;
            }
        });
        spinner.setBorder(null);
        spinner.addChangeListener(event -> SwingUtilities.invokeLater(() -> {
            if (clicker.isRunning() || !(spinner.getValue() instanceof Number)) return;
            long interval = getInterval();
            getClicker().interval(interval);
            renderInterval(interval);
        }));
        spinner.addMouseWheelListener(event -> {
            if (clicker.isRunning() || !(spinner.getValue() instanceof Number value)) return;
            spinner.setValue(value.longValue() - event.getUnitsToScroll());
        });
    }

    // renders the interval from milliseconds back to the ui
    protected void renderInterval(long interval) {
        minutes.setValue(Math.max(0, Math.min(60, TimeUnit.MILLISECONDS.toMinutes(interval))));
        seconds.setValue(Math.max(0, TimeUnit.MILLISECONDS.toSeconds(interval) % 60));
        milliseconds.setValue(Math.max(0, interval % 1000));
    }

    private void initPowerButton() {
        init(power, Images.POWER_ACTIVATE, () -> {
            clicker.setRunning(!clicker.isRunning());
            if (clicker.isRunning()) power.setIcon(Images.POWER_DEACTIVATE.getIcon());
            else power.setIcon(Images.POWER_ACTIVATE.getIcon());
            updateUIVisibility();
        });
        power.setVisible(false);
    }

    private void updateUIVisibility() {
        key.setEnabled(!clicker.isRunning());
        for (Component component : interval.getComponents()) {
            component.setEnabled(!clicker.isRunning());
        }
    }

    @Override
    protected void updateAppearance() {
        super.updateAppearance();
        updateAppearance(minutes.getEditor());
        updateAppearance(seconds.getEditor());
        updateAppearance(milliseconds.getEditor());
    }

    protected abstract void initKeyButton();
}
