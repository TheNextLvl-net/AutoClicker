package net.nonswag.autoclicker.api.settings;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.file.formats.JsonFile;
import net.nonswag.core.api.language.Language;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;

@Getter
@Setter
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
public class Settings extends JsonFile {
    @Getter
    private static final Settings instance = new Settings(".saves");
    private Language language = Language.AMERICAN_ENGLISH;
    private Theme theme = Theme.NIGHT;
    private boolean alwaysOnTop = true;

    public Settings(String file) {
        this(new File(file));
    }

    public Settings(File file) {
        super(file);
        JsonObject root = getRoot().getAsJsonObject();
        if (!root.has("language")) root.addProperty("language", language.toString());
        if (!root.has("theme")) root.addProperty("theme", theme.name());
        if (!root.has("always-on-top")) root.addProperty("always-on-top", alwaysOnTop);
        String[] split = root.get("language").getAsString().split(", ");
        language = new Language(split[0], split[1]);
        theme = Theme.valueOf(root.get("theme").getAsString());
        alwaysOnTop = root.get("always-on-top").getAsBoolean();
    }

    public void export() {
        JsonObject root = new JsonObject();
        root.addProperty("language", getLanguage().toString());
        root.addProperty("theme", getTheme().name());
        root.addProperty("always-on-top", isAlwaysOnTop());
        setRoot(root).save();
    }
}
