package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.tasks.ShutdownHook;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.Core;

import java.io.File;

public class AutoClicker {
    public static void main(String[] args) {
        Core.init();
        Messages.init();
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}
