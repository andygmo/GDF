package com.allianz.auto.pageobjects;

import com.allianz.basepages.AllianzAutoBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.TextArea;
import com.sqs.web.elements.TextInput;
import org.openqa.selenium.By;

import java.util.List;

public class AdditionalQuestionsPage extends AllianzAutoBasePage<AdditionalQuestionsPage> {

    public final TextInput zipCodePLZTextBox =  new TextInput(By.xpath("//input[@trackid='zipCode']"));
    public final TextInput birthDateTextBox =  new TextInput(By.xpath("//input[@trackid='additionalQuestions.birthdate']"));
    public final TextArea bonusMalusTextArea = new TextArea(By.xpath("//nx-dropdown[@id='bomaLevel']"));
    public final Button bonusMalusDropdownItem = new Button(By.xpath("//nx-dropdown-item[@trackid='bonusMalus']"));
    public final Button nextBtn =  new Button(By.xpath("//button[@id='navigation_primary_button']"));
    public final TextInput RegistrationTextBox = new TextInput(By.xpath("//input[@trackid='firstRegistrationDate']"));
    /*public final Button calendarBtn =  new Button(By.xpath("//button[@class='nx-datepicker-toggle-button']"));
    public final Button calendarPeriodBtn =  new Button(By.xpath("//button[@class='nx-calendar-period-button']"));
*/
    public AdditionalQuestionsPage inputAdditionalDetails(String zipcode, String birthDate, String bonusMalusValue) throws InterruptedException {
        /*Table yearTable = new Table(By.xpath("//table[@class='nx-calendar-table']"));
        Button calendarPreviousBtn = new Button(By.xpath("//button[@class='nx-calendar-previous-button']"));*/
        Thread.sleep(5000);
        zipCodePLZTextBox.click();
        zipCodePLZTextBox.setText(zipcode);
        birthDateTextBox.click();
        birthDateTextBox.setText(birthDate);
        bonusMalusTextArea.click();
        List<Button> bonusMalusDropdownItems = bonusMalusDropdownItem.getListOfElements();
        for(int i=0;i<bonusMalusDropdownItems.size();i++) {
            if (bonusMalusDropdownItems.get(i).getAttribute("trackValue").equalsIgnoreCase(bonusMalusValue)) {
                bonusMalusDropdownItems.get(i).click();
                break;
            }
        }
        return this;

    }

    public AdditionalQuestionsPage inputRegistratiodateDetail(String RegistrationDate) throws InterruptedException {
        Thread.sleep(5000);
        RegistrationTextBox.click();
        RegistrationTextBox.setText(RegistrationDate);
        return this;
    }

    public ProductsPage navigateToNextScreen() throws InterruptedException {
        Button nextBtn =  new Button(By.xpath("//button[@class='nx-button--primary nx-button--medium nx-button--block']"));
        Thread.sleep(1000);
        nextBtn.click();
        Thread.sleep(5000);
        return navigatingTo(ProductsPage.class);
    }




}



        /* calendarBtn.click();
        String birthDateArray[] = birthDate.split(".");
        String date = birthDateArray[0];
        String month = birthDateArray[1];
        String year = birthDateArray[2];

        if(!calendarPeriodBtn.getText().contains(year)){
            calendarPeriodBtn.click();
        }
        for(int i=1;i<=yearTable.getRowCount();i++){
            for(int j=1;i<=yearTable.getColumnCount();j++){
                if(yearTable.checkRowContains(i,"1990")){
                    yearTable.clickCell(i,j);
                    break;
                }else{
                    calendarPreviousBtn.click();
                    continue
                }
            }
*/


