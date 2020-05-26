package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Label;
import org.openqa.selenium.By;

public class FinishScreenPageClaims extends AllianzClaimsBasePage<FinishScreenPageClaims> {
    public final Label claimIdTextLabel = new Label(By.xpath("//div[@class='finish-screen__claim-id-text']"));
    public final Label claimIdLabel = new Label(By.xpath("//div[@class='finish-screen__claim-id']"));
    public String claimIdText;
    public String claimID;
    public String claimIdArray[];
    public FinishScreenPageClaims getClaimIdAndText() throws InterruptedException {
        claimIdText = claimIdTextLabel.getText();
        claimID = claimIdLabel.getText();
        Thread.sleep(5000);
        System.out.println("Finish screen claim id text: "+claimIdText);
        System.out.println("Finish screen claim id: "+claimID);
        claimIdArray = claimID.split(" ");
        return this;

    }




}
