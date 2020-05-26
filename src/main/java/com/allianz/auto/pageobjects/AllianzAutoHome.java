package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.RadioButton;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;

import java.util.List;

/**
 * The Presta home page.
 */
public class AllianzAutoHome extends AllianzAutoBasePage<AllianzAutoHome> {

   /**
   * Instantiates a new Auto home.
   */
  public AllianzAutoHome() {
    DriverProvider.getDriver().get(Config.getGlobalProperty("GDF_URL"));

  }


    public AllianzAutoHome selectBuildYear(String buildYear) throws InterruptedException {
        TextInput buildYearTextBox = new TextInput(By.xpath("//div[@class='nx-formfield__input']/nx-dropdown"));
        Button buildYearDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='vehicleConfig.dropdownLabel_buildYear']"));
        Thread.sleep(2000);
        buildYearTextBox.click();
        List<Button> buildYearDropdownOptions = buildYearDropdown.getListOfElements();
        Thread.sleep(1000);
        for (int i = 0; i <= buildYearDropdownOptions.size(); i++) {
            if (buildYearDropdownOptions.get(i).getAttribute("trackvalue").equalsIgnoreCase(buildYear)) {
                buildYearDropdownOptions.get(i).click();
                break;
            }
        }
        return this;
    }

    public AllianzAutoHome selectVehicleBrand(String vehicleBrand) throws InterruptedException {
        Button vehicleBrandDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='vehicleConfig.dropdownLabel_vehicleBrand']"));
        Thread.sleep(2000);
        List<Button> vehicleBrandDropdownOptions = vehicleBrandDropdown.getListOfElements();

        for (int i = 0; i <= vehicleBrandDropdownOptions.size(); i++) {
            if (vehicleBrandDropdownOptions.get(i).getAttribute("trackvalue").equalsIgnoreCase(vehicleBrand)) {
                vehicleBrandDropdownOptions.get(i).click();
               // Thread.sleep(2000);
                break;
            }
        }
        return this;
    }

    public AllianzAutoHome selectVehicleModel(String vehicleModel) throws InterruptedException {
        Button vehicleModelDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='vehicleConfig.dropdownLabel_vehicleModel']"));
        Thread.sleep(2000);
        List<Button> vehicleModelDropdownOptions = vehicleModelDropdown.getListOfElements();

        for (int i = 0; i <= vehicleModelDropdownOptions.size(); i++) {
            if (vehicleModelDropdownOptions.get(i).getAttribute("trackvalue").equalsIgnoreCase(vehicleModel)) {
                vehicleModelDropdownOptions.get(i).click();
                //Thread.sleep(2000);
                break;
            }
        }
        return this;
    }

    public AllianzAutoHome selectPower(String power) throws InterruptedException {
        Button powerDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='vehicleConfig.dropdownLabel_power']"));
        Thread.sleep(2000);
        List<Button> powerDropdownOptions = powerDropdown.getListOfElements();

        for (int i = 0; i <= powerDropdownOptions.size(); i++) {
            if (powerDropdownOptions.get(i).getAttribute("trackvalue").equalsIgnoreCase(power)) {
                powerDropdownOptions.get(i).click();
                //Thread.sleep(2000);
                break;
            }
        }
        return this;
    }

    public AllianzAutoHome selectFuelType(String fuelType) throws InterruptedException {
        Button fuelTypeDropdown = new Button(By.xpath("//nx-dropdown-item[@trackid='vehicleConfig.dropdownLabel_fuelType']"));
        Thread.sleep(2000);
        List<Button> fuelTypeDropdownOptions = fuelTypeDropdown.getListOfElements();

        for (int i = 0; i <= fuelTypeDropdownOptions.size(); i++) {
            if (fuelTypeDropdownOptions.get(i).getAttribute("trackvalue").equalsIgnoreCase(fuelType)) {
                fuelTypeDropdownOptions.get(i).click();
               // Thread.sleep(2000);
                break;
            }
        }
        return this;
    }

    public AllianzAutoHome selectModel(String model) throws InterruptedException {
        RadioButton modelRadioButton = new RadioButton(By.xpath("//nx-radio[@trackid='radio_button_list']/label/span"));
        Thread.sleep(2000);
        List<RadioButton> modelRadioButtons = modelRadioButton.getListOfElements();

        for (int i = 0; i <= modelRadioButtons.size(); i++) {
            if (modelRadioButtons.get(i).getText().contains(model)) {
                modelRadioButtons.get(i).click();
               Thread.sleep(5000);
                break;
            }
        }
        return this;
    }

    public AdditionalQuestionsPage navigateToNextScreen() throws InterruptedException {
      Button nextBtn =  new Button(By.xpath("//button[@class='nx-button--primary nx-button--medium nx-button--block']"));
      nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(AdditionalQuestionsPage.class);
    }

}
