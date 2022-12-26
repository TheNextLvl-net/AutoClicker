package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.io.IOException;
import java.net.URL;

@Getter
@FieldsAreNonnullByDefault
public class MouseScreen {
    private JPanel panel;
    private JEditorPane editorPane;

    public MouseScreen() {
        initEditorPane();
    }

    private void initEditorPane() {
        StyleSheet styles = new StyleSheet();
        styles.addRule("body { font-size: 14pt; }");

        HTMLEditorKit kit = new HTMLEditorKit();
        kit.setStyleSheet(styles);

        editorPane.setContentType("text/html");
        editorPane.setText("<html><body>Some text</body></html>");
        editorPane.setEditorKit(kit);
    }


}
