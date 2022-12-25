package net.nonswag.autoclicker.utils;

import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.message.Message;
import net.nonswag.core.api.message.key.MessageKey;

@FieldsAreNonnullByDefault
public class Messages {
    public static final MessageKey TITLE = new MessageKey("title").register();
    public static final MessageKey START = new MessageKey("start").register();
    public static final MessageKey STOP = new MessageKey("stop").register();
    public static final MessageKey CLICK_INTERVAL = new MessageKey("click-interval").register();

    public static void init() {
        initEnglish();
        initGerman();
    }

    private static void initEnglish() {
        Message.getEnglish().setDefault(TITLE, "Auto Clicker");
        Message.getEnglish().setDefault(START, "Start");
        Message.getEnglish().setDefault(STOP, "Stop");
        Message.getEnglish().setDefault(CLICK_INTERVAL, "Click interval");
        Message.getEnglish().save();
    }

    private static void initGerman() {
        Message.getGerman().setDefault(TITLE, "Auto Klicker");
        Message.getGerman().setDefault(START, "Start");
        Message.getGerman().setDefault(STOP, "Stop");
        Message.getGerman().setDefault(CLICK_INTERVAL, "Klick Intervall");
        Message.getGerman().save();
    }
}
