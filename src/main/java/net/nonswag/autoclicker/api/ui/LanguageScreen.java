package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;

import javax.swing.*;

@Getter
public class LanguageScreen extends Screen {
    @Getter
    private static final LanguageScreen instance = new LanguageScreen();
    private JPanel panel;
    private JLabel back;

    private LanguageScreen() {
        initPanel();
        initBackButton(back, SettingsScreen.getInstance());
    }

    @Override
    public String getTitle() {
        return Messages.LANGUAGE_TITLE.message(Settings.getInstance().getLanguage());
    }
}
