package com.sqs.allianztests;

import com.allianz.claim.pageobjects.AllianzClaimsHome;
import com.allianz.claim.pageobjects.FinishScreenPageClaims;
import com.allianz.claim.pageobjects.NoInsuredFoundPopupPage;
import com.allianz.utils.PersonalDetails;
import com.allianz.workplaces.pageobjects.OpenBrowserHome;
import com.sqs.allianztests.base.AllianzBaseTest;
import org.testng.annotations.Test;

public class FlashPlayerTest extends AllianzBaseTest {

    public void flashPlayerTest1() throws InterruptedException {
        OpenBrowserHome openBrowserHome = waitFor(OpenBrowserHome.class);
        openBrowserHome.openFlashPlayerSite("http://www.youtube.com");
    }
    @Test
    public void flashPlayerTest2() throws InterruptedException {
        OpenBrowserHome openBrowserHome = waitFor(OpenBrowserHome.class);
        openBrowserHome.openFlashPlayerSite("http://www.google.com").searchSite("youtube");
    }
}
