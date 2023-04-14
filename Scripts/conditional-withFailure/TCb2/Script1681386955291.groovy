// Test Cases/conditional-withFailure/TCb2

import com.kazurayam.ks.TestCaseResults

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

TestCaseResults.assertTestCasePASSED("conditional-withFailure/TCb1")
// or
//Boolean result = TestCaseResults.assertTestCasePASSED("conditional-withFailure/TCb1", FailureHandling.OPTIONAL)

WebUI.comment("conditional-withFailure/TCb2 is running")

KeywordUtil.markFailedAndStop("Test Cases/conditional-withFailure/TCb2 failed intentionally")