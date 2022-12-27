package net.nonswag.autoclicker.api.robot;

public class KeyboardClicker extends Clicker {

    public KeyboardClicker() {
        start();
    }

    @Override
    protected void invokeClick() {
        getRobot().keyPress(button());
        getRobot().keyRelease(button());
    }
}
