package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LegalAcceptancesPage extends AllianzAutoBasePage<LegalAcceptancesPage> {
    public final CheckBox legal1CheckBox =new CheckBox(By.xpath("//nx-checkbox[@trackid='ABGEL19']/label/span"));
    public final CheckBox legal2CheckBox =new CheckBox(By.xpath("//nx-checkbox[@trackid='VORSCH19']/label/span"));
    public final CheckBox dataprivacy =new CheckBox(By.xpath("//nx-checkbox[@trackid='DATAPRIVACY']/label/span"));
    public final CheckBox Ecomm =new CheckBox(By.xpath("//nx-checkbox[@trackid='ECOMM']/label/span"));
    public final CheckBox Maklaus =new CheckBox(By.xpath("//nx-checkbox[@trackid='MAKLAUS']/label/span"));
    public final CheckBox SCHRIFTFORM =new CheckBox(By.xpath("//nx-checkbox[@trackid='SCHRIFTFORM']/label/span"));
    public final CheckBox PREINFO =new CheckBox(By.xpath("//nx-checkbox[@trackid='PREINFO']/label/span"));
    public final Button downloadInformationButton =new Button(By.xpath("//button[@id='downloadButton']"));
    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));



    public LegalAcceptancesPage setLegalTermsCheckBox() throws InterruptedException {

        Thread.sleep(1000);
        legal1CheckBox.click();
        legal2CheckBox.click();
        dataprivacy.click();
        Ecomm.click();
        Maklaus.click();
        PREINFO.click();
        SCHRIFTFORM.click();
        downloadInformationButton.click();
        Thread.sleep(2000);
        return this;
    }


    public SummaryPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(SummaryPage.class);
    }


    }


