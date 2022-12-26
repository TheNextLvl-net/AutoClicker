package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;
import java.awt.*;

@Getter
@FieldsAreNonnullByDefault
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
        init(mouse, Images.MOUSE);
    }

    private void initKeyboard() {
        init(keyboard, Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK);
    }

    private void initSettings() {
        init(settings, Images.SETTINGS);
    }

    private void init(JLabel label, Images image) {
        label.setBackground(panel.getBackground());
        label.setIcon(image.getIcon());
        label.setOpaque(true);
    }
}
