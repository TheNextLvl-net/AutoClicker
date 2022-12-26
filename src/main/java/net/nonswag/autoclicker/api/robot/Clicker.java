package net.nonswag.autoclicker.api.robot;

import lombok.*;
import lombok.experimental.Accessors;
import net.nonswag.core.api.math.Range;

import java.awt.*;

@Getter
@Setter
public abstract class Clicker extends Thread {
    @Getter(AccessLevel.PROTECTED)
    private final Robot robot;
    @Accessors(fluent = true)
    private int button;
    @Range(from = 1)
    @Accessors(fluent = true)
    private long interval = 1000;
    private boolean running;
    @Accessors(fluent = true)
    private boolean canClick;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Your system does not allow robots", e);
        }
    }

    @Override
    public void run() {
        try {
            while (isAlive()) {
                if (!isRunning() || !canClick()) continue;
                invokeClick();
                sleep(interval());
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    protected abstract void invokeClick();
}
