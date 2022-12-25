package net.nonswag.autoclicker.api.images;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Getter
@RequiredArgsConstructor
@FieldsAreNonnullByDefault
public enum Images {
    MOUSE_DARK("images/dark/mouse.png"),
    MOUSE_LIGHT("images/light/mouse.png"),
    KEYBOARD_DARK("images/dark/keyboard.png"),
    KEYBOARD_LIGHT("images/light/keyboard.png"),
    SETTINGS_DARK("images/dark/settings.png"),
    SETTINGS_LIGHT("images/light/settings.png");

    private final String location;
    private final BufferedImage image = loadImage();

    private BufferedImage loadImage() throws IllegalStateException {
        InputStream resource = getClass().getResourceAsStream(getLocation());
        if (resource != null) try {
            return ImageIO.read(resource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        else throw new IllegalStateException("resource not found: " + getLocation());
    }
}
