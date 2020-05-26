package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.allianz.utils.PersonalDetails;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import com.sqs.web.elements.RadioButton;
import com.sqs.web.elements.TextInput;
import org.openqa.selenium.By;

import java.util.List;

public class PersonalDetailsPage extends AllianzAutoBasePage<PersonalDetailsPage> {
    public final RadioButton mrsRadioButton=new RadioButton(By.xpath("//nx-radio[@trackvalue='salutation.mrs.label']/label/div"));
    public final RadioButton mrRadioButton=new RadioButton(By.xpath("//nx-radio[@trackvalue='salutation.mr.label']/label/div"));
    public final TextInput firstName=new TextInput(By.xpath("//input[@trackid='firstName']"));
    public final TextInput lastName=new TextInput(By.xpath("//input[@trackid='lastName']"));
    public final TextInput cityTextBox=new TextInput(By.xpath("//input[@trackid='city']"));
    public final TextInput streetTextBox=new TextInput(By.xpath("//input[@trackid='street']"));
    public final TextInput streetNumberTextBox=new TextInput(By.xpath("//input[@trackid='streetNumber']"));
    public final TextInput emailIdTextbox=new TextInput(By.xpath("//input[@trackid='email']"));
    public final TextInput emailIdRepeatTextBox=new TextInput(By.xpath("//input[@trackid='emailRepeat']"));
    public final TextInput mobileNumberTextBox=new TextInput(By.xpath("//input[@trackid='mobileNumber']"));

    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));

    public PersonalDetailsPage inputPersonalDetails(PersonalDetails personalDetails)/*(String salutation, String firstname, String lastname,
                                                    String city, String street, String streetNumber,
                                                    String email, String emailRepeat, String mobileNumber)*/ throws InterruptedException {

        Thread.sleep(5000);
        if(personalDetails.getSalutation().equalsIgnoreCase("Herr")){
            mrRadioButton.click();
        }else{
            mrsRadioButton.click();
        }

        firstName.setText(personalDetails.getFirstname());
        lastName.setText(personalDetails.getLastname());
        cityTextBox.setText(personalDetails.getCity());
        streetTextBox.setText(personalDetails.getStreet());
        streetNumberTextBox.setText(personalDetails.getStreetNumber());
        emailIdTextbox.setText(personalDetails.getEmail());
        emailIdRepeatTextBox.setText(personalDetails.getEmailRepeat());
        mobileNumberTextBox.setText(personalDetails.getMobileNumber());

        return this;
    }


    public PaymentPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(PaymentPage.class);
    }

}
