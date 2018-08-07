import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.setViewPortSize(375, 12000) // width, height

WebUI.navigateToUrl('https://fontawesome.com/icons?d=gallery')

WebUI.verifyElementPresent(
	findTestObject('Page_Icons  Font Awesome/section_results_icons'),
	20, FailureHandling.STOP_ON_FAILURE)

Path png = Paths.get(System.getProperty('user.dir')).resolve('Reports/screenshot.png')

CustomKeywords.'com.kazurayam.ksbackyard.AShotDriver.takeEntirePage'(
	DriverFactory.getWebDriver(),
	png.toFile())

WebUI.closeBrowser()
