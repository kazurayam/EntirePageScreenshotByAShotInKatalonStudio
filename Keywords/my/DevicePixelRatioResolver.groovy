package my

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class DevicePixelRatioResolver {

	static float resolveDPR(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver
		String value = js.executeScript("return window.devicePixelRatio;")
		return Float.parseFloat(value)
	}
}
