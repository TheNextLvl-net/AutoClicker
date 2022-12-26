package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.MouseClicker;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.language.Language;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
@FieldsAreNonnullByDefault
public class MouseScreen extends Screen {
    @Getter
    private static final MouseScreen instance = new MouseScreen();
    private final MouseClicker clicker = new MouseClicker();
    private JLabel power, back, key;
    private JPanel panel;
    private boolean locked;

    private MouseScreen() {
        initPanel();
        initBackButton();
        initPowerButton();
        initKeyButton();
    }

    private void initBackButton() {
        init(back, Images.BACK, () -> Window.init(MainScreen.getInstance()));
        back.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(10, 10, 10, 10)));
    }

    private void initPowerButton() {
        init(power, Images.POWER_ACTIVATE, () -> {
            clicker.setRunning(!clicker.isRunning());
            if (clicker.isRunning()) power.setIcon(Images.POWER_DEACTIVATE.getIcon());
            else power.setIcon(Images.POWER_ACTIVATE.getIcon());
        });
        power.setVisible(false);
    }

    private void initKeyButton() {
        key.setText(Messages.BUTTON_SELECTION.message(Settings.getInstance().getLanguage()));
        init(key, Images.KEY_SELECTION, () -> {
            if (locked) return;
            power.setVisible(false);
            key.setText(Messages.PRESS_MOUSE_BUTTON.message(Settings.getInstance().getLanguage()));
            key.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent event) {
                    getClicker().button(event.getModifiersEx());
                    Language language = Settings.getInstance().getLanguage();
                    key.setText(Messages.MOUSE_BUTTON.message(language).formatted(event.getButton()));
                    key.removeMouseListener(this);
                    power.setVisible(true);
                    locked = false;
                }
            });
            locked = true;
        });
    }
}
