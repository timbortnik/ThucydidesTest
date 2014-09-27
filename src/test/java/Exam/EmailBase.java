package Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Exam.requirements.Application;
import Exam.steps.EndUserSteps;

@Story(Application.Email.EmailOps.class)
@RunWith(ThucydidesRunner.class)
public class EmailBase {
	
	String 	login, pass, testSubj, url;
	
    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    
    @ManagedPages
    public Pages pages;
    
    @Before
    public void setupParams() {
    	// Try to load properties from file
    	File file = new File("email.properties");
		Properties properties = new Properties();
		try {
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		// If properties were not loaded for some reason, we go with defaults
		login = properties.getProperty("user.login", "thucy@hushmail.com");
    	pass = properties.getProperty("user.pass", "testpass");
    	testSubj = properties.getProperty("test.subj", "Test e-mail #4455012342" );
    	url = properties.getProperty("url", "https://www.hushmail.com/preview/hushmail/" );
	}
    
    @Steps
    public EndUserSteps endUser;
       
}
