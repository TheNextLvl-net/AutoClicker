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
    MOUSE_DARK("images/dark/mouse.png", 64),
    MOUSE_LIGHT("images/light/mouse.png", 64),
    KEYBOARD_DARK("images/dark/keyboard.png", 64),
    KEYBOARD_LIGHT("images/light/keyboard.png", 64),
    SETTINGS_DARK("images/dark/settings.png", 64),
    SETTINGS_LIGHT("images/light/settings.png", 64);

    private final String location;
    private final Icon icon;
    private final int size;

    Images(String location, int size) {
        this.location = location;
        this.size = size;
        this.icon = loadIcon();
    }

    private Icon loadIcon() throws IllegalStateException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream(getLocation());
        if (resource != null) try {
            return new ImageIcon(ImageIO.read(resource).getScaledInstance(getSize(), getSize(), Image.SCALE_DEFAULT));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        else throw new IllegalStateException("resource not found: " + getLocation());
    }
}
