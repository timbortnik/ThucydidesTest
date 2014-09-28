package Exam.steps;

import Exam.pages.EmailPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;

//
// This class contains steps definitions common for all Email Tests stories
//
public class EndUserSteps extends ScenarioSteps {

	EmailPage emailPage;
    
    @Step
    public void is_the_signin_page(String url) {
        emailPage.openAt(url);
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
    	assertThat("Inbox is visible", emailPage.inbox_visible());
    }

    @Step
    public void seeing_signin(){
    	assertThat("Signin prompt is visibe", emailPage.signin_visible());
    }

    @Step
    public void signs_in(String login, String pass, String url){
        is_the_signin_page(url);
    	enters_login(login);
    	enters_pass(pass);
    	pressing_login_button();
    	seeing_inbox();    	
    }
    
    @Step
    public void clicks_signoff(){
    	emailPage.click_signoff();
    }

    @Step
    public void signs_out(){
        clicks_signoff();
        seeing_signin();
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
    public void seeing_status_sent(){
    	assertThat("Email sent label appeared", emailPage.status_check("Sent"));
    }

    @Step
    public void composes_email(String subj, String to){
    	clicks_compose();
    	enters_to(to);
    	enters_subj(subj);
    	pressing_send_button();
    	seeing_status_sent();
    }
    
    @Step
    public String checks_box_by_subj(String subj){
    	return emailPage.checks_specific_subj(subj);
    }

    @Step
    public void clicks_delete(){
    	emailPage.click_del();
    }

    @Step
    public void clicks_move(){
    	emailPage.click_move();
    }
    
    @Step
    public void clicks_junk(){
    	emailPage.click_junk();
    }
    
    @Step
    public void confirms_trash(){
    	emailPage.click_trash();
    }
    
    @Step
    public void enters_junk(){
    	emailPage.enter_junk();
    }
    
    @Step
    public void seeing_status_delete(){
    	assertThat("Email deleted label appeared", emailPage.status_check("Deleted"));
    }

    @Step
    public void seeing_status_junk(){
    	assertThat("Email moved to Junk label appeared", 
    			emailPage.status_check("Moved item to Junk"));
    }

    @Step
    public void deletes_email(String subj){
    	String date;
    	
    	date = checks_box_by_subj(subj);
    	clicks_delete();
    	confirms_trash();
    	seeing_status_delete();
    	assertThat("Deleted email is not in inbox", 
    			!emailPage.is_specific_subj_date_present(subj, date));
    }
    
    @Step
    public void deletes_spam(String subj){
    	String date;
    	
    	date = checks_box_by_subj(subj);
    	clicks_move();
    	enters_junk();
    	clicks_junk();
    	seeing_status_junk();
    	assertThat("Deleted email is not in inbox", 
    			!emailPage.is_specific_subj_date_present(subj, date));
    }
  
    @Step
    public void checks_email(){
    	emailPage.click_check_mail();
    }
}