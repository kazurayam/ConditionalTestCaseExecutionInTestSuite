package com.kazurayam.ks

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class TestCaseResults {
	
	private static String CLASS_SHORT_NAME = 'TestCaseResults'

	private TestCaseResults() {}
	
	static void put(TestCaseContext testCaseContext) {
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			GlobalVariable.TestCaseResults[testCaseContext.getTestCaseId()] = testCaseContext
		}
	}

	static void assertTestCasePASSED(String testCaseId) throws StepFailedException {
		String tcId = normalize(testCaseId)
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			Map<String, TestCaseContext> memo = (Map)GlobalVariable.TestCaseResults
			if (memo.containsKey(tcId)) {
				TestCaseContext tcc = memo.get(tcId)
				if ( tcc.getTestCaseStatus() != 'PASSED') {
					throw new StepFailedException("current Test Case is going to quit because a preceding Test Case '${tcId}' did not PASSED")
				}
			} else {
				KeywordUtil.markWarning("[${CLASS_SHORT_NAME}#assertPASSED] unknown TestCaseId: '${tcId}'")
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
	
	static void println() {
		if (GlobalVariable.TestCaseResults != null && GlobalVariable.TestCaseResults instanceof Map) {
			Map<String, TestCaseContext> map = (Map)GlobalVariable.TestCaseResults
			map.keySet().forEach { testCaseId ->
				TestCaseContext tcc = map.get(testCaseId)
				println "[${CLASS_SHORT_NAME}#afterTestSuite] '${testCaseId}' : ${tcc.getTestCaseStatus()}"
			}
		} else {
			// does nothing if GlobalVariable.TestCaseResults is not defined
		}
	}
}