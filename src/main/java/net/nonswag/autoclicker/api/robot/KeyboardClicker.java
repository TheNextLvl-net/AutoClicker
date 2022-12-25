package net.nonswag.autoclicker.api.robot;

import java.awt.*;

public class KeyboardClicker extends Clicker {

    public KeyboardClicker() throws AWTException {
        super(new Robot());
    }
}
