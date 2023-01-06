package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.robot.MouseClicker;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseScreen extends ClickerScreen {
    @Getter
    private static final MouseScreen instance = new MouseScreen();

    private MouseScreen() {
        super(new MouseClicker());
    }

    @Override
    protected void initKeyButton() {
        key.setText(Messages.BUTTON_SELECTION.message(Settings.getInstance().getLanguage()));
        init(key, Images.MOUSE_SELECTION, () -> {
            if (locked) return;
            power.setVisible(false);
            interval.setVisible(false);
            key.setText(Messages.PRESS_MOUSE_BUTTON.message(Settings.getInstance().getLanguage()));
            key.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent event) {
                    getClicker().button(event.getModifiersEx());
                    key.setText(Messages.mouseButton(Settings.getInstance().getLanguage(), event.getButton()));
                    key.removeMouseListener(this);
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
        return Messages.MOUSE_TITLE.message(Settings.getInstance().getLanguage());
    }
}
