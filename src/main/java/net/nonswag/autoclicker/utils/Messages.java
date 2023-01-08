package net.nonswag.autoclicker.utils;

import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;
import net.nonswag.core.api.file.formats.MessageFile;
import net.nonswag.core.api.language.Language;
import net.nonswag.core.api.message.key.MessageKey;

import javax.annotation.ParametersAreNonnullByDefault;

@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Messages {
    private static final MessageFile ENGLISH = MessageFile.getOrCreate(Language.AMERICAN_ENGLISH);
    private static final MessageFile GERMAN = MessageFile.getOrCreate(Language.GERMAN);

    public static final MessageKey TITLE = new MessageKey("title").register();
    public static final MessageKey START = new MessageKey("start").register();
    public static final MessageKey STOP = new MessageKey("stop").register();
    public static final MessageKey MODE = new MessageKey("mode").register();
    public static final MessageKey LIGHT = new MessageKey("light").register();
    public static final MessageKey NIGHT = new MessageKey("night").register();
    public static final MessageKey BUTTON = new MessageKey("button").register();
    public static final MessageKey ACTIVE = new MessageKey("active").register();
    public static final MessageKey INACTIVE = new MessageKey("inactive").register();
    public static final MessageKey LANGUAGE = new MessageKey("language").register();
    public static final MessageKey SETTINGS = new MessageKey("settings").register();
    public static final MessageKey APPEARANCE = new MessageKey("appearance").register();
    public static final MessageKey MOUSE_TITLE = new MessageKey("mouse-title").register();
    public static final MessageKey ALWAYS_ON_TOP = new MessageKey("always-on-top").register();
    public static final MessageKey KEYBOARD_TITLE = new MessageKey("keyboard-title").register();
    public static final MessageKey SETTINGS_TITLE = new MessageKey("settings-title").register();
    public static final MessageKey LANGUAGE_TITLE = new MessageKey("language-title").register();
    public static final MessageKey CLICK_INTERVAL = new MessageKey("click-interval").register();
    public static final MessageKey SCROLL_TOOL_TIP = new MessageKey("scroll-tool-tip").register();
    public static final MessageKey BUTTON_SELECTION = new MessageKey("button-selection").register();
    public static final MessageKey PRESS_MOUSE_BUTTON = new MessageKey("press-mouse-button").register();
    public static final MessageKey PRESS_KEYBOARD_BUTTON = new MessageKey("press-keyboard-button").register();

    // button translations
    public static final MessageKey FORWARD = new MessageKey("forward").register();
    public static final MessageKey BACKWARD = new MessageKey("backward").register();
    public static final MessageKey LEFT_CLICK = new MessageKey("left-click").register();
    public static final MessageKey RIGHT_CLICK = new MessageKey("right-click").register();
    public static final MessageKey MIDDLE_CLICK = new MessageKey("middle-click").register();

    // time units translations
    public static final MessageKey MINUTES = new MessageKey("minutes").register();
    public static final MessageKey SECONDS = new MessageKey("seconds").register();
    public static final MessageKey MILLISECONDS = new MessageKey("milliseconds").register();

    public static void init() {
        initEnglish();
        initGerman();
    }

    private static void initEnglish() {
        ENGLISH.setDefault(TITLE, "Main menu");
        ENGLISH.setDefault(START, "Start");
        ENGLISH.setDefault(STOP, "Stop");
        ENGLISH.setDefault(MODE, "Select the clicker mode you want to use");
        ENGLISH.setDefault(LIGHT, "Light");
        ENGLISH.setDefault(NIGHT, "Night");
        ENGLISH.setDefault(BUTTON, "Button %s");
        ENGLISH.setDefault(ACTIVE, "Active");
        ENGLISH.setDefault(INACTIVE, "Inactive");
        ENGLISH.setDefault(LANGUAGE, "Language");
        ENGLISH.setDefault(SETTINGS, "Settings");
        ENGLISH.setDefault(APPEARANCE, "Appearance");
        ENGLISH.setDefault(MOUSE_TITLE, "Mouse - Auto Clicker");
        ENGLISH.setDefault(ALWAYS_ON_TOP, "Always on top");
        ENGLISH.setDefault(KEYBOARD_TITLE, "Keyboard - Auto Clicker");
        ENGLISH.setDefault(LANGUAGE_TITLE, "Settings - Language");
        ENGLISH.setDefault(SETTINGS_TITLE, "Settings");
        ENGLISH.setDefault(CLICK_INTERVAL, "Click interval");
        ENGLISH.setDefault(SCROLL_TOOL_TIP, "Scroll to change value");
        ENGLISH.setDefault(BUTTON_SELECTION, "Button selection");
        ENGLISH.setDefault(PRESS_MOUSE_BUTTON, "Press a mouse button");
        ENGLISH.setDefault(PRESS_KEYBOARD_BUTTON, "Press a keyboard button");

        ENGLISH.setDefault(FORWARD, "Forward");
        ENGLISH.setDefault(BACKWARD, "Backward");
        ENGLISH.setDefault(LEFT_CLICK, "Left click");
        ENGLISH.setDefault(RIGHT_CLICK, "Right click");
        ENGLISH.setDefault(MIDDLE_CLICK, "Middle click");

        ENGLISH.setDefault(MINUTES, "min.");
        ENGLISH.setDefault(SECONDS, "sec.");
        ENGLISH.setDefault(MILLISECONDS, "mil.");

        ENGLISH.save();
    }

    private static void initGerman() {
        GERMAN.setDefault(TITLE, "Hauptmenü");
        GERMAN.setDefault(START, "Start");
        GERMAN.setDefault(STOP, "Stop");
        GERMAN.setDefault(MODE, "Wähle den klicker Modus, den du nutzen möchtest.");
        GERMAN.setDefault(LIGHT, "Hell");
        GERMAN.setDefault(NIGHT, "Dunkel");
        GERMAN.setDefault(BUTTON, "Taste %s");
        GERMAN.setDefault(ACTIVE, "Aktiv");
        GERMAN.setDefault(INACTIVE, "Inaktiv");
        GERMAN.setDefault(LANGUAGE, "Sprache");
        GERMAN.setDefault(SETTINGS, "Einstellungen");
        GERMAN.setDefault(APPEARANCE, "Aussehen");
        GERMAN.setDefault(MOUSE_TITLE, "Maus - Auto Klicker");
        GERMAN.setDefault(ALWAYS_ON_TOP, "Immer im fokus");
        GERMAN.setDefault(KEYBOARD_TITLE, "Tastatur - Auto Klicker");
        GERMAN.setDefault(LANGUAGE_TITLE, "Einstellungen - Sprache");
        GERMAN.setDefault(SETTINGS_TITLE, "Einstellungen");
        GERMAN.setDefault(CLICK_INTERVAL, "Klick Intervall");
        GERMAN.setDefault(SCROLL_TOOL_TIP, "Scrolle um den wert anzupassen");
        GERMAN.setDefault(BUTTON_SELECTION, "Tasten auswahl");
        GERMAN.setDefault(PRESS_MOUSE_BUTTON, "Drücke einen Maustaste");
        GERMAN.setDefault(PRESS_KEYBOARD_BUTTON, "Drücke einen Tastatur Taste");

        GERMAN.setDefault(FORWARD, "Vor");
        GERMAN.setDefault(BACKWARD, "Zurück");
        GERMAN.setDefault(LEFT_CLICK, "Links klick");
        GERMAN.setDefault(RIGHT_CLICK, "Rechts klick");
        GERMAN.setDefault(MIDDLE_CLICK, "Mittel klick");

        GERMAN.setDefault(MINUTES, "min.");
        GERMAN.setDefault(SECONDS, "sek.");
        GERMAN.setDefault(MILLISECONDS, "mil.");

        GERMAN.save();
    }

    public static String mouseButton(Language language, int id) {
        return switch (id) {
            case 1 -> LEFT_CLICK.message(language);
            case 3 -> RIGHT_CLICK.message(language);
            case 2 -> MIDDLE_CLICK.message(language);
            case 4, 6 -> BACKWARD.message(language);
            case 5, 7 -> FORWARD.message(language);
            default -> BUTTON.message(language).formatted(id);
        };
    }
}
