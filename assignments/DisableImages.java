package selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImages {

	private static final String FirefoxDriver = null;

	public static void main(String[] args) {

	//	ChromeOptions option = new ChromeOptions();
		EdgeOptions option = new EdgeOptions();
		disableImageChrome(option);

		WebDriver driver = new EdgeDriver(option);
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();

	}

	public static void disableImageChrome(EdgeOptions option) {

		Map<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);

		option.setExperimentalOption("prefs", prefs);
	}
	
	public static void disableImageFirefox(FirefoxOptions option) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		option.setProfile(profile);
		option.setCapability(FirefoxDriver,profile);
		

	}
}
