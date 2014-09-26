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

@DefaultUrl("https://www.hushmail.com/preview/hushmail/")
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

    @FindBy(css = "div.top input.send")
    private WebElementFacade sendButton;
    
    
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
    
}
