package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.web.elements.Button;
import org.openqa.selenium.By;

public class HotLinePage extends AllianzAutoBasePage<HotLinePage> {

    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));

    public ChooseConditionsPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(ChooseConditionsPage.class);
    }


}
