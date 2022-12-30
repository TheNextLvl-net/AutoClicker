package net.nonswag.autoclicker.api.settings;

import java.awt.*;

public enum Theme {
    NIGHT, LIGHT;

    public boolean isLight() {
        return equals(LIGHT);
    }

    public Color getColor() {
        return isLight() ? Color.WHITE : new Color(20, 20, 20);
    }
}
