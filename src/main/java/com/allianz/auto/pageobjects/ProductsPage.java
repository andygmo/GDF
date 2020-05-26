package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.allianz.claim.pageobjects.DriverDetailsPageClaims;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Label;
import org.openqa.selenium.By;

import java.util.List;

public class ProductsPage extends AllianzAutoBasePage<ProductsPage> {
    public final Label productLabel =  new Label(By.xpath("//div[@id='products']/div/div/mo-package-card/div/div/div/div/div[1]"));
    public final Button chooseProductBtn =  new Button(By.xpath("//button[@trackid='selectPackageButton']"));
    public final Button nextBtn =  new Button(By.xpath("//button[@id='footer_primary_button']"));

    public ProductsPage selectProduct(String productType) throws InterruptedException {

        List<Label> productLabels =  productLabel.getListOfElements();
        Thread.sleep(5000);
        List<Button> chooseProductBtns = chooseProductBtn.getListOfElements();

        for(int i=0;i<productLabels.size();i++){
            if(productLabels.get(i).getText().equalsIgnoreCase(productType)){
                Thread.sleep(5000);
                chooseProductBtns.get(i).click();
                Thread.sleep(5000);
                break;
            }
        }
        return this;
    }

    public HotLinePage navigateToNextScreen() throws InterruptedException {
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(HotLinePage.class);
    }
}
