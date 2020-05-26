package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.allianz.utils.PersonalDetails;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.RadioButton;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalDetailsPageClaims extends AllianzClaimsBasePage<PersonalDetailsPageClaims> {

    public final RadioButton herrSalutationRadioBtn = new RadioButton(By.xpath("//div[@class='personal-details__salutation']/div[3]/div[1]/div"));
    public final RadioButton frauSalutationRadioBtn = new RadioButton(By.xpath("//div[@class='personal-details__salutation']/div[2]/div[1]/div"));
    public final TextInput claimantFirstName = new TextInput(By.xpath("//gdf-m-input[@id='claimantFirstName']/div/input"));
    public final TextInput claimantLastName = new TextInput(By.xpath("//gdf-m-input[@id='claimantLastName']/div/input"));
    public final TextInput claimantNumberPlate = new TextInput(By.xpath("//gdf-m-input[@id='claimantNumberPlate']/div/input"));
    public final TextInput claimantEMail = new TextInput(By.xpath("//gdf-m-input[@id='claimantEMail']/div/input"));
    public final TextInput claimantPhone = new TextInput(By.xpath("//gdf-m-input[@id='claimantPhone']/div/input"));
    public final TextInput claimantStreet = new TextInput(By.xpath("//gdf-m-input[@id='claimantStreet']/div/input"));
    public final TextInput claimantStreetNumber = new TextInput(By.xpath("//gdf-m-input[@id='claimantStreetNumber']/div/input"));
    public final TextInput claimantZipCode = new TextInput(By.xpath("//gdf-m-input[@id='claimantZipCode']/div/input"));
    public final TextInput claimantCity = new TextInput(By.xpath("//gdf-m-input[@id='claimantCity']/div/input"));
    public final RadioButton claimantTrackingType = new RadioButton(By.xpath("//div[@class='pretty p-default p-round']"));
    public final Button claimantVehicleTypeDropDown = new Button(By.xpath("//fnol-dropdown[@id='claimantVehicleType']/div/div[2]/span"));
    public final Button claimantVehicleTypeOptions = new Button(By.xpath("//ul[@class='m-dropdown__options']/li"));


    public final TextInput insuredFirstName = new TextInput(By.xpath("//gdf-m-input[@id='insuredFirstName']/div/input"));
    public final TextInput insuredLastName = new TextInput(By.xpath("//gdf-m-input[@id='insuredLastName']/div/input"));
    public final TextInput insuredNumberPlate = new TextInput(By.xpath("//gdf-m-input[@id='insuredPlateNumber']/div/input"));
    public final TextInput insuredEMail = new TextInput(By.xpath("//gdf-m-input[@id='insuredEMail']/div/input"));
    public final TextInput insuredPhone = new TextInput(By.xpath("//gdf-m-input[@id='insuredPhone']/div/input"));

    public final Button nextBtn = new Button(By.xpath("//button[text()='Weiter']"));


    public DriverDetailsPageClaims inputPersonalDetails(PersonalDetails personalDetails) throws InterruptedException {

        claimantFirstName.setText(personalDetails.getFirstname());
        claimantLastName.setText(personalDetails.getLastname());
        claimantNumberPlate.setText(personalDetails.getNumberPlate());
        claimantEMail.setText(personalDetails.getEmail());
        claimantPhone.setText(personalDetails.getMobileNumber());
        Thread.sleep(2000);

        List<RadioButton> claimTrackingRadioBtns = claimantTrackingType.getListOfElements();
        for (RadioButton ele : claimTrackingRadioBtns) {
            String claimTrackingText = ele.findElement(By.xpath("//div[@class='state p-primary']/label")).getText();
            if (claimTrackingText.equalsIgnoreCase(personalDetails.getClaimTrackingType())) {
                ele.click();
                Thread.sleep(5000);
                break;
            }
        }
        navigateToNextScreen();
        return navigatingTo(DriverDetailsPageClaims.class);

    }

    public NoInsuredFoundPopupPage inputPersonalDetailsAccidentOpponent(PersonalDetails personalDetails) throws InterruptedException {
        Thread.sleep(5000);

        if (personalDetails.getSalutation().equalsIgnoreCase("Herr")) {
            herrSalutationRadioBtn.click();
        } else {
            frauSalutationRadioBtn.click();
        }
        claimantFirstName.setText(personalDetails.getFirstname());
        claimantLastName.setText(personalDetails.getLastname());
        claimantNumberPlate.setText(personalDetails.getNumberPlate());

        claimantVehicleTypeDropDown.click();
        List<Button> claimantVehicleTypes = claimantVehicleTypeOptions.getListOfElements();
        for (Button ele : claimantVehicleTypes) {
            String claimantVehicleType = ele.getText();
            if (claimantVehicleType.equalsIgnoreCase(personalDetails.getClaimantVehicleType())) {
                ele.click();
                Thread.sleep(5000);
                break;
            }
        }

        claimantEMail.setText(personalDetails.getEmail());
        claimantPhone.setText(personalDetails.getMobileNumber());
        claimantStreet.setText(personalDetails.getStreet());
        claimantStreetNumber.setText(personalDetails.getStreetNumber());
        claimantZipCode.setText(personalDetails.getZipCode());
        claimantCity.setText(personalDetails.getCity());

        Thread.sleep(2000);

        List<RadioButton> claimTrackingRadioBtns = claimantTrackingType.getListOfElements();
        for (RadioButton ele : claimTrackingRadioBtns) {
            String claimTrackingText = ele.findElement(By.xpath("//div[@class='state p-primary']/label")).getText();
            if (claimTrackingText.equalsIgnoreCase(personalDetails.getClaimTrackingType())) {
                ele.click();
                Thread.sleep(5000);
                break;
            }
        }

        insuredFirstName.setText(personalDetails.getInsuredFirstName());
        insuredLastName.setText(personalDetails.getInsuredLastName());
        insuredNumberPlate.setText(personalDetails.getInsuredNumberPlate());

        insuredEMail.setText(personalDetails.getInsuredEmail());
        insuredPhone.setText(personalDetails.getInsuredPhone());

        navigateToNextScreen();
        Thread.sleep(5000);
        return navigatingTo(NoInsuredFoundPopupPage.class);

    }

    public PersonalDetailsPageClaims navigateToNextScreen() throws InterruptedException {
        Thread.sleep(5000);
        nextBtn.click();
        Thread.sleep(5000);
        return this;
    }


}
