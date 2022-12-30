package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import lombok.Setter;
import net.nonswag.autoclicker.Window;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
@Setter
public abstract class Screen {
    private Dimension minimumSize = new Dimension(500, 300);
    private Dimension preferredSize = getMinimumSize();
    public abstract JPanel getPanel();
    private boolean resizable;

    protected void initPanel() {
        updateAppearance();
        getPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent event) {
                if (!getPanel().contains(event.getPoint())) return;
                MouseScreen.getInstance().getClicker().canClick(false);
                KeyboardScreen.getInstance().getClicker().canClick(false);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                if (getPanel().contains(event.getPoint())) return;
                MouseScreen.getInstance().getClicker().canClick(true);
                KeyboardScreen.getInstance().getClicker().canClick(true);
            }
        });
    }

    protected void initBackButton(JLabel label) {
        init(label, Images.BACK, () -> Window.init(MainScreen.getInstance()));
        label.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(10, 10, 10, 10)));
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

    protected void updateAppearance() {
        getPanel().setBackground(Settings.getInstance().getTheme().getColor());
        for (Component component : getPanel().getComponents()) component.setBackground(getPanel().getBackground());
    }

    public abstract String getTitle();
}
