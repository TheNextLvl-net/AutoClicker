package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.KeyboardClicker;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;
import net.nonswag.core.api.language.Language;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class KeyboardScreen extends ClickerScreen {
    @Getter
    private static final KeyboardScreen instance = new KeyboardScreen();

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
                    getClicker().button(event.getKeyCode());
                    Language language = Settings.getInstance().getLanguage();
                    System.out.println((int) event.getKeyChar());
                    System.out.println(KeyEvent.CHAR_UNDEFINED);
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
}
