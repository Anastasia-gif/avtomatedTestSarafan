package avtomatedTestSarafan.NavigateList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpectedDateNM {
    final List<String> listElementsNM = Arrays.asList(
            "Главная", "Акции", "Новости", "Контакты",
            "Доставка и оплата", "Обратная связь"
    );
    final List<String> styleFontNL = Arrays.asList(
            "\"Open Sans\", sans-serif", "600", "16px"
    );
    final String contactPhoneNL = "+7-495-14-41-495";
    final List<String> styleFontContactNL = Arrays.asList("\"Open Sans\", sans-serif", "400", "16px");
    String contactCityNL = "Москва";

     final Map<String, String> urlByHeader = new HashMap<>() {
        {
            put("Главная", "https://sarawan.salfa.ru/");
            put("Акции", "https://sarawan.salfa.ru/category/discount");
            put("Новости", "https://sarawan.salfa.ru/news");
            put("Контакты", "https://sarawan.salfa.ru/contacts");
            put("Доставка и оплата", "https://sarawan.salfa.ru/delivery");
        }
    };
}