package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import lombok.Setter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.KeyboardClicker;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.language.Language;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardScreen extends ClickerScreen implements Cloneable {
    @Getter
    @Setter
    private static KeyboardScreen instance = new KeyboardScreen();

    private KeyboardScreen() {
        super(new KeyboardClicker());
    }

    @Override
    protected void initKeyButton() {
        key.setText(Messages.BUTTON_SELECTION.message(Settings.getInstance().getLanguage()));
        init(key, Images.KEY_SELECTION, () -> {
            if (locked) return;
            key.grabFocus();
            power.setVisible(false);
            interval.setVisible(false);
            key.setText(Messages.PRESS_KEYBOARD_BUTTON.message(Settings.getInstance().getLanguage()));
            key.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent event) {
                    if (KeyEvent.CHAR_UNDEFINED == event.getKeyChar()) return;
                    getClicker().button(event.getKeyCode());
                    Language language = Settings.getInstance().getLanguage();
                    key.setText(Messages.BUTTON.message(language).formatted(event.getKeyChar()));
                    key.removeKeyListener(this);
                    interval.setVisible(true);
                    power.setVisible(true);
                    locked = false;
                }
            });
            locked = true;
        });
    }

    @Override
    public String getTitle() {
        return Messages.KEYBOARD_TITLE.message(Settings.getInstance().getLanguage());
    }

    @Override
    public KeyboardScreen clone() {
        try {
            KeyboardScreen clone = (KeyboardScreen) super.clone();
            clone.initPanel();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
