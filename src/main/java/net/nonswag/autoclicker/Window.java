package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.Screen;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.annotation.Nullable;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@FieldsAreNonnullByDefault
public class Window {
    @Nullable
    private static JFrame frame;
    private static int historyLocation;
    private static final List<Screen> history = new ArrayList<>();
    private static final MouseAdapter adapter = new MouseAdapter() {
        @Override
        @SuppressWarnings("MagicConstant")
        public void mousePressed(MouseEvent event) {
            if (event.getModifiersEx() == 131072) { // forwards
                if (history.size() <= historyLocation) return;
                init(history.get(historyLocation++), false);
            } else if (event.getModifiersEx() == 65536) { // backwards
                if (history.size() < 2 || historyLocation <= 1) return;
                init(history.get(historyLocation-- - 2), false);
            }
        }
    };

    public static void init(Screen screen) {
        init(screen, true);
    }

    public static void init(Screen screen, boolean appendHistory) {
        JFrame frame = getOrCreateFrame();
        frame.setTitle(screen.getTitle());
        frame.setContentPane(screen.getPanel());
        frame.setResizable(screen.isResizable());
        frame.setPreferredSize(screen.getPreferredSize());
        frame.setMinimumSize(screen.getMinimumSize());
        frame.pack();
        addGeneralMouseListener(screen);
        if (Window.frame == null) frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Window.frame = frame;
        if (!appendHistory) return;
        while (history.size() > historyLocation) history.remove(history.size() - 1);
        while (history.size() >= 5) history.remove(0);
        history.add(screen);
        historyLocation = history.size();
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

    private static void addGeneralMouseListener(Screen screen) {
        if (hasGeneralMouseListener(screen)) return;
        screen.getPanel().addMouseListener(adapter);
    }

    private static boolean hasGeneralMouseListener(Screen screen) {
        for (MouseListener listener : screen.getPanel().getMouseListeners()) {
            if (listener.equals(adapter)) return true;
        }
        return false;
    }
}
