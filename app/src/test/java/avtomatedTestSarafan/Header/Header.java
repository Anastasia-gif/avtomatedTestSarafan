package avtomatedTestSarafan.Header;

import avtomatedTestSarafan.AbstractTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header extends AbstractTest {
    @Test
    public void checkDisplayLogoSalfa(){
        WebElement elemLogo = driver.findElement(By.xpath("//a[id='logo']//*[local-name()='svg']"));
        elemLogo.isDisplayed();
    }
}
