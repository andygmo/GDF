package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.allianz.claim.pageobjects.PersonalDetailsPageClaims;
import com.allianz.utils.Conditions;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.TextInput;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.util.List;

public class ChooseConditionsPage extends AllianzAutoBasePage<ChooseConditionsPage> {
    public final TextInput licensePlateNumber = new TextInput(By.xpath("//input[@trackid='licensePlateNumber']"));
    public final TextInput startDate = new TextInput(By.xpath("//input[@trackid='startDate']"));
    public final TextInput vehicleIdentificationNumber =  new TextInput(By.xpath("//input[@trackid='vehicleIdentificationNumber']"));
    public final TextInput previousLicensePlateNumber = new TextInput(By.xpath("//input[@trackid='previousLicensePlateNumber']"));
    public final Button previousInsuranceCompany = new Button(By.xpath("//nx-dropdown[@id='previousInsuranceCompany']"));
    public final Button previousInsuranceCompanyDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='previousInsuranceCompany']"));
    public final TextInput externalContractNumber = new TextInput(By.xpath("//input[@trackid='externalContractNumber']"));
    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));



    public ChooseConditionsPage inputConditions(Conditions conditions)/*String licenseNumber, String startdate, String vehicleId,
                                                String previousLicenseNumber, String prevInsuranceCompany, String externalContractNum)*/{
        licensePlateNumber.setText(conditions.getLicenseNumber());
        startDate.setText(conditions.getStartdate());
        vehicleIdentificationNumber.setText(conditions.getVehicleId());
        previousLicensePlateNumber.setText(conditions.getPreviousLicenseNumber());
        previousInsuranceCompany.click();

        List<Button> previousInsuranceCompanyDropdowns =previousInsuranceCompanyDropdown.getListOfElements();
        for(int i=0;i<previousInsuranceCompanyDropdowns.size();i++){
            if(previousInsuranceCompanyDropdowns.get(i).getAttribute("trackvalue").equalsIgnoreCase(conditions.getPrevInsuranceCompany())){
                previousInsuranceCompanyDropdowns.get(i).click();
                break;
            }
        }

        externalContractNumber.setText(conditions.getExternalContractNum());
        return this;
    }



    public PersonalDetailsPage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(PersonalDetailsPage.class);
    }
}
