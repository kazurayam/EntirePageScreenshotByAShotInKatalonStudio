import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

// set display size similar to iPhone 5.5 extended
WebUI.setViewPortSize(375, 667)

def topPageUrl = 'https://katalon-demo-cura.herokuapp.com/'

WebUI.navigateToUrl(topPageUrl)

// this verification will PASS
WebUI.verifyElementPresent(
	findTestObject('CURA Healthcare Service/Page_CuraHomepage/a_Make Appointment'),
	10,
	FailureHandling.CONTINUE_ON_FAILURE)

// take screenshot and save a PNG file into Reports dir
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path reportDir = projectDir.resolve('Screenshots')
Files.createDirectories(reportDir)
Path pngFile = reportDir.resolve('TC2_viewport_only_screenshot_.png')

WebUI.takeScreenshot(pngFile.toString(), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()