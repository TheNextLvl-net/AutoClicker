package net.nonswag.autoclicker;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.api.ui.MainScreen;
import net.nonswag.autoclicker.api.ui.MouseScreen;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

@FieldsAreNonnullByDefault
public class Window {
    public static final JFrame FRAME = new JFrame(Messages.TITLE.message(Settings.getInstance().getLanguage()));

    static void init() {
        FRAME.setIconImage(Images.ICON.getIcon().getImage());
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FRAME.setContentPane(new MouseScreen().getPanel());
        FRAME.setResizable(false);
        Dimension size = FRAME.getPreferredSize();
        FRAME.setPreferredSize(new Dimension(size.width + 300, size.height + 200));
        FRAME.pack();
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
    }
}
