package net.nonswag.autoclicker.api.robot;

import lombok.*;
import lombok.experimental.Accessors;

import java.awt.*;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Clicker extends Thread {
    @Getter(AccessLevel.PROTECTED)
    private final Robot robot;
    @Accessors(fluent = true)
    private int button;
    @Accessors(fluent = true)
    private long interval;

    @Override
    public void run() {
        try {
            while (isAlive()) {
                sleep(interval());
                click();
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    public void click() {
        getRobot().keyPress(button());
        getRobot().keyRelease(button());
    }
}
