/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avtomatedTestSarafan;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

/**
 * @author nast
 */
public class AbstractTest {
    public static WebDriver driver;

    public interface Pred {
        boolean test();
    }

    @SneakyThrows
    protected static boolean test(Pred p) {
        int i = 100;
        while (i-- > 0) {
            if(p.test())return true;
            Thread.sleep(10);
        }
        return false;
    }
    @SneakyThrows
    protected static <T>void test(Supplier<T> p, T obraz) {
        int i = 5000;
        while (i-- > 0) {
            var val= p.get();
            if(Objects.equals(val, obraz))return;
            Thread.sleep(10);
        }
        assert false;
    }

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/nast/chromedriverLinux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes",
                "--ignore-certificate-errors"
        );
        driver = new ChromeDriver(options);
        driver.get("https://Sarawan:Sarawan@sarawan.salfa.ru/");
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
   /* @Test
    public void testSendSms() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("content-type","application/json")
                .uri(URI.create("https://dev.sarawan.ru/users/authentication/api/sms-send/"))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"phone_number\": \"+79043003025\"\n" +
                        "}")) // GET is default
                .build();

        HttpResponse<Void> response = client.send(request,
                HttpResponse.BodyHandlers.discarding());

        System.out.println(response.statusCode());
        String smsCode=JOptionPane.showInputDialog("code?");
        request = HttpRequest.newBuilder()
                .header("content-type","application/json")
                .uri(URI.create("https://dev.sarawan.ru/users/authentication/api/get-token/"))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"phone_number\": \"+79043003025\",\n" +
                        "    \"code\": \""+smsCode+"\"\n" +
                        "}"))
                .build();

        var res2 = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(res2.statusCode());
        System.out.println(res2.body());

    }
    @AfterAll
    public static void destroy() {
        driver.close();
    }*/
}
