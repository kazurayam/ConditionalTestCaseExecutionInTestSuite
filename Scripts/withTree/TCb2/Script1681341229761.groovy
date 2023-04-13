import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kazurayam.ks.TestCaseTreeTracer

TestCaseTreeTracer.verifyEdge("withTree/TCb1", "withTree/TCb2")

WebUI.comment("Test Cases/withTree/TCb2 is running")

KeywordUtil.markFailedAndStop("Test Cases/withTree/TCb2 failed intentionally")