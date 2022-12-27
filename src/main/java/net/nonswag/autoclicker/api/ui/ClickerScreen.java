package net.nonswag.autoclicker.api.ui;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.Clicker;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

@Getter
@FieldsAreNonnullByDefault
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ClickerScreen extends Screen {
    protected final Clicker clicker;
    protected JLabel power, back, key;
    protected JPanel panel;
    protected boolean locked;

    {
        initPanel();
        initBackButton();
        initPowerButton();
        initKeyButton();
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
        });
        power.setVisible(false);
    }

    protected abstract void initKeyButton();
}
