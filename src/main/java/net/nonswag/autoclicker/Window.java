package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.Screen;
import net.nonswag.core.api.annotation.FieldsAreNullableByDefault;

import javax.swing.*;

@FieldsAreNullableByDefault
public class Window {
    private static JFrame frame;

    public static void init(Screen screen) {
        JFrame frame = getOrCreateFrame();
        frame.setTitle(screen.getTitle());
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
        JFrame frame = new JFrame();
        frame.setIconImage(Images.ICON.getIcon().getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(Settings.getInstance().isAlwaysOnTop());
        return frame;
    }

    public static void setAlwaysOnTop(boolean alwaysOnTop) {
        if (frame != null) frame.setAlwaysOnTop(alwaysOnTop);
    }
}
