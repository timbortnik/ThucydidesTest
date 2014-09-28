package Exam;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import Exam.requirements.Application;

@Story(Application.Email.EmailOps.class)
@RunWith(ThucydidesRunner.class)
public class EmailDeleteStoryTest extends EmailBase{
	
    @Issue("#MAIL-3")
    @Test
    public void deleting_email() {
    	endUser.signs_in(login, pass, url);
        endUser.composes_email(testSubj, login);
        endUser.checks_email();
    	endUser.deletes_email(testSubj);
    	endUser.signs_out();
    }    
       
}
