package my

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class FlowControl {

	private String contextTestCaseShortId
	
	FlowControl(String contextTestCaseShortId) {
		this.contextTestCaseShortId = contextTestCaseShortId
	}
	
	void assertDependentTestCasePassed(String dependentTestCaseShortId) {
		Map<String, TestCaseContext> contexts = (Map)GlobalVariable.TestCaseContextMap
		if (contexts.containsKey(dependentTestCaseShortId)) {
			TestCaseContext tcc = contexts.get(dependentTestCaseShortId)
			println contextTestCaseShortId + "," + dependentTestCaseShortId + "," + tcc.getTestCaseStatus()
			if ( tcc.getTestCaseStatus() != 'PASSED') {
				throw new StepFailedException("${contextTestCaseShortId} is going to quit because its dependent Test Case ${dependentTestCaseShortId} failed")
			}
		} else {
			KeywordUtil.markFailedAndStop("dependentTestCaseShortId '${dependentTestCaseShortId}' is not found in the TestCaseContextMap")
		}
	}
}
