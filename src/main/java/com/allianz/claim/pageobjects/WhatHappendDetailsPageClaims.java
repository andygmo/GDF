package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sqs.web.elements.Button;

public class WhatHappendDetailsPageClaims extends AllianzClaimsBasePage<WhatHappendDetailsPageClaims> {

    WebDriver driver = DriverProvider.getDriver();
    public final Button nextBtn = new Button(By.xpath("//button[@class='a-button u-is-middle fnol-navigation__button fnol-navigation__next-button u-is-primary']"));

    public WhatHappendDetailsPageClaims selectWhatHappenedDetails(String option) throws InterruptedException {

        Thread.sleep(2000);

        if(option.equalsIgnoreCase("Nein")){
            Hyperlink hasHitAnotherCarOption= new Hyperlink(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='hasHitAnotherCar'][2]"));
            hasHitAnotherCarOption.click();
            Thread.sleep(2000);
            return this;
        }
        else if(option.equalsIgnoreCase("Ja")){
            Button hasHitAnotherCarOption= new Button(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='hasHitAnotherCar'][1]"));
            hasHitAnotherCarOption.click();
            Thread.sleep(2000);
            return this;
        }
        return null;

    }

    public WhenAndWherePageClaims navigateToNextScreen() throws InterruptedException {

        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(WhenAndWherePageClaims.class);

    }
}
