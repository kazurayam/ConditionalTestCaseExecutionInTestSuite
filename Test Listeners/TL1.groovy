import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext


import internal.GlobalVariable

class TL1 {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		GlobalVariable.TestCaseContextMap[toShortId(testCaseContext.getTestCaseId())] = testCaseContext
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		Map<String, TestCaseContext> contexts = (Map)GlobalVariable.TestCaseContextMap
		contexts.keySet().forEach { testCaseId ->
			TestCaseContext tcc = contexts.get(testCaseId)
			println testCaseId + ": " + tcc.getTestCaseStatus()
		}
	}
	
	String toShortId(String testCaseId) {
		return testCaseId.substring(testCaseId.indexOf('/') + 1)
	}
}