import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 768)

def topPageUrl = 'https://katalon-demo-cura.herokuapp.com/'

WebUI.navigateToUrl(topPageUrl)

// this verification will PASS
WebUI.verifyElementPresent(
	findTestObject('CURA Healthcare Service/Page_CuraHomepage/a_Make Appointment'),
	5,
	FailureHandling.CONTINUE_ON_FAILURE)

// this verification will FAIL
WebUI.verifyElementPresent(
	findTestObject('CURA Healthcare Service/Page_CuraHomepage/h3_We Care About Your Doll'),
	5,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()