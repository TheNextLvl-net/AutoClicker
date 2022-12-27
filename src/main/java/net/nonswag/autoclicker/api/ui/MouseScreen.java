package net.nonswag.autoclicker.api.ui;

import lombok.Getter;
import net.nonswag.autoclicker.api.robot.MouseClicker;
import net.nonswag.core.api.annotation.FieldsAreNonnullByDefault;
import net.nonswag.core.api.annotation.MethodsReturnNonnullByDefault;

@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MouseScreen extends ClickerScreen {
    @Getter
    private static final MouseScreen instance = new MouseScreen();

    private MouseScreen() {
        super(new MouseClicker());
    }
}
