package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

@Getter
public class SettingsScreen extends Screen {
    @Getter
    private static final SettingsScreen instance = new SettingsScreen();
    private JPanel panel;
    private JLabel back;

    private SettingsScreen() {
       initPanel();
       initBackButton();
    }

    private void initBackButton() {
        init(back, Images.BACK, () -> Window.init(MainScreen.getInstance()));
        back.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(10, 10, 10, 10)));
    }



    @Override
    public String getTitle() {
        return Messages.SETTINGS_TITLE.message(Settings.getInstance().getLanguage());
    }
}
