/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avtomatedTestSarafan.popupCityNM;
import org.openqa.selenium.support.Color;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import avtomatedTestSarafan.AbstractTest;
import avtomatedTestSarafan.GeneralColor;
import avtomatedTestSarafan.GeneralMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author nast
 */
public class PopupCityNM extends AbstractTest {
    ExpectedDatePopupCity expectedData = new ExpectedDatePopupCity();
    GeneralMethods generalMethods = new GeneralMethods();
    @Test
    public void CheckingOpeningPopupByClickCity() {
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement popup = driver.findElement(By.xpath("//div[@class=\"c-popup\"]"));
        popup.isDisplayed();

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();

    }
    @Test
    public void displayHeader(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        String headerPopup = driver.findElement(By.xpath("//div[@class = 'c-popup__header']/h3[@class = 'c-popup__title']")).getText();
        Assertions.assertEquals(expectedData.headerPopupCities,headerPopup);
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();



    }

    @Test
    public void checkStyleFontHeader(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        List <String> stylesFontHeaderPopup = generalMethods.getStylesFont(driver.findElement(By.xpath("//div[@class = 'c-popup__header']/h3[@class = 'c-popup__title']")));
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.styleFontTextH3,stylesFontHeaderPopup);


    }
    @Test
    public void checkStyleColorTextHeader(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        Color headerPopup = Color.fromString(driver.findElement(By.xpath("//div[@class = 'c-popup__header']/h3[@class = 'c-popup__title']")).getCssValue("color"));
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(GeneralColor.BLACK, headerPopup);
    }
    @Test
    public void checkCrossInButtonClosePopup(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        WebElement iconSvgCrossBut = buttonClose.findElement(By.xpath("//*[local-name() = 'svg']"));
        iconSvgCrossBut.isDisplayed();
        buttonClose.click();
        Assertions.assertThrows(Exception.class, () -> {
            driver.findElement(By.className("c-popup"));
        }, "Popup не скрылся");

    }
    @Test
    public void checkDisplayPlaceholderInInput(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement inputEnterCity = driver.findElement(By.xpath("//form[@class='c-popup__form']/input[@class='c-popup__input-find']"));
        String placeholder = inputEnterCity.getAttribute("placeholder");

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();

        Assertions.assertEquals( expectedData.placeholderInputPopupCity, placeholder);
    }
    @Test
    public void checkStyleBorderInputPopupCity(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement inputEnterCity = driver.findElement(By.xpath("//form[@class='c-popup__form']/input[@class='c-popup__input-find']"));
        List <String> actualStyleInput = generalMethods.getStyleBorderInput(inputEnterCity);

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.styleBorderInputPopupCity,actualStyleInput);
    }
    @Test
    public void checkStyleFontInputPlaceholder(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement inputEnterCity = driver.findElement(By.xpath("//form[@class='c-popup__form']/input[@class='c-popup__input-find']"));
        List <String> actualStyleFontPlaceholderInput = generalMethods.getStylesFont(inputEnterCity);

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.styleFontFormInputPlaceholderPopupCity,actualStyleFontPlaceholderInput);
    }
    @Test
    public void checkEnterInInputNameCityDisplayInBlockCity(){

        for(int i = 1; i <= expectedData.ListCitiesPopupCityNL.size(); i++){
            WebElement contactCity = driver.findElement(By.id("city"));
            contactCity.click();

            WebElement inputEnterCity = driver.findElement(By.xpath("//form[@class=\"c-popup__form\"]//input[@name=\"find_city\"]"));
            inputEnterCity.sendKeys(expectedData.listCityPopup.get(i));

            WebElement butSave = driver.findElement(By.xpath("//form[@class = \"c-popup__form\"]//button"));
            butSave.click();

            WebElement blockCity = driver.findElement(By.id("city"));
            String textBlockCity = blockCity.getText();

            Assertions.assertEquals(expectedData.ListCitiesPopupCityNL.get(i),textBlockCity);
        }
    }
    @Test
    public void displayListCities() {
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement listElementsForm = driver.findElement(By.xpath("//form[@class=\"c-popup__form\"]"));
        List<WebElement> listCities = listElementsForm.findElements(By.cssSelector("div"));
        List<String> nameCities = new ArrayList<>();

        for (WebElement city : listCities) {
            nameCities.add(city.findElement(By.cssSelector("label")).getText());
        }

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();

        Assertions.assertEquals(expectedData.ListCitiesPopupCityNL, nameCities);
    }

    @Test
    public void checkStyleFontListCitiesCity() {
        var contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement listElementsForm = driver.findElement(By.xpath("//form[@class=\"c-popup__form\"]"));
        List<WebElement> listCities = listElementsForm.findElements(By.cssSelector("div"));

        for (WebElement city : listCities) {
            WebElement elem = city.findElement(By.cssSelector("label"));
            Assertions.assertEquals(expectedData.styleFontListCitiesPopup, generalMethods.getStylesFont(elem));
        }
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
    }

    @Test
    public void checkStyleColorListCities(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement listElementsForm = driver.findElement(By.xpath("//form[@class=\"c-popup__form\"]"));
        List<WebElement> listCities = listElementsForm.findElements(By.cssSelector("div"));
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        for (WebElement city : listCities) {
           Color elem = Color.fromString(city.findElement(By.cssSelector("label")).getCssValue("color"));
           String layout = "У лемента " + " \" " + city.getText()+ "\" " + " стиль шрифта не соответствует";
           if(!elem.equals(GeneralColor.BLACK)){
               buttonClose.click();
               Assertions.assertEquals(GeneralColor.BLACK, elem,layout);
           }
        }

    }

    @Test
    public void checkCheckboxListCitiesInPopup(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement listElementsForm = driver.findElement(By.xpath("//form[@class=\"c-popup__form\"]"));
        List<WebElement> listCities = listElementsForm.findElements(By.cssSelector("div"));
        for(WebElement city : listCities){
            WebElement checkboxSvg = city.findElement(By.xpath("//*[local-name() = 'svg']"));
            checkboxSvg.isDisplayed();
        }
        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
    }
    @Test
    public void checkStyleBorderButSavePopupCity(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement butSave = driver.findElement(By.xpath("//form[@class = \"c-popup__form\"]/button"));
        List <String> styleButSave = generalMethods.getStyleBorderInput(butSave);

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.styleBorderBut, styleButSave);
    }
    @Test
    public void checkStyleFontButSave(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement butSave = driver.findElement(By.xpath("//form[@class = \"c-popup__form\"]/button"));
        List <String> styleFontButSave = generalMethods.getStylesFont(butSave);

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.styleFontButSavePopupCity,styleFontButSave);
    }
    @Test
    public void checkColorsButSave(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        WebElement butSave = driver.findElement(By.xpath("//form[@class = \"c-popup__form\"]/button"));
        List <Color> styleFontButSave = generalMethods.getStyleColors(butSave);

        WebElement buttonClose = driver.findElement(By.xpath("//div[@class='c-popup__header']/button[@class='c-popup__close']"));
        buttonClose.click();
        Assertions.assertEquals(expectedData.colorsButSave,styleFontButSave);
    }
    @Test
    public void checkTextInButtonPopupCity(){
        WebElement contactCity = driver.findElement(By.id("city"));
        contactCity.click();

        String butSave = driver.findElement(By.xpath("//form[@class = \"c-popup__form\"]/button")).getText();
        Assertions.assertEquals(expectedData.textButInPopupCity, butSave);
    }

}
