package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.Screen;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNullableByDefault;

import javax.swing.*;

@FieldsAreNullableByDefault
public class Window {
    private static JFrame frame;

    public static void init(Screen screen) {
        JFrame frame = getOrCreateFrame();
        frame.setContentPane(screen.getPanel());
        frame.setResizable(screen.isResizable());
        frame.setPreferredSize(screen.getPreferredSize());
        frame.setMinimumSize(screen.getMinimumSize());
        frame.pack();
        if (Window.frame == null) frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Window.frame = frame;
    }

    private static JFrame getOrCreateFrame() {
        if (frame != null) return frame;
        frame = new JFrame(Messages.TITLE.message(Settings.getInstance().getLanguage()));
        frame.setIconImage(Images.ICON.getIcon().getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }
}
