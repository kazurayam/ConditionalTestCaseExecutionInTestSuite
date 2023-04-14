package com.kazurayam.ks

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable

/**
 * 
 * @author kazurayam
 */
public class TestCaseResults {

	private static Map<String, TestCaseContext> results = new HashMap<>()

	private TestCaseResults() {}

	static void put(TestCaseContext testCaseContext) {
		Objects.requireNonNull(testCaseContext)
		results.put(testCaseContext.getTestCaseId(), testCaseContext)
	}

	static TestCaseContext get(String testCaseId) {
		String tcId = normalize(testCaseId)
		return results.get(tcId)
	}

	static Set<String> keySet() {
		return results.keySet()
	}

	static String getTestCaseStatus(String testCaseId) {
		TestCaseContext tcc = get(testCaseId)
		if (tcc != null) {
			return tcc.getTestCaseStatus()
		} else {
			return null
		}
	}

	private static String normalize(String testCaseId) {
		if (testCaseId.startsWith('Test Cases/')) {
			return testCaseId
		} else {
			return 'Test Cases/' + testCaseId
		}
	}

	static Boolean assertTestCasePASSED(String testCaseId, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) 
			throws StepFailedException {
		String testCaseStatus = getTestCaseStatus(testCaseId)
		if (testCaseStatus != null) {
			if (testCaseStatus == 'PASSED') {
				return true
			} else {
				if (flowControl == FailureHandling.OPTIONAL) {
					KeywordUtil.markWarning("Test Case '${testCaseId}' had status ${testCaseStatus}")
					return false
				} else {
					throw new StepFailedException("current Test Case is going to quit because a preceding Test Case '${testCaseId}' did not PASS")
				}
			}
		} else {
			KeywordUtil.markWarning("unknown TestCaseId: '${testCaseId}'")
			return false
		}
	}

	static void println() {
		Set<String> keySet = keySet()
		if (keySet != null) {
			keySet.forEach { testCaseId ->
				TestCaseContext tcc = get(testCaseId)
				println "'${testCaseId}' : ${tcc.getTestCaseStatus()}"
			}
		}
	}
}