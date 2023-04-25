// Test Cases/conditional-withFailure/TCb3

import com.kazurayam.ks.TestCaseResults

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

boolean result = TestCaseResults.assertTestCasePASSED("conditional-skipOnFailure/TCd2", FailureHandling.OPTIONAL)
	
if (!result) {
	println "conditional-skipOnFailure/TCd3 skipped its processing body"
	return
}

WebUI.comment("conditional-skipOnFailure/TCd3 is running")
WebUI.delay(5)
WebUI.comment("conditional-skipOnFailure/TCd3 is running still")
WebUI.delay(5)
WebUI.comment("conditional-skipOnFailure/TCd3 is running yet")
WebUI.delay(5)
WebUI.comment("conditional-skipOnFailure/TCd3 is running even more")
WebUI.delay(5)
