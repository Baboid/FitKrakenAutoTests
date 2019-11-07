package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public WebDriver initilizeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ivan.babic\\eclipse-workspace\\FitKrakenAutomation\\src\\test\\java\\utils\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan.babic\\eclipse-workspace\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			// check later

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String createNewMemberName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();

		return person.firstName();

	}


	public String createUniqueEmail() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		Date d1 = new Date();
		return person.firstName() + d1.getTime() + "@getnada.com";
	}



}
