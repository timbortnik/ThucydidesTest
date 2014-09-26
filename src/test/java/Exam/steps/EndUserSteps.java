package Exam.steps;

import Exam.pages.EmailPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    EmailPage emailPage;
    
    @Step
    public void is_the_signin_page() {
        emailPage.open();
    }

    @Step
    public void enters_login(String login) {
        emailPage.enter_login(login);
    }

    @Step
    public void enters_pass(String pass) {
        emailPage.enter_pass(pass);
    }
    
    @Step
	public void pressing_login_button() {
		emailPage.signin_press();
	}

    @Step
    public void seeing_inbox(){
    	assertThat("true",emailPage.inbox_visible());
    }

    @Step
    public void signs_in(String login, String pass){
        is_the_signin_page();
    	enters_login(login);
    	enters_pass(pass);
    	pressing_login_button();
    	seeing_inbox();    	
    }

    @Step
    public void clicks_compose(){
    	emailPage.press_compose();
    }

    @Step
    public void enters_to(String to) {
        emailPage.enter_recipient(to);
    }

    @Step
    public void enters_subj(String subj) {
        emailPage.enter_subject(subj);
    }
    
    @Step
	public void pressing_send_button() {
		emailPage.send_press();
	}
    
    @Step
    public void composes_email(String subj, String to){
    	clicks_compose();
    	enters_to(to);
    	enters_subj(subj);
    	pressing_send_button();
    }



}