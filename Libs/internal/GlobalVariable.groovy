package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : Number of runs of test cases including re-runs</p>
     */
    public static Object NUMBER_OF_TESTCASE_RUNS
     
    /**
     * <p></p>
     */
    public static Object CURRENT_TESTCASE_ID
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['NUMBER_OF_TESTCASE_RUNS' : [('sample') : 0], 'CURRENT_TESTCASE_ID' : ''])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        NUMBER_OF_TESTCASE_RUNS = selectedVariables['NUMBER_OF_TESTCASE_RUNS']
        CURRENT_TESTCASE_ID = selectedVariables['CURRENT_TESTCASE_ID']
        
    }
}
