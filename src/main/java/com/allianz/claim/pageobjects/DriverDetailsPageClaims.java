package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import org.openqa.selenium.By;

public class DriverDetailsPageClaims extends AllianzClaimsBasePage<DriverDetailsPageClaims> {
    public final Button nextBtn = new Button(By.xpath("//button[text()='Weiter']"));
    public final Button isClaimantTheDriverTrueBtn = new Button(By.xpath("//fnol-radio-circle[@id='isClaimantTheDriverTrue']"));
    public final Button isClaimantTheDriverFalseBtn = new Button(By.xpath("//fnol-radio-circle[@id='isClaimantTheDriverFalse']"));
    public final Button driverDetailsMeIchBtn = new Button(By.xpath("//div[@id='driverDetailsMe']"));
    public final Button driverDetailsAccidentOpponentBtn = new Button(By.xpath("//div[@id='driverDetailsAccidentOpponent']"));
    public final Button driverDetailsBothBeideBtn = new Button(By.xpath("//div[@id='driverDetailsBoth']"));

    public DriverDetailsPageClaims inputDriverDetails(String isClaimantTheDriver, String whoIsResponsibleForDamage) throws InterruptedException {

        if(isClaimantTheDriver.equalsIgnoreCase("Ja")){
            isClaimantTheDriverTrueBtn.click();
            Thread.sleep(2000);

        }else{
            isClaimantTheDriverFalseBtn.click();
            Thread.sleep(2000);
        }

        if(whoIsResponsibleForDamage.equalsIgnoreCase("Ich")){
            driverDetailsMeIchBtn.click();
            Thread.sleep(2000);

        }else if(whoIsResponsibleForDamage.equalsIgnoreCase("Mein Unfallgegner")){
            driverDetailsAccidentOpponentBtn.click();
            Thread.sleep(2000);

        }else if(whoIsResponsibleForDamage.equalsIgnoreCase("Beide")){
            driverDetailsBothBeideBtn.click();
            Thread.sleep(2000);
        }

        return this;

    }
    public VehicleDetailsPageClaims navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(VehicleDetailsPageClaims.class);
    }

}
