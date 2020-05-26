package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Label;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class NoInsuredFoundPopupPage extends AllianzClaimsBasePage<NoInsuredFoundPopupPage> {
    public final Label popUpTextLabel = new Label(By.xpath("//gdf-m-popup[@id='undefined']/div/div[2]/div/div/div/p[2]"));
    public final Button concludeBtn = new Button(By.xpath("//button[text()='Schließen']"));
    public WebDriver driver = DriverProvider.getDriver();
    public String popUpText;

    public NoInsuredFoundPopupPage verifyPopUPTextAndConcludeBtn() throws InterruptedException {
        Thread.sleep(8000);
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iter = windows.iterator();

        while (iter.hasNext()) {
            String childWindow = iter.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                popUpText = driver.findElement(By.xpath("//gdf-m-popup[@id='undefined']/div/div[2]/div/div/div/p[2]")).getText();
                System.out.println("pop up text: " + popUpText);
                driver.findElement(By.xpath("//button[text()='Schließen']")).click();
                Thread.sleep(5000);
            }
        }
        return this;
    }
}
