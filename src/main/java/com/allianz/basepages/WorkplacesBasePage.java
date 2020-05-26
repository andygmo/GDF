package com.allianz.basepages;

import com.allianz.basepages.PageObjectBase;
import com.sqs.web.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

//import com.allianz.pageobjects.basepages.PageObjectBase;

/**
 * Will be used as a base page to page objects allowing extension of head and footer elements to
 * page objects.
 */
public abstract class WorkplacesBasePage<TOriginPage> extends PageObjectBase<TOriginPage> {
    /*Get the current page title

  @param value the page name value
  @return the page title label*/

  @Step("The correct page title is displayed")
  public Label getPageTitleElement(String value) {
    return new Label(By.xpath("//h2[@nxheadline='page']"));
  }



}
