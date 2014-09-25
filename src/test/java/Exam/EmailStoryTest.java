package Exam;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Exam.requirements.Application;
import Exam.steps.EndUserSteps;

@Story(Application.Email.EmailOps.class)
@RunWith(ThucydidesRunner.class)
public class EmailStoryTest {
	
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

//  @ManagedPages(defaultUrl = "https://www.hushmail.com/preview/hushmail/")
//  For some reason, setting defaultUrl twice (here and in page class) 
//  would force url path to dub, so it was commented out
    
    @ManagedPages
    public Pages pages;

    @Steps
    public EndUserSteps endUser;
    
    @Issue("#MAIL-1")
    @Test
    public void signing_in() {
    	endUser.signs_in();
    }    

}
