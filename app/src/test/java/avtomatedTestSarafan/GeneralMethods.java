package avtomatedTestSarafan;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class GeneralMethods {

    public List<String> getStylesFont(WebElement elem){
        String fontFamily = elem.getCssValue("font-family");
        String fontSize = elem.getCssValue("font-size");
        String fontWeight = elem.getCssValue("font-weight");
        return Arrays.asList(fontFamily, fontWeight, fontSize);
    }
    public List<Color> getStyleColors(WebElement elem){
        Color borderColor = Color.fromString(elem.getCssValue("border-color"));
        Color backgroundColor = Color.fromString(elem.getCssValue("background-color"));
        Color fontColor = Color.fromString(elem.getCssValue("color"));
        return Arrays.asList(borderColor,backgroundColor,fontColor);
    }
    public List<String> getStyleBorderInput(WebElement elem){
        String borderStyle = elem.getCssValue("border-style");
        String borderWidth = elem.getCssValue("border-width");
        String borderRadius = elem.getCssValue("border-radius");
        return Arrays.asList(borderStyle,borderWidth,borderRadius);
    }
    public List<String> getStyleActiveBut(WebElement elem){
        String colorText = elem.getCssValue("color");
        String background = elem.getCssValue("background-color");
        String borderRadius = elem.getCssValue("border-radius");
        return Arrays.asList(colorText,background,borderRadius);
    }
}
