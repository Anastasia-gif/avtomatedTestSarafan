package avtomatedTestSarafan.popupCityNM;

import avtomatedTestSarafan.GeneralColor;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Colors;

import java.util.Arrays;
import java.util.List;


public class ExpectedDatePopupCity {
    final List<String> ListCitiesPopupCityNL = Arrays.asList("Москва", "Санкт-Петербург", "Казань", "Краснодар");
    final List<String> styleFontListCitiesPopup = Arrays.asList("\"Open Sans\", sans-serif","400","16px");
    final String headerPopupCities = "Выберите город";
    final List<String> styleFontTextH3 = Arrays.asList("\"Open Sans'\", sans-serif","700","20px");
    final List<String> styleBorderInputPopupCity = Arrays.asList("none","0px","10px");
    final List<String> styleFontFormInputPlaceholderPopupCity = Arrays.asList("\"Open Sans\", sans-serif","400","16px");
    final String placeholderInputPopupCity = "Ваш город";
    final List<String> listCityPopup = Arrays.asList( "Москва", "Санкт-Петербург", "Казань", "Краснодар");
    final List<String> styleBorderBut = Arrays.asList("none","0px","10px");
    final List<Color> colorsButSave = Arrays.asList( Color.fromString(GeneralColor.ORANGE),
            Color.fromString(GeneralColor.ORANGE),
            Color.fromString(GeneralColor.WHITE)
           );

    final List<String> styleFontButSavePopupCity = Arrays.asList("\"Montserrat-SemiBold\",sans-serif","600","20px");
    final String textButInPopupCity = "Сохранить";
}
