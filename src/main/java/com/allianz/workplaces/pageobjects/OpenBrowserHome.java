package com.allianz.workplaces.pageobjects;

import com.allianz.auto.pageobjects.AdditionalQuestionsPage;
import com.allianz.basepages.AllianzAutoBasePage;
import com.allianz.basepages.WorkplacesBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.RadioButton;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * The Presta home page.
 */
public class OpenBrowserHome extends WorkplacesBasePage<OpenBrowserHome> {

   /**
   * Instantiates a new Auto home.
   */
   public WebDriver driver;
   public final TextInput searchTextBox=new TextInput(By.xpath("//input[@name='q']"));
  public OpenBrowserHome() {
    driver = DriverProvider.getDriver();
  }

 public OpenBrowserHome openFlashPlayerSite(String url) throws InterruptedException {
        driver.get(url);
        System.out.println("Title:"+driver.getTitle());

     return navigatingTo(OpenBrowserHome.class);
 }

 public void searchSite(String site){
      searchTextBox.setText(site+ Keys.ENTER);
  }

}
