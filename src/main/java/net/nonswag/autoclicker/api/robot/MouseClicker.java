package net.nonswag.autoclicker.api.robot;

import java.awt.*;

public class MouseClicker extends Clicker {

    public MouseClicker() throws AWTException {
        super(new Robot());
    }
}
