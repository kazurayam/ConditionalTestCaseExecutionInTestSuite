import com.kazurayam.ks.TestCaseResults
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TL1 {
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		TestCaseResults.put(testCaseContext)
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		TestCaseResults.println()
	}

}