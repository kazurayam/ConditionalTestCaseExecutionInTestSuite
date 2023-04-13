import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable

class TestCaseTreeBuilder {
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		println "[TestCaseTreeBuilder#afterTestCase] added a node ${testCaseContext.getTestCaseId()}"
		if (GlobalVariable.TestCaseTree != null) {
			GlobalVariable.TestCaseTree[testCaseContext.getTestCaseId()] = testCaseContext
		}
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		if (GlobalVariable.TestCaseTree != null) {
			Map<String, TestCaseContext> contexts = (Map)GlobalVariable.TestCaseTree
			contexts.keySet().forEach { testCaseId ->
				TestCaseContext tcc = contexts.get(testCaseId)
				println "[TestCaseTreeBuilder#afterTestSuite] ${testCaseId} : ${tcc.getTestCaseStatus()}"
			}
		} else {
			// does nothing if GlobalVariable.TestCaseTree is not defined
		}
	}

}