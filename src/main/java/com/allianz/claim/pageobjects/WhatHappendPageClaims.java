package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import org.openqa.selenium.By;

import com.sqs.web.elements.Button;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.WebDriver;

public class WhatHappendPageClaims extends AllianzClaimsBasePage<WhatHappendPageClaims> {

    public WebDriver driver = DriverProvider.getDriver();
    public final Button nextBtn = new Button(By.xpath("//button[@class='a-button u-is-middle fnol-navigation__button fnol-navigation__next-button u-is-primary']"));
    public final int optionsCount = driver.findElements(By.xpath("//div[@class='what-happened__option']")).size();
    public WhatHappendPageClaims selectWhatHappenedOption(String whatHappenedOption) throws InterruptedException {



        for (int i = 1; i <= optionsCount; i++) {
            Button accidentTypeBtn = new Button(By.xpath("//div[@class='what-happened__option'][" + i + "]"));
            String accidentType = driver.findElement(By.xpath("//div[@class='what-happened__option'][" + i + "]/div")).getText();
            if (accidentType.contains(whatHappenedOption)) {
                accidentTypeBtn.click();
                Thread.sleep(2000);
                System.out.println("What happened selected type: " + accidentType);
                return this;
            }
        }

        return null;
    }

    public WhatHappendDetailsPageClaims navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(3000);
        return navigatingTo(WhatHappendDetailsPageClaims.class);
    }
}
