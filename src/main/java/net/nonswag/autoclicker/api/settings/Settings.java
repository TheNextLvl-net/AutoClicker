package net.nonswag.autoclicker.api.settings;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.nonswag.autoclicker.api.ui.Theme;
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
    private Language language;
    private Theme theme;

    public Settings(String file) {
        this(new File(file));
    }

    public Settings(String path, String file) {
        this(new File(path, file));
    }

    public Settings(File file) {
        super(file);
        JsonObject root = getJsonElement().getAsJsonObject();
        String[] split = root.get("language").getAsString().split(", ");
        language = new Language(split[0], split[1]);
        theme = Theme.valueOf(root.get("theme").getAsString());
    }

    public void export() {
        JsonObject root = new JsonObject();
        root.addProperty("language", getLanguage().toString());
        root.addProperty("theme", getTheme().name());
        setJsonElement(root);
        save();
    }
}
