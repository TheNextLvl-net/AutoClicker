package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.*;

@Getter
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
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
        init(mouse, Images.MOUSE, () -> Window.init(MouseScreen.getInstance()));
    }

    private void initKeyboard() {
        Images image = Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK;
        init(keyboard, image, () -> Window.init(KeyboardScreen.getInstance()));
    }

    private void initSettings() {
        init(settings, Images.SETTINGS, () -> System.out.println("settings"));
    }

    @Override
    public String getTitle() {
        return Messages.TITLE.message(Settings.getInstance().getLanguage());
    }
}
