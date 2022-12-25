package net.nonswag.autoclicker.api.tasks;

import net.nonswag.autoclicker.api.settings.Settings;

public class ShutdownHook extends Thread {
    @Override
    public void run() {
        Settings.getInstance().export();
    }
}
