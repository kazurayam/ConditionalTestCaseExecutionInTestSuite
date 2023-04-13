package com.kazurayam.ks

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class TestCaseResults {

	private TestCaseResults() {}

	static void assertPASSED(String testCaseId) throws StepFailedException {
		String tcId = normalize(testCaseId)
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			Map<String, TestCaseContext> memo = (Map)GlobalVariable.TestCaseResults
			if (memo.containsKey(tcId)) {
				TestCaseContext tcc = memo.get(tcId)
				if ( tcc.getTestCaseStatus() != 'PASSED') {
					throw new StepFailedException("current Test Case is going to quit because a preceding Test Case '${tcId}' did not PASSED")
				}
			} else {
				KeywordUtil.markWarning("[TestCaseResultsEvaluator#verifyPASSED] unknown TestCaseId: '${tcId}'")
			}
		} else {
			// does nothing if GlobalVariable.TestCaseResults is not defined
		}
	}

	static String normalize(String testCaseId) {
		if (testCaseId.startsWith('Test Cases/')) {
			return testCaseId
		} else {
			return 'Test Cases/' + testCaseId
		}
	}
}
