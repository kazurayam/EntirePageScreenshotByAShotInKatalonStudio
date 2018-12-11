import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

void takeEntirePage(WebDriver webDriver, File file, Integer timeout = 300) {
	Screenshot screenshot = new AShot().
			coordsProvider(new WebDriverCoordsProvider()).
			shootingStrategy(ShootingStrategies.viewportPasting(timeout)).
			takeScreenshot(webDriver)
	ImageIO.write(screenshot.getImage(), "PNG", file)
}

WebUI.openBrowser('')
WebUI.setViewPortSize(375, 667) // width, height

WebUI.navigateToUrl('https://fontawesome.com/icons?d=gallery')
WebUI.verifyElementPresent(
   findTestObject('Font Awesome/Page_Icons/section_results_icons'),
   20, FailureHandling.STOP_ON_FAILURE)

Path png = Paths.get(RunConfiguration.getProjectDir()).resolve('Reports/screenshot.png')
takeEntirePage(DriverFactory.getWebDriver(), png.toFile())

WebUI.closeBrowser()