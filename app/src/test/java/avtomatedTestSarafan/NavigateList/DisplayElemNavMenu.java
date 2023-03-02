/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avtomatedTestSarafan.NavigateList;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import avtomatedTestSarafan.AbstractTest;
import avtomatedTestSarafan.GeneralColor;
import avtomatedTestSarafan.GeneralMethods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

/**
 * @author nast
 */
@Slf4j
public class DisplayElemNavMenu extends AbstractTest {
    ExpectedDateNM expectedData = new ExpectedDateNM();
    GeneralMethods generalMethods = new GeneralMethods();
    WebElement navMenu = driver.findElement(By.className("nav__list"));

    @Test
    public void displayListNavMenu() {
        List<WebElement> listElementsNavList = navMenu.findElements(By.cssSelector("li"));
        List<String> textElements = new ArrayList<>();
        for (WebElement elementNavMenu : listElementsNavList) {
            textElements.add(elementNavMenu.getText());
        }
        Assertions.assertEquals(expectedData.listElementsNM, textElements);
    }

    @Test
    public void checkStyleFontListNavMenu() {
        List<WebElement> elemsNavList = navMenu.findElements(By.cssSelector("li"));

        for (WebElement elementNavMenu : elemsNavList) {
            WebElement element = elementNavMenu.findElement(By.cssSelector("a"));
            List<String> fontElement = generalMethods.getStylesFont(element);
            Assertions.assertEquals(expectedData.styleFontNL, fontElement);
        }

    }

    @Test
    public void checkStyleColorTextListNavMenu() {
        driver.navigate().refresh();
        WebElement navMenu = driver.findElement(By.className("nav__list"));
        List<WebElement> elemsNavList = navMenu.findElements(By.cssSelector("li"));

        for (int i = 0; i < elemsNavList.size(); i++) {
            WebElement sectionMenu = elemsNavList.get(i).findElement(By.cssSelector("a"));
            Color expectedColor;
            String listClassSectionMenu = sectionMenu.getAttribute("class");
            var splitClasses = Arrays.asList(listClassSectionMenu.split(" "));
            expectedColor = splitClasses.contains("active") ? GeneralColor.GREEN : GeneralColor.DARKGRAY;
            Color actualSectionMenu = Color.fromString(sectionMenu.getCssValue("color"));
            System.out.println(actualSectionMenu);
            Assertions.assertEquals(expectedColor, actualSectionMenu);
            // elemsNavList = driver.findElements(By.cssSelector(".nav__list > li"));
        }
    }

    @Test
    public void displayContactPhone() {
        String contactPhone = driver.findElement(By.id("phone")).getText();
        Assertions.assertEquals(expectedData.contactPhoneNL, contactPhone, "Номер телефона не соответствует");
    }

    @Test
    public void checkStyleColorTextContactPhone() {
        String contactPhone = driver.findElement(By.id("phone")).getCssValue("color");
        Assertions.assertEquals(GeneralColor.BLACK, contactPhone);
    }

    @Test
    public void checkStyleFontContactPhone() {
        WebElement contactPhone = driver.findElement(By.id("phone"));
        List<String> actualCssFont = generalMethods.getStylesFont(contactPhone);

        System.out.println("Ожидалось: " + actualCssFont + " на самом деле: " + actualCssFont);

        Assertions.assertEquals(expectedData.styleFontContactNL, actualCssFont);
    }

    @Test
    public void checkCssSvgPhone() {
        WebElement svgElemPhone = driver.findElement(By.xpath("//div[@id='phone']/a//*[local-name()='svg']"));
        svgElemPhone.isDisplayed();
    }

    @Test
    public void displayContactCity() {
        var contactCity = driver.findElement(By.id("city")).getText();
        Assertions.assertEquals(expectedData.contactCityNL, contactCity);
    }

    @Test
    public void checkStyleFontContactCity() {
        List<String> contactCity = generalMethods.getStylesFont(driver.findElement(By.id("city")));
        Assertions.assertEquals(expectedData.styleFontContactNL, contactCity);
    }

    @Test
    public void checkStyleColorTextContactCity() {
        String contactCity = driver.findElement(By.id("city")).getCssValue("color");
        Assertions.assertEquals(GeneralColor.BLACK, contactCity);
    }

    @Test
    public void checkCssSvgCity() {
        WebElement svgElemPhone = driver.findElement(By.xpath("//div[@id='city']//*[local-name()='svg']"));
        svgElemPhone.isDisplayed();
    }

    public static void action(WebElement elem) {
        new Actions(driver).moveToElement(elem).perform();
    }

    @Test
    public void checkColorTextSectionNavMenuHover() {
        List<WebElement> listNavMenu = navMenu.findElements(By.cssSelector("li"));
        for (WebElement sectionMenu : listNavMenu) {
            WebElement linkSectionMenu = sectionMenu.findElement(By.cssSelector("a"));
            test(() -> {
                action(linkSectionMenu);
                return Color.fromString(linkSectionMenu.getCssValue("color"));
            }, GeneralColor.GREEN);

        }
    }

    @Test
    public void displayPageClickSectionMenu() {
        List<WebElement> listNavMenu = navMenu.findElements(By.cssSelector("li"));

        for (WebElement sectionMenu : listNavMenu) {
            WebElement linkSectionMenu = sectionMenu.findElement(By.cssSelector("a"));
            new Actions(driver).moveToElement(linkSectionMenu).click().perform();

        }

    }


}
