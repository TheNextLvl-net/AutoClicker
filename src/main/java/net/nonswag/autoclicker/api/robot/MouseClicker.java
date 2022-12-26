package net.nonswag.autoclicker.api.robot;

public class MouseClicker extends Clicker {

    public MouseClicker() {
        start();
    }

    @Override
    protected void invokeClick() {
        getRobot().mousePress(button());
        getRobot().mouseRelease(button());
    }
}
