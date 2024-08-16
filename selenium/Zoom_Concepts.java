package selenium;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoom_Concepts {
	static WebDriver driver ;
	
	public static void main(String[] args) throws InterruptedException {

    driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();
    
  //  chromeZoom("50");
      fireFoxZoom("150");
    
	}
	
	
	public static void chromeZoom(String zoomPercentage) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    String chromezoom = "document.body.style.zoom = '"+zoomPercentage+"%'";
	    js.executeScript(chromezoom);
	}
	
	public static void fireFoxZoom(String zoomPercentage) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 String zoomFirefox = "document.body.style.zoom = '"+zoomPercentage+"%'";
		// String zoomFirefox = "document.body.style.MozTransform = 'scale("+zoomPercentage+")'";
	    js.executeScript(zoomFirefox);
	}


}
