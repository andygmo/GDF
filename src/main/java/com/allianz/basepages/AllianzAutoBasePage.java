package com.allianz.basepages;

import com.allianz.auto.pageobjects.AdditionalQuestionsPage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.RadioButton;
import com.sqs.web.elements.TextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

//import com.allianz.pageobjects.basepages.PageObjectBase;

/**
 * Will be used as a base page to page objects allowing extension of head and footer elements to
 * page objects.
 */
public abstract class AllianzAutoBasePage<TOriginPage> extends PageObjectBase<TOriginPage> {
    /*Get the current page title

  @param value the page name value
  @return the page title label*/

  @Step("The correct page title is displayed")
  public Label getPageTitleElement(String value) {
    return new Label(By.xpath("//h2[@nxheadline='page']"));
  }



}
