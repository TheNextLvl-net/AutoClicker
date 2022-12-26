package net.nonswag.autoclicker.api.robot;

public class KeyboardClicker extends Clicker {

    private KeyboardClicker() {
        start();
    }

    @Override
    protected void invokeClick() {
        getRobot().keyPress(button());
        getRobot().keyRelease(button());
    }
}
