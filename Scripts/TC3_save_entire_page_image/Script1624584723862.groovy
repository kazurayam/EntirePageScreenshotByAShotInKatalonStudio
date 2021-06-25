import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

import my.DevicePixelRatioResolver
import my.AShotWrapper

WebUI.openBrowser('')
WebUI.setViewPortSize(375, 667)
def topPageUrl = 'https://katalon-demo-cura.herokuapp.com/'
WebUI.navigateToUrl(topPageUrl)

// wait for the page is fully loaded
WebUI.verifyElementPresent(
	findTestObject('CURA Healthcare Service/Page_CuraHomepage/a_Make Appointment'), 10)

// take screenshot and save a PNG file
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path reportDir = projectDir.resolve('Screenshots')
Files.createDirectories(reportDir)
Path pngFile = reportDir.resolve('TC3_save_entire_page_image.png')

WebDriver driver = DriverFactory.getWebDriver()

// take screenshot of entire page
float dpr = DevicePixelRatioResolver.resolveDPR(driver)
AShotWrapper.saveEntirePageImage(driver, pngFile.toFile(), 500, dpr) 

WebUI.closeBrowser()