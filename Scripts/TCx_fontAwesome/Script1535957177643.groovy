import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.nio.file.Paths

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import my.AShotWrapper
import my.DevicePixelRatioResolver

/**
 * demo of taking screenshot of a web page with extreme height
 */

WebUI.openBrowser('')
WebUI.setViewPortSize(375, 667) // width, height

WebDriver driver = DriverFactory.getWebDriver()
float dpr = DevicePixelRatioResolver.resolveDPR(driver)

WebUI.navigateToUrl('https://fontawesome.com/icons?d=gallery')
WebUI.verifyElementPresent(
   findTestObject('Font Awesome/Page_Icons/section_results_icons'), 20)

Path png = Paths.get(RunConfiguration.getProjectDir()).resolve('Screenshots/TCx_fontAwesome.png')

AShotWrapper.saveEntirePageImage(driver, png.toFile(), 100, dpr)

WebUI.closeBrowser()