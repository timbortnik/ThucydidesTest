package Exam;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import Exam.requirements.Application;

@Story(Application.Email.EmailOps.class)
@RunWith(ThucydidesRunner.class)
public class EmailComposeStoryTest extends EmailBase{
	
    @Issue("#MAIL-2")
    @Test
    public void composing_email(){
    	endUser.signs_in(login, pass, url);
        endUser.composes_email("[test]"+testSubj, login);
        endUser.signs_out();
    }
    
}
