package net.nonswag.autoclicker.api.ui;

import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class Screen {
    public abstract JPanel getPanel();

    protected void initPanel() {
        getPanel().setBackground(Settings.getInstance().getTheme().isLight() ? Color.WHITE : new Color(20, 20, 20));
        getPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent event) {
                if (!getPanel().contains(event.getPoint())) return;
                MouseScreen.getInstance().getClicker().canClick(false);
                // TODO: 26.12.22 the same for the keyboard screen
            }

            @Override
            public void mouseExited(MouseEvent event) {
                if (getPanel().contains(event.getPoint())) return;
                MouseScreen.getInstance().getClicker().canClick(true);
                // TODO: 26.12.22 the same for the keyboard screen
            }
        });
    }

    protected void init(JLabel label, Images image, Runnable runnable) {
        label.setBackground(getPanel().getBackground());
        label.setIcon(image.getIcon());
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (MouseEvent.BUTTON1 == event.getButton()) runnable.run();
            }
        });
    }

    public boolean isResizable() {
        return true;
    }

    public Dimension getMinimumSize() {
        return new Dimension(500, 300);
    }

    public Dimension getPreferredSize() {
        return getMinimumSize();
    }
}
