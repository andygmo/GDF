package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import org.openqa.selenium.By;

public class SubmitScreenPageClaims extends AllianzClaimsBasePage<SubmitScreenPageClaims> {

    public final CheckBox submitCheckBox = new CheckBox(By.xpath("//div[@class='submit-screen__box columns']/div[2]/gdf-m-checkbox/div/div"));
    public final Button nextBtn = new Button(By.xpath("//button[@class='a-button u-is-middle fnol-navigation__button fnol-navigation__next-button u-is-primary']"));

    public SubmitScreenPageClaims selectSubmitCheckBox(){
        submitCheckBox.click();
        return this;
    }

    public FinishScreenPageClaims navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(FinishScreenPageClaims.class);
    }
}
