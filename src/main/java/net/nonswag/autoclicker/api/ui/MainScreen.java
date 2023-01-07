package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;

import javax.swing.*;
import java.awt.event.MouseListener;

@Getter
public class MainScreen extends Screen {
    @Getter
    private static final MainScreen instance = new MainScreen();
    private JLabel mouse, keyboard, settings, message;
    private JPanel panel;

    private MainScreen() {
        initPanel();
        initMouse();
        initKeyboard();
        initSettings();
    }

    private void initMouse() {
        hoverMessage(mouse, message, Messages.MOUSE_TITLE);
        init(mouse, Images.MOUSE, () -> Window.init(MouseScreen.getInstance()));
    }

    private void initKeyboard() {
        for (MouseListener listener : keyboard.getMouseListeners()) keyboard.removeMouseListener(listener);
        hoverMessage(keyboard, message, Messages.KEYBOARD_TITLE);
        Images image = Settings.getInstance().getTheme().isLight() ? Images.KEYBOARD_LIGHT : Images.KEYBOARD_DARK;
        init(keyboard, image, () -> Window.init(KeyboardScreen.getInstance()));
    }

    private void initSettings() {
        hoverMessage(settings, message, Messages.SETTINGS);
        init(settings, Images.SETTINGS, () -> Window.init(SettingsScreen.getInstance()));
    }

    @Override
    protected void updateAppearance() {
        super.updateAppearance();
        initKeyboard();
    }

    @Override
    public String getTitle() {
        return Messages.TITLE.message(Settings.getInstance().getLanguage());
    }
}
