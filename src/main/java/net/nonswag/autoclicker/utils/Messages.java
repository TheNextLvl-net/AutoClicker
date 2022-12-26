package net.nonswag.autoclicker.utils;

import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.message.Message;
import net.nonswag.core.api.message.key.MessageKey;

@FieldsAreNonnullByDefault
public class Messages {
    public static final MessageKey TITLE = new MessageKey("title").register();
    public static final MessageKey START = new MessageKey("start").register();
    public static final MessageKey STOP = new MessageKey("stop").register();
    public static final MessageKey MODE = new MessageKey("mode").register();
    public static final MessageKey BUTTON_SELECTION = new MessageKey("button-selection").register();
    public static final MessageKey PRESS_MOUSE_BUTTON = new MessageKey("press-mouse-button").register();
    public static final MessageKey PRESS_KEYBOARD_BUTTON = new MessageKey("press-keyboard-button").register();
    public static final MessageKey MOUSE_BUTTON = new MessageKey("mouse-button").register();
    public static final MessageKey CLICK_INTERVAL = new MessageKey("click-interval").register();

    public static void init() {
        initEnglish();
        initGerman();
    }

    private static void initEnglish() {
        Message.getEnglish().setDefault(TITLE, "Auto Clicker");
        Message.getEnglish().setDefault(START, "Start");
        Message.getEnglish().setDefault(STOP, "Stop");
        Message.getEnglish().setDefault(MODE, "Select the clicker mode you want to use");
        Message.getEnglish().setDefault(BUTTON_SELECTION, "Button selection");
        Message.getEnglish().setDefault(PRESS_MOUSE_BUTTON, "Press a mouse button");
        Message.getEnglish().setDefault(PRESS_KEYBOARD_BUTTON, "Press a keyboard button");
        Message.getEnglish().setDefault(MOUSE_BUTTON, "Button %s");
        Message.getEnglish().setDefault(CLICK_INTERVAL, "Click interval");
        Message.getEnglish().save();
    }

    private static void initGerman() {
        Message.getGerman().setDefault(TITLE, "Auto Klicker");
        Message.getGerman().setDefault(START, "Start");
        Message.getGerman().setDefault(STOP, "Stop");
        Message.getGerman().setDefault(MODE, "Wähle den klicker Modus, den du nutzen möchtest.");
        Message.getGerman().setDefault(BUTTON_SELECTION, "Knopf auswahl");
        Message.getGerman().setDefault(PRESS_MOUSE_BUTTON, "Drücke einen Mausknopf");
        Message.getGerman().setDefault(PRESS_KEYBOARD_BUTTON, "Drücke einen Tastaturknopf");
        Message.getGerman().setDefault(MOUSE_BUTTON, "Knopf %s");
        Message.getGerman().setDefault(CLICK_INTERVAL, "Klick Intervall");
        Message.getGerman().save();
    }
}
