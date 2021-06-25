import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String nth(Number v) {
	if (v == 1) {
		return '1st'
	} else if (v == 2) {
		return '2nd'
	} else if (v == 3) {
		return '3rd'
	} else {
		return "${v}th"
	}
}

String testCaseId = (String)GlobalVariable.CURRENT_TESTCASE_ID
Map<String, Number> runRecord = (Map<String, Number>)GlobalVariable.NUMBER_OF_TESTCASE_RUNS
Number runs = runRecord.get(testCaseId)
String message = ">>> ${testCaseId} ran for the ${nth(runs)} time"
WebUI.comment(message)

Path messagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("./message.txt")
WebUI.comment(">>> ${messagePath.toString()}")
File messageFile = messagePath.toFile()
messageFile.append("${message}\n")


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