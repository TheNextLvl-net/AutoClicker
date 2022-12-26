package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.Screen;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.swing.*;

@FieldsAreNonnullByDefault
public class Window {
    public static final JFrame FRAME = new JFrame(Messages.TITLE.message(Settings.getInstance().getLanguage()));

    static {
        FRAME.setIconImage(Images.ICON.getIcon().getImage());
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void init(Screen screen) {
        FRAME.setContentPane(screen.getPanel());
        FRAME.setResizable(screen.isResizable());
        FRAME.setPreferredSize(screen.getPreferredSize());
        FRAME.setMinimumSize(screen.getMinimumSize());
        FRAME.pack();
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
    }
}
