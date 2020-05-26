package com.sqs.allianztests;

import com.allianz.claim.pageobjects.AllianzClaimsHome;

import com.allianz.claim.pageobjects.FinishScreenPageClaims;
import com.allianz.claim.pageobjects.NoInsuredFoundPopupPage;
import com.allianz.utils.PersonalDetails;
import com.sqs.allianztests.base.AllianzBaseTest;
import javafx.scene.PerspectiveCamera;
import org.testng.annotations.Test;

public class AllianzCreateClaimTest extends AllianzBaseTest {
    //@Test(groups = {"claimGroup"})
    public void creatClaimAllianzCustomerTest() throws InterruptedException {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstname("Herta");
        personalDetails.setLastname("Badem");
        personalDetails.setNumberPlate("VB-635TX");
        personalDetails.setEmail("tst@tst.at");
        personalDetails.setMobileNumber("066456465");
        personalDetails.setClaimTrackingType("per E-Mail");

        AllianzClaimsHome allianzBase = waitFor(AllianzClaimsHome.class);
        FinishScreenPageClaims finishScreenpage = allianzBase.acceptCookies()
                .selectAllianzCustomer()
                .selectDamageType("Mein Fahrzeug")
                .navigateToNextScreenAllianzCustomer()
                .selectWhatHappenedOption("Kollision (Mauer, Zaun, etc.)")
                .navigateToNextScreen()
                .selectWhatHappenedDetails("Nein")
                .navigateToNextScreen()
                .inputWhenAndWhereInfo("03-02-2020","Favoritenstraße","Wien")
                .navigateToNextScreen()
                .inputPersonalDetails(personalDetails)
                .inputDriverDetails("Ja","Ich")
                .navigateToNextScreen()
                .selectVehicleDetails("NEIN","NEIN","NEIN","JA")
                .navigateToNextScreen()
                .navigateToNextScreen()
                .selectSubmitCheckBox()
                .navigateToNextScreen()
                .getClaimIdAndText();

        finishScreenpage.softAssert("Das ist Ihre Schadennummer:",finishScreenpage.claimIdText);
        finishScreenpage.softAssert(Integer.parseInt(finishScreenpage.claimIdArray[1])>0);
        finishScreenpage.softAssert("2020",finishScreenpage.claimIdArray[0]).assertAll();

    }

    @Test(groups = {"claimGroup"})
    public void creatClaimAccidentOpponentTest() throws InterruptedException {
        PersonalDetails personalDetails = new PersonalDetails();
        AllianzClaimsHome allianzBase = waitFor(AllianzClaimsHome.class);
        NoInsuredFoundPopupPage noInsuredFoundPopupPage = allianzBase.acceptCookies().selectAccidentOpponent()
                .selectDamageType("Mein Fahrzeug")
                .navigateToNextScreenAccidentOpponenet()
                .inputWhenAndWhereInfo("03-02-2020","Favoritenstraße","Wien")
                .navigateToNextScreen()
                .inputPersonalDetailsAccidentOpponent(personalDetails)
                .verifyPopUPTextAndConcludeBtn();

         noInsuredFoundPopupPage.softAssert("Leider konnten wir mit diesen Daten keinen Versicherungsnehmer identifizieren. Bitte korrigieren Sie die Daten oder kontaktieren Sie unsere Schaden-Schnell-Service Hotline unter 05 9009 9009 (Mo-Fr von 7:00 bis 18:00 Uhr)",noInsuredFoundPopupPage.popUpText);

    }
}
