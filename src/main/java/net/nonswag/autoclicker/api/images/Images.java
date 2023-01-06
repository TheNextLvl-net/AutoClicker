package net.nonswag.autoclicker.api.images;

import lombok.Getter;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

@Getter
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public enum Images {
    KEY_SELECTION("images/key-selection.png", 24),
    MOUSE_SELECTION("images/mouse-selection.png", 25),
    POWER_ACTIVATE("images/power-activate.png", 64),
    POWER_DEACTIVATE("images/power-deactivate.png", 64),
    BACK("images/back.png", 32),
    MOUSE("images/mouse.png", 64),
    KEYBOARD_LIGHT("images/light/keyboard.png", 64),
    KEYBOARD_DARK("images/dark/keyboard.png", 64),
    SETTINGS("images/settings.png", 64),
    INDICATOR_LIGHT("images/light/indicator.png", 48),
    INDICATOR_DARK("images/dark/indicator.png", 48),
    LANGUAGE("images/language.png", 48),
    ARROW_UP("images/arrow-down.png", 48),
    ARROW_DOWN("images/arrow-up.png", 48),
    ICON("images/icon.png", 64);

    private final String location;
    private final ImageIcon icon;
    private final int size;

    Images(String location, int size) {
        this.location = location;
        this.size = size;
        this.icon = loadIcon();
    }

    private ImageIcon loadIcon() throws IllegalStateException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream(getLocation());
        if (resource != null) try {
            return new ImageIcon(ImageIO.read(resource).getScaledInstance(getSize(), getSize(), Image.SCALE_DEFAULT));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        else throw new IllegalStateException("resource not found: " + getLocation());
    }
}
