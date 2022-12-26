package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
public class MainScreen {
    private JLabel mouse, keyboard, settings;
    private JPanel panel;

    public MainScreen() {
        initPanel();
        initMouse();
        initKeyboard();
        initSettings();
    }

    private void initPanel() {
        panel.setBackground(Settings.getInstance().getTheme().isLight() ? Color.WHITE : new Color(20, 20, 20));
    }

    private void initMouse() {
        init(mouse, Images.MOUSE, () -> System.out.println("mouse"));
    }

    private void initKeyboard() {
        Images image = Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK;
        init(keyboard, image, () -> System.out.println("keyboard"));
    }

    private void initSettings() {
        init(settings, Images.SETTINGS, () -> System.out.println("settings"));
    }

    private void init(JLabel label, Images image, Runnable runnable) {
        label.setBackground(panel.getBackground());
        label.setIcon(image.getIcon());
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (MouseEvent.BUTTON1 == event.getButton()) runnable.run();
            }
        });
    }
}
