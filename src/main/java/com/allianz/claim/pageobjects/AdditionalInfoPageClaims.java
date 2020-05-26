package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import org.openqa.selenium.By;

public class AdditionalInfoPageClaims extends AllianzClaimsBasePage<AdditionalInfoPageClaims> {

    public final Button nextBtn = new Button(By.xpath("//button[text()='Weiter']"));

    public SubmitScreenPageClaims navigateToNextScreen() throws InterruptedException {
        Thread.sleep(2000);
        nextBtn.click();
        Thread.sleep(2000);
        return navigatingTo(SubmitScreenPageClaims.class);
    }
}
