package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.*;

@Getter
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
public class MainScreen extends Screen {
    @Getter
    private static final MainScreen instance = new MainScreen();
    private JLabel mouse, keyboard, settings;
    private JPanel panel;

    private MainScreen() {
        initPanel();
        initMouse();
        initKeyboard();
        initSettings();
    }

    private void initMouse() {
        init(mouse, Images.MOUSE, () -> Window.init(new MouseScreen()));
    }

    private void initKeyboard() {
        Images image = Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK;
        init(keyboard, image, () -> System.out.println("keyboard"));
    }

    private void initSettings() {
        init(settings, Images.SETTINGS, () -> System.out.println("settings"));
    }
}
