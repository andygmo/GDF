package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.web.elements.Button;
import org.openqa.selenium.By;

public class SummaryPage extends AllianzAutoBasePage<SummaryPage> {

    public final Button nextBtn =  new Button(By.xpath("//button[@id='footer_primary_button']"));

    public SuccessPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(10000);
        return navigatingTo(SuccessPage.class);
    }

}
