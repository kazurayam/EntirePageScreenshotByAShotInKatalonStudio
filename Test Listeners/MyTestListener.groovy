import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class MyTestListener {
	
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		WebUI.comment(">>> testCaseId is ${testCaseId}")
		GlobalVariable.CURRENT_TESTCASE_ID = testCaseId
		Map<String, Number> runsRecord = (Map<String, Number>)GlobalVariable.NUMBER_OF_TESTCASE_RUNS
		if (runsRecord.containsKey(testCaseId)) {
			WebUI.comment(">>> runRecord contains key ${testCaseId}")
			Number count = runsRecord.get(testCaseId)
			runsRecord.put(testCaseId, count + 1)
		} else {
			WebUI.comment(">>> runRecrod does not contain key ${testCaseId}")
			runsRecord.put(testCaseId, 1)
		}
		GlobalVariable.NUMBER_OF_TESTCASE_RUNS = runsRecord
	}
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		Path messagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("./message.txt")
		Files.deleteIfExists(messagePath)
	}
}