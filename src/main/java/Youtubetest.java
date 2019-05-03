import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Youtubetest {

	public static void main(String[] args) throws InterruptedException, FindFailed {

		
		/*
		 * No need to take the headache of XPath, CSS, ID and Name. 
+Sikuli is an image-based open source tool to automate the GUI and can be used on any platform like Windows/Linux/Mac/Mobile. 
+Sikuli uses a technique called image recognition to identify and control GUI components.
====================================================
• Automate using images by taking screenshot of a particular thing and storing it in local and clicking it
• No API to launch Browser and URL – need to use selenium
• Can automate flash objects – YouTube video
• Desktop application automation
===================================================*/
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// The below method is used for which the drop down HTML element is not select 
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=22");
		
		Screen s=new Screen();
		
		Pattern p= new Pattern("YT_Pause.JPG");
		s.wait(p,5000);
		s.click();
		s.click(); //sometimes we need to click twice to do an operation
		
		Pattern p1= new Pattern("YT_Mute.JPG");
		s.wait(p1,3000);
		s.click();
		
		Pattern p2= new Pattern("YT_Play.JPG");
		s.wait(p2,5000);
		s.click();
		s.click();
		
		Pattern TheatreMode= new Pattern("YT_TheatreMode.JPG");
		s.wait(TheatreMode,5000);
		s.click();
		
		Pattern EnterFullScreen= new Pattern("YT_FullScreen.JPG");
		s.wait(EnterFullScreen,5000);
		s.click();
		
		Pattern ExitFullScreen= new Pattern("YT_ExitFullScreen.JPG");
		s.wait(ExitFullScreen,5000);
		s.click();
		
		
	}

}
