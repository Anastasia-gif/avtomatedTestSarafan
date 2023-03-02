package avtomatedTestSarafan.Header;

import avtomatedTestSarafan.AbstractTest;
import avtomatedTestSarafan.GeneralMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Header extends AbstractTest {
    ExpectedDateHeader expectedDate = new ExpectedDateHeader();
    GeneralMethods generalMethods = new GeneralMethods();
    @Test
    public void checkDisplayLogoSalfa(){
        WebElement elemLogo = driver.findElement(By.xpath("//a[@id=\"logo\"]//*[local-name()=\"svg\"]"));
        elemLogo.isDisplayed();
    }
    @Test
    public void checkOpenMainPageClickLogo(){

    }
    @Test
    public void checkButtonCatalog(){
        WebElement linkCatalog = driver.findElement(By.xpath("//a[@href=\"/category\"]"));
        WebElement butCatalog = linkCatalog.findElement(By.xpath("//button"));
        butCatalog.isDisplayed();
        butCatalog.click();
        String curLinkPage = driver.getCurrentUrl();
        Assertions.assertEquals(expectedDate.linkCatalog, curLinkPage);
    }
    @Test
    public void checkStyleFont(){
        WebElement elementButCatalog = driver.findElement(By.xpath("//a[@href=\"/category\"]//button"));
        List<String> styleList = generalMethods.getStylesFont(elementButCatalog);
        Assertions.assertEquals(expectedDate.styleFontButCatalog, styleList);
    }
}
