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
    private JLabel mouse, keyboard;
    private JPanel panel;

    public MainScreen() {
        mouse.setIcon((Settings.getInstance().getTheme().isLight() ? Images.MOUSE_LIGHT : Images.MOUSE_DARK).getIcon());
        keyboard.setIcon((Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK).getIcon());
        panel.setBackground(Settings.getInstance().getTheme().isLight() ? Color.WHITE : Color.BLACK);
    }
}
