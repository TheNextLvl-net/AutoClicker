package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.settings.Theme;
import net.nonswag.autoclicker.utils.Messages;

import javax.swing.*;
import java.awt.event.MouseListener;

@Getter
public class SettingsScreen extends Screen {
    @Getter
    private static final SettingsScreen instance = new SettingsScreen();
    private JPanel panel;
    private JLabel back;
    private JLabel appearance;
    private JLabel language;

    private SettingsScreen() {
       initPanel();
       initBackButton(back);
       initAppearance(Settings.getInstance().getTheme());
    }

    private void initAppearance(Theme theme) {
        init(appearance, theme.isLight() ? Images.INDICATOR_DARK : Images.INDICATOR_LIGHT, () -> {
            for (MouseListener listener : appearance.getMouseListeners()) appearance.removeMouseListener(listener);
            Settings.getInstance().setTheme(theme.isLight() ? Theme.NIGHT : Theme.LIGHT);
            initAppearance(Settings.getInstance().getTheme());
            KeyboardScreen.getInstance().updateAppearance();
            MouseScreen.getInstance().updateAppearance();
            MainScreen.getInstance().updateAppearance();
            updateAppearance();
        });
    }

    @Override
    public String getTitle() {
        return Messages.SETTINGS_TITLE.message(Settings.getInstance().getLanguage());
    }
}
