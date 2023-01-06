package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.settings.Theme;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.language.Language;

import javax.swing.*;
import java.awt.event.MouseListener;

import static net.nonswag.autoclicker.utils.Messages.*;

@Getter
public class SettingsScreen extends Screen {
    @Getter
    private static final SettingsScreen instance = new SettingsScreen();
    private JPanel panel;
    private JLabel back;
    private JLabel appearance;
    private JLabel language;
    private JLabel onTop;
    private JLabel message;
    private JLabel value;

    private SettingsScreen() {
       initPanel();
       initBackButton(back);
       initAppearance(Settings.getInstance().getTheme());
       initAlwaysOnTop(Settings.getInstance().isAlwaysOnTop());
       initLanguage(Settings.getInstance().getLanguage());
    }

    private void initLanguage(Language language) {
        hoverMessage(this.language, message, value, LANGUAGE, language.name());
        init(this.language, Images.LANGUAGE, () -> Window.init(LanguageScreen.getInstance()));
    }

    private void initAlwaysOnTop(boolean alwaysOnTop) {
        hoverMessage(onTop, message, value, ALWAYS_ON_TOP, alwaysOnTop ? ACTIVE : INACTIVE);
        init(onTop, alwaysOnTop ? Images.ARROW_UP : Images.ARROW_DOWN, () -> {
            SettingsScreen.this.value.setText((alwaysOnTop ? INACTIVE : ACTIVE).message(Settings.getInstance().getLanguage()));
            for (MouseListener listener : onTop.getMouseListeners()) onTop.removeMouseListener(listener);
            Settings.getInstance().setAlwaysOnTop(!alwaysOnTop);
            Window.setAlwaysOnTop(Settings.getInstance().isAlwaysOnTop());
            initAlwaysOnTop(Settings.getInstance().isAlwaysOnTop());
        });
    }

    private void initAppearance(Theme theme) {
        hoverMessage(appearance, message, value, APPEARANCE, theme.isLight() ? LIGHT : NIGHT);
        init(appearance, theme.isLight() ? Images.INDICATOR_DARK : Images.INDICATOR_LIGHT, () -> {
            SettingsScreen.this.value.setText((theme.isLight() ? NIGHT : LIGHT).message(Settings.getInstance().getLanguage()));
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
