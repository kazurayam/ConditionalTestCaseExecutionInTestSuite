import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kazurayam.ks.TestCaseResults

TestCaseResults.assertTestCasePASSED("conditional-withFailure/TCb1")

WebUI.comment("conditional-withFailure/TCb2 is running")

KeywordUtil.markFailedAndStop("Test Cases/conditional-withFailure/TCb2 failed intentionally")