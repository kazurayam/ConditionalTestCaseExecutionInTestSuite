import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kazurayam.ks.TestCaseResults

TestCaseResults.assertPASSED("withControl/TCb1")

WebUI.comment("withControl/TCb2 is running")

KeywordUtil.markFailedAndStop("Test Cases/withControl/TCb2 failed intentionally")