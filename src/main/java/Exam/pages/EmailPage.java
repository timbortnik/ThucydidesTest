package Exam.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

// We do not need default url as URL is passed as parameter
//@DefaultUrl("https://www.hushmail.com/preview/hushmail/")

//
// This class encapsulates everything selector-wise and page-specific
//
public class EmailPage extends PageObject {

    @FindBy(css = "input#hush_username")
    private WebElementFacade userLogin;

    @FindBy(css = "input#hush_passphrase")
    private WebElementFacade userPass;
    
    @FindBy(css = "div#submit-container > input")
    private WebElementFacade loginButton;
    
    @FindBy(css = "a.open-folder.inbox")
    private WebElementFacade inbox;
  
    @FindBy(css = "div#header-content-primary-buttons > a.compose-message")
    private WebElementFacade compose;

    @FindBy(css = "textarea#to-field")
    private WebElementFacade toField;

    @FindBy(css = "input#subject-field")
    private WebElementFacade subjectField;
    
    @FindBy(css = "a#event_sign-out-link")
    private WebElementFacade signoff;

    @FindBy(css = "div.top input.send")
    private WebElementFacade sendButton;
    
    @FindBy(css = "div#element_status.success span.element_text")
    private WebElementFacade status;
    
    @FindBy(css = "input.button.delete-messages")
    private WebElementFacade deleteButton;    
    
    @FindBy(css = "input.button.move-messages")
    private WebElementFacade moveButton;    
    
    @FindBy(css = "form#element_move-folder-form li.ac_over")
    private WebElementFacade moveJunk;    
    
    @FindBy(xpath = "//div[@class='buttons']/input[@value = 'Move to Trash']")
    private WebElementFacade trashButton;    
    
    @FindBy(css = "div#header-content-primary-buttons a.check-mail")
    private WebElementFacade checkMailButton;    
    
    @FindBy(css = "div#header-content-primary-buttons a.check-mail.loading")
    private WebElementFacade checkMailButtonLoading;    
    
    @FindBy(css = "input#element_move-to-folder-autocomplete-input")
    private WebElementFacade moveFolder;    
    
    
    
    // Reference a checkbox without WebElementFacade, constructing xPath selector in runtime
    // Sample selector: "//a[@title='Test e-mail #4455012342']/../../td/input[@type='checkbox']"
    // returns date value for checked e-mail
    public String checks_specific_subj(String subj){
    	this.$("//a[@title='" + subj + "']/../../td/input[@type='checkbox']").click();
    	// date of the selected message
    	return this.$("//a[@title='" + subj + "']/../../td[@class='date']/a").getAttribute("title");
    }
    
    public boolean is_specific_subj_date_present(String subj, String date){
    	return !getDriver().findElements(
    			By.xpath("//a[@title='" + subj + "']/../../td[@class='date']/a[@title='"+date+"']")).isEmpty();
    }
    
    public void enter_login(String login) {
     	userLogin.type(login);
    }
    
    public void enter_pass(String pass) {
        userPass.type(pass);
    }
    
    public void signin_press(){
    	loginButton.submit();
    }
    
    public boolean inbox_visible(){
    	return inbox.isVisible();
    }
    
    public void press_compose(){
    	compose.click();
    }

    public void enter_recipient(String to) {
        toField.type(to);
    }
    
    public void enter_subject(String subj) {
        subjectField.type(subj);
    }
    
    public void send_press(){
    	sendButton.click();
    }
    
    public boolean signin_visible(){
    	return userLogin.isVisible();
    }

    public void click_signoff(){
    	signoff.click();
    }

    public void click_del(){
    	deleteButton.click();
    }
    
    public void click_trash(){
    	trashButton.waitUntilVisible();
    	trashButton.click();
    }
    
    public boolean status_check(String st){
    	status.waitUntilVisible();
    	return status.containsText(st);
    }

    public void click_move(){
    	moveButton.click();
    }

    public void enter_junk(){
    	moveFolder.type("Junk");
    }
    
    public void click_junk(){
    	moveJunk.click();
    }
    
    public void click_check_mail(){
    	checkMailButton.click();
    	checkMailButtonLoading.waitUntilNotVisible();
    }

}
