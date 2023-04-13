import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable
import com.kazurayam.ks.TestCaseResults

class TL1 {
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		TestCaseResults.put(testCaseContext)
		println "[TestCaseResultRecorder#afterTestCase] added a node '${testCaseContext.getTestCaseId()}'"
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		TestCaseResults.println()
	}

}