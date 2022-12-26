package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.tasks.ShutdownHook;
import net.nonswag.autoclicker.api.ui.MainScreen;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.Core;

public class AutoClicker {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        Core.init();
        Messages.init();
        Window.init(MainScreen.getInstance());
    }
}
