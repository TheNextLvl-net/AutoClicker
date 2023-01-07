package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.images.Images;
import net.nonswag.autoclicker.api.settings.Settings;
import net.nonswag.autoclicker.utils.Messages;
import net.nonswag.core.api.file.formats.MessageFile;
import net.nonswag.core.api.language.Language;

import javax.swing.*;
import java.awt.*;

@Getter
public class LanguageScreen extends Screen {
    @Getter
    private static final LanguageScreen instance = new LanguageScreen();
    private JScrollPane scrollPane;
    private JPanel panel, content;
    private JLabel back;

    private LanguageScreen() {
        initPanel();
        initContent();
        initBackButton(back, SettingsScreen.getInstance());
    }

    private void initContent() {
        content.setLayout(new GridLayout(Language.LIST.size(), 1, 0, 0));
        scrollPane.setForeground(panel.getBackground());
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setBorder(null);
        content.setBackground(panel.getBackground());
        ButtonGroup group = new ButtonGroup();
        Language.LIST.forEach(language -> {
            if (language.equals(Language.ROOT)) return;
            if (!MessageFile.isRegistered(language)) return;
            JRadioButton button = new JRadioButton(language.name());
            addMouseClickListener(button, language);
            button.setIcon(Images.getFlag(language));
            button.setBackground(panel.getBackground());
            button.setMargin(new Insets(0, 50, 0, 0));
            button.setFocusPainted(false);
            content.add(button);
            group.add(button);
            if (Settings.getInstance().getLanguage().equals(language)) button.setSelected(true);
        });
    }

    private void addMouseClickListener(JRadioButton button, Language language) {
        button.addChangeListener(event -> {
            if (button.isSelected()) {
                Settings.getInstance().setLanguage(language);
                button.setForeground(Color.BLUE);
            } else button.setForeground(panel.getForeground());
        });
    }

    @Override
    protected void updateAppearance() {
        super.updateAppearance();
        content.setBackground(panel.getBackground());
        for (Component component : content.getComponents()) component.setBackground(panel.getBackground());
    }

    @Override
    public String getTitle() {
        return Messages.LANGUAGE_TITLE.message(Settings.getInstance().getLanguage());
    }
}
