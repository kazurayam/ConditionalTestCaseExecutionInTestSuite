package com.kazurayam.ks

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class TestCaseTreeTracer {

	private TestCaseTreeTracer() {}
	
	static void verifyEdge(String fromTestCaseId, String toTestCaseId) {
		String fromTCId = normalize(fromTestCaseId)
		String toTCId = normalize(toTestCaseId)
		if (GlobalVariable.TestCaseTree != null) {
			Map<String, TestCaseContext> memo = (Map)GlobalVariable.TestCaseTree
			if (memo.containsKey(fromTCId)) {
				TestCaseContext tcc = memo.get(fromTCId)
				if ( tcc.getTestCaseStatus() != 'PASSED') {
					throw new StepFailedException("${toTCId} is going to quit because ${fromTCId} failed")
				}
			} else {
				KeywordUtil.markWarning("[TestCaseTreeTracer#verifyEdge] unknown TestCaseId: '${fromTCId}'")
			}
		} else {
			// does nothing if GlobalVariable.TestCaseTree is not defined
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
