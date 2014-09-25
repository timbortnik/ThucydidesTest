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
    
    
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
    
}