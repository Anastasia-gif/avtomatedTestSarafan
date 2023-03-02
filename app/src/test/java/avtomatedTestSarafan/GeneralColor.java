package avtomatedTestSarafan;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.awt.*;
import org.openqa.selenium.support.Color;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class GeneralColor {
    public static final Color GREEN = Color.fromString("rgba(18, 172, 58, 1)");
    public static final String ORANGE = "rgba(255, 138, 0, 1)";
    public static final Color BLACK = Color.fromString("rgba(44, 40, 40, 1)");
    public static final String WHITE = "rgba(255, 255, 255, 1)";
    public static final String LIGHTORANGE = "rgba(255, 212, 161, 1)";
    public static final String GRAY = "rgba(175, 175, 175, 1)";
    public static final Color DARKGRAY = Color.fromString("rgba(122, 122, 122, 1)");
}
