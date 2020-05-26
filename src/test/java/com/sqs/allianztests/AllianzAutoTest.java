package com.sqs.allianztests;

import com.allianz.auto.pageobjects.AllianzAutoHome;
import com.allianz.utils.Conditions;
import com.allianz.utils.PersonalDetails;
import com.sqs.allianztests.base.AllianzBaseTest;
import org.testng.annotations.Test;

public class AllianzAutoTest extends AllianzBaseTest {
    @Test(groups = {"autoGroup"})
    public void autoConfigurationTest() throws InterruptedException {
        Conditions conditions = new Conditions();
        PersonalDetails personalDetails = new PersonalDetails();
        AllianzAutoHome autoBase = waitFor(AllianzAutoHome.class);

        autoBase.selectBuildYear("2020")
                .selectVehicleBrand("Abarth")
                .selectVehicleModel("500")
                .selectPower("121.0")
                .selectFuelType("Benzin")
                .selectModel("500 595 Pista 165")
                .navigateToNextScreen()
                .inputAdditionalDetails("1110","01.01.1990","0")
                .inputRegistratiodateDetail("09.08.2004")
                .navigateToNextScreen()
                .selectProduct("Max (Vollkaskopaket)")
                .navigateToNextScreen()
                .navigateToNextScreen()
                .inputConditions(conditions)
                .navigateToNextScreen()
                .inputPersonalDetails(personalDetails)
                .navigateToNextScreen()
                .inputPaymentDetails("AT483200000012345864")
                .Checkappoinment()
                .navigateToNextScreen()
                .setLegalTermsCheckBox().navigateToNextScreen()
                .navigateToNextScreen();

    }
}
