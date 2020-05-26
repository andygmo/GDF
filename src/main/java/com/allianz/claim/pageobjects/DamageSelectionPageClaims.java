package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import org.openqa.selenium.By;

public class DamageSelectionPageClaims extends AllianzClaimsBasePage<DamageSelectionPageClaims> {

    public final Button nextBtn = new Button(By.xpath("//button[text()='Weiter']"));

    public final CheckBox MeinFahrzeugCheckBox = new CheckBox((By.xpath("//div[@id='damageSelectionMyVehicleDesktop']")));
    public final CheckBox AndereFahrzeugeCheckBox = new CheckBox((By.xpath("//div[@id='damageSelectionOthersVehicleDesktop']")));
    public final CheckBox EinePersonCheckBox = new CheckBox((By.xpath("//div[@id='damageSelectionPersonDesktop']")));
    public final CheckBox EinObjektCheckBox = new CheckBox((By.xpath("//div[@id='damageSelectionObjectDesktop']")));
    public final String MeinFahrzeugDamageText = "Mein Fahrzeug";
    public final String AndereFahrzeugeDamageText = "Andere Fahrzeuge";
    public final String EinePersonDamageText = "Eine Person";
    public final String EinObjektDamageText = "Ein Objekt";


    public DamageSelectionPageClaims selectDamageType(String damageType) throws InterruptedException {
        Thread.sleep(2000);


        if (MeinFahrzeugDamageText.contains(damageType)) {
            MeinFahrzeugCheckBox.click();

            System.out.println("damage type selected: " + damageType);
            return this;
        } else if (AndereFahrzeugeDamageText.contains(damageType)) {
            AndereFahrzeugeCheckBox.click();

            System.out.println("damage type selected: " + damageType);
            return this;
        } else if (EinePersonDamageText.contains(damageType)) {
            EinePersonCheckBox.click();

            System.out.println("damage type selected: " + damageType);
            return this;
        } else if (EinObjektDamageText.contains(damageType)) {
            EinObjektCheckBox.click();

            System.out.println("damage type selected: " + damageType);
            return this;
        } else {
            System.out.println("damage type selected:nothing ");
            return null;
        }

    }

    public WhatHappendPageClaims navigateToNextScreenAllianzCustomer() throws InterruptedException {
        Thread.sleep(2000);
        nextBtn.click();
        Thread.sleep(2000);
        return navigatingTo(WhatHappendPageClaims.class);
    }

    public WhenAndWherePageClaims navigateToNextScreenAccidentOpponenet() throws InterruptedException {
        Thread.sleep(2000);
        nextBtn.click();
        Thread.sleep(2000);
        return navigatingTo(WhenAndWherePageClaims.class);
    }
}


