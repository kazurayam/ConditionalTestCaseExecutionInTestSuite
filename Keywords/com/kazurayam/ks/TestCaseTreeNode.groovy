package com.kazurayam.ks

import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class TestCaseTreeNode {

	private String contextTestCaseId

	TestCaseTreeNode(String testCaseId) {
		if (testCaseId.startsWith('Test Cases/')) {
			this.contextTestCaseId = contextTestCaseId
		} else {
			this.contextTestCaseId = 'Test Cases/' + testCaseId
		}
		if (GlobalVariable.TestCaseTree != null) {
			GlobalVariable.TestCaseTree[this.contextTestCaseId] = false
		}
	}

	void follows(String testCaseId) {
		String hookTestCaseId
		if (testCaseId.startsWith('Test Cases/')) {
			hookTestCaseId = testCaseId
		} else {
			hookTestCaseId = 'Test Cases/' + testCaseId
		}
		if (GlobalVariable.TestCaseTree != null) {
			Map<String, TestCaseContext> memo = (Map)GlobalVariable.TestCaseTree
			if (memo.containsKey(hookTestCaseId)) {
				TestCaseContext tcc = memo.get(hookTestCaseId)
				if ( tcc.getTestCaseStatus() != 'PASSED') {
					throw new StepFailedException("${this.contextTestCaseId} is going to quit because ${hookTestCaseId} failed")
				}
			} else {
				KeywordUtil.markWarning("[TestCaseTreeNode#follows] unknown TestCaseId: '${hookTestCaseId}'")
			}
		} else {
			// does nothing if GlobalVariable.TestCaseTree is not defined
		}
	}
}
