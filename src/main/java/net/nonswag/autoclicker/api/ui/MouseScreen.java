package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.MouseClicker;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
@FieldsAreNonnullByDefault
public class MouseScreen extends Screen {
    private final MouseClicker clicker;
    private JPanel panel;
    private JLabel button, back;

    {
        try {
            clicker = new MouseClicker();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public MouseScreen() {
        initPanel();
        init(back, Images.BACK, () -> Window.init(MainScreen.getInstance()));
        init(button, Images.POWER_ACTIVATE, () -> {
            if (clicker.isAlive()) {
                button.setIcon(Images.POWER_DEACTIVATE.getIcon());
                clicker.interrupt();
            } else {
                button.setIcon(Images.POWER_ACTIVATE.getIcon());
                clicker.start();
            }
        });
        back.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(10, 10, 10, 10)));
    }
}
