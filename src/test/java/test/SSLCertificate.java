package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificate {

	public static void main(String[] args) {
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("capbilityType.Accept_ssl_certs", true);
		WebDriver driver = new ChromeDriver(capability);

	}

}
