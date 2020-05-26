package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import com.sqs.web.elements.TextInput;
import org.openqa.selenium.By;

public class PaymentPage extends AllianzAutoBasePage<PaymentPage> {
    public final TextInput ibanText = new TextInput(By.xpath("//input[@trackid='ibanField']"));
    public final CheckBox legalTermsCheckBox =new CheckBox(By.xpath("//nx-checkbox[@trackid='payment.legalTerms']/label/span"));
    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));
    public final  Button Appointmentbutton =  new Button(By.xpath(
            "//div[@class='navigation-buttons nx-grid']/div/div/div/div/button"));

    public PaymentPage inputPaymentDetails(String IBAN) throws InterruptedException {

        ibanText.setText(IBAN);
        Thread.sleep(5000);
        legalTermsCheckBox.click();
        return this;
    }

    public PaymentPage  Checkappoinment() throws InterruptedException{
        Appointmentbutton.click();
        Thread.sleep(5000);
        return this;
    }

    public LegalAcceptancesPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(LegalAcceptancesPage.class);
    }

}
