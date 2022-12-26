package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.MainScreen;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;
import java.awt.*;

@FieldsAreNonnullByDefault
public class Window {
    public static final JFrame FRAME = new JFrame(Messages.TITLE.message(Settings.getInstance().getLanguage()));

    static void init() {
        FRAME.setLocationRelativeTo(null);
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FRAME.setContentPane(new MainScreen().getPanel());
        FRAME.setPreferredSize(new Dimension(300, 200));
        FRAME.setResizable(false);
        FRAME.pack();
        FRAME.setVisible(true);
    }
}
