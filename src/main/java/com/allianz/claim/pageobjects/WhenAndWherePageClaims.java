package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class WhenAndWherePageClaims extends AllianzClaimsBasePage<WhenAndWherePageClaims> {

  //  WebDriver driver = DriverProvider.getDriver();
    public final Button datePicker = new Button(By.xpath("//div[@class='a-datepicker-input-icon']"));

    public final TextInput streetTextInput = new TextInput(By.xpath("//gdf-m-input[@id='when-and-where-street-input']/div/input"));
    public final TextInput cityTextInput = new TextInput(By.xpath("//gdf-m-input[@id='when-and-where-city-input']/div/input"));
    public final Button nextBtn = new Button(By.xpath("//button[@class='a-button u-is-middle fnol-navigation__button fnol-navigation__next-button u-is-primary']"));
    public final TextInput dateTextInput = new TextInput(By.xpath("//div[@class='a-datepicker-input-container']/input[1]"));
    public final TextInput monthTextInput = new TextInput(By.xpath("//div[@class='a-datepicker-input-container']/input[2]"));
    public final TextInput yearTextInput = new TextInput(By.xpath("//div[@class='a-datepicker-input-container']/input[3]"));


    public WhenAndWherePageClaims inputWhenAndWhereInfo(String date, String street, String city) throws InterruptedException {
        /*datePicker.click();*/
        Thread.sleep(5000);
        String[] occurenceDate = date.split("-");
        dateTextInput.setText(occurenceDate[0]);
        monthTextInput.setText(occurenceDate[1]);
        yearTextInput.setText(occurenceDate[2]);

         streetTextInput.sendKeys(street);
         Thread.sleep(2000);
         cityTextInput.sendKeys(city);

         return this;
    }

    public PersonalDetailsPageClaims navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(PersonalDetailsPageClaims.class);
    }

}
