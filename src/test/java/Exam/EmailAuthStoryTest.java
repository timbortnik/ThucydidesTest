package Exam;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import Exam.requirements.Application;

@Story(Application.Email.EmailOps.class)
@RunWith(ThucydidesRunner.class)
public class EmailAuthStoryTest extends EmailBase{
	
    @Issue("#MAIL-1")
    @Test
    public void signing_in_out() {
    	endUser.signs_in(login, pass, url);
    	endUser.signs_out();
    }    
       
}
