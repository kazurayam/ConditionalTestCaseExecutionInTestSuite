import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable

class TestCaseResultRecorder {
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		println "[TestCaseContextRecorder#afterTestCase] added a node '${testCaseContext.getTestCaseId()}'"
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			GlobalVariable.TestCaseResults[testCaseContext.getTestCaseId()] = testCaseContext
		}
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			Map<String, TestCaseContext> map = (Map)GlobalVariable.TestCaseResults
			map.keySet().forEach { testCaseId ->
				TestCaseContext tcc = map.get(testCaseId)
				println "[TestCaseContextRecorder#afterTestSuite] '${testCaseId}' : ${tcc.getTestCaseStatus()}"
			}
		} else {
			// does nothing if GlobalVariable.TestCaseTree is not defined
		}
	}

}