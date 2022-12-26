package net.nonswag.autoclicker.api.settings;

public enum Theme {
    NIGHT, LIGHT;

    public boolean isLight() {
        return equals(LIGHT);
    }
}
