package com.allianz.claim.pageobjects;

import com.allianz.basepages.AllianzClaimsBasePage;

import com.sqs.core.common.Config;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;

/**
 * The Presta home page.
 */
public class AllianzClaimsHome extends AllianzClaimsBasePage<AllianzClaimsHome> {

 private final Hyperlink allianzLogo = new Hyperlink(By.xpath("//*[@class='o-header-main-navigation']/div/img"));

  /**
   * Instantiates a new Allianz home.
   */
  public AllianzClaimsHome() {
    DriverProvider.getDriver().get(Config.getGlobalProperty("fnolUrl"));

  }

}
