// Test Cases/conditional-withFailure/TCb2

import com.kazurayam.ks.TestCaseResults

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

TestCaseResults.assertTestCasePASSED("conditional-skipOnFailure/TCd1")

println "conditional-skipOnFailure/TCd2 is running"

KeywordUtil.markFailedAndStop("Test Cases/conditional-skipOnFailure/TCd2 failed intentionally")