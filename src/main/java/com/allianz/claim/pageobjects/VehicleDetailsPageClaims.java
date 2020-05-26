package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import org.openqa.selenium.By;
import com.sqs.web.elements.Button;

import java.util.List;

public class VehicleDetailsPageClaims extends AllianzClaimsBasePage<VehicleDetailsPageClaims> {
    public final Button carAlreadyRepairedBtn = new Button(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='isTheCarAlreadyRepaired']"));
    public final Button carPreexistingDamagesBtn = new Button(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='hasTheCarPreexistingDamages']"));
    public final Button thePoliceAttendedBtn = new Button(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='hasThePoliceAttended']"));
    public final Button theCarStillDrivableBtn = new Button(By.xpath("//fnol-radio-circle[@ng-reflect-state-field='isTheCarStillDrivable']"));
    public final Button nextBtn = new Button(By.xpath("//button[@class='a-button u-is-middle fnol-navigation__button fnol-navigation__next-button u-is-primary']"));

    public VehicleDetailsPageClaims selectVehicleDetails(String iscarAlreadyRepaired, String hasThePreexistingDamages, String hasThePoliceAttended, String isTheCarStillDrivable) throws InterruptedException {
        String carRepairedOption = "null";
        String preExixstingDamagesOption = "null";
        String thePoliceAttendedOption = "null";
        String theCarStillDrivableOption = "null";

        if (iscarAlreadyRepaired.equalsIgnoreCase("Nein")) {
            carRepairedOption = "false";
        } else if (iscarAlreadyRepaired.equalsIgnoreCase("Ja")) {
            carRepairedOption = "true";
        }

        if (hasThePreexistingDamages.equalsIgnoreCase("Nein")) {
            preExixstingDamagesOption = "false";
        } else if (iscarAlreadyRepaired.equalsIgnoreCase("Ja")) {
            preExixstingDamagesOption = "true";
        }

        if (hasThePoliceAttended.equalsIgnoreCase("Nein")) {
            thePoliceAttendedOption = "false";
        } else if (hasThePoliceAttended.equalsIgnoreCase("Ja")) {
            thePoliceAttendedOption = "true";
        }

        if (isTheCarStillDrivable.equalsIgnoreCase("Nein")) {
            theCarStillDrivableOption = "false";
        } else if (isTheCarStillDrivable.equalsIgnoreCase("Ja")) {
            theCarStillDrivableOption = "true";
        }
        Thread.sleep(2000);

        List<Button> carAlreadyRepairedBtns = carAlreadyRepairedBtn.getListOfElements();
        for (int i = 0; i < carAlreadyRepairedBtns.size(); i++) {
            String text=carAlreadyRepairedBtns.get(i).getAttribute("ng-reflect-button-value");
            System.out.println("carAlreadyRepairedBtns:"+ text);
            if (carAlreadyRepairedBtns.get(i).getAttribute("ng-reflect-button-value").equalsIgnoreCase(carRepairedOption)) {
                carAlreadyRepairedBtns.get(i).click();
                break;
            }
        }

        List<Button> carPreexistingDamagesBtns = carPreexistingDamagesBtn.getListOfElements();
        for (int i = 0; i <carPreexistingDamagesBtns.size(); i++) {
            if (carPreexistingDamagesBtns.get(i).getAttribute("ng-reflect-button-value").equalsIgnoreCase(preExixstingDamagesOption)) {
                carPreexistingDamagesBtns.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);

        List<Button> thePoliceAttendedBtns = thePoliceAttendedBtn.getListOfElements();
        for (int i = 0; i < thePoliceAttendedBtns.size(); i++) {
            if (thePoliceAttendedBtns.get(i).getAttribute("ng-reflect-button-value").equalsIgnoreCase(thePoliceAttendedOption)) {
                thePoliceAttendedBtns.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        List<Button> theCarStillDrivableBtns = theCarStillDrivableBtn.getListOfElements();
        for (int i = 0; i <= theCarStillDrivableBtns.size(); i++) {
            if (theCarStillDrivableBtns.get(i).getAttribute("ng-reflect-button-value").equalsIgnoreCase(theCarStillDrivableOption)) {
                theCarStillDrivableBtns.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        return this;
 }

    public AdditionalInfoPageClaims navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(AdditionalInfoPageClaims.class);
    }

}
