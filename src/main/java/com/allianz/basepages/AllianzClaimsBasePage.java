package com.allianz.basepages;

import com.allianz.claim.pageobjects.DamageSelectionPageClaims;
//import com.allianz.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Will be used as a base page to page objects allowing extension of head and footer elements to
 * page objects.
 */
public abstract class AllianzClaimsBasePage<TOriginPage> extends PageObjectBase<TOriginPage> {


  public final Button acceptCookieBtn = new Button(By.xpath("//div[@class='optanon-alert-box-button-middle accept-cookie-container']"));
  public final Button  allianzCustomerBtn = new Button(By.xpath("//button[@id='welcome-screen__btn-start-as-allianz-customer']"));
  public final Button  accidentOpponentBtn = new Button(By.xpath("//button[@id='welcome-screen__btn-start-as-accident-opponent']"));
  /**
   * Get the current page title
   *
   * @param value the page name value
   * @return the page title label
   */
  @Step("The correct page title is displayed")
  public Label getPageTitleElement(String value) {
    return new Label(By.xpath("//h1[@class='fnol-title column u-is-10 u-is-offset-1']"));
  }

  public AllianzClaimsBasePage acceptCookies() throws InterruptedException {
    Thread.sleep(5000);
    acceptCookieBtn.click();
    return this;
  }

  public DamageSelectionPageClaims selectAllianzCustomer() throws InterruptedException {
    Thread.sleep(5000);
    allianzCustomerBtn.click();
    return navigatingTo(DamageSelectionPageClaims.class);
  }

  public DamageSelectionPageClaims selectAccidentOpponent() throws InterruptedException {
    Thread.sleep(5000);
    accidentOpponentBtn.click();
    return navigatingTo(DamageSelectionPageClaims.class);
  }
}
