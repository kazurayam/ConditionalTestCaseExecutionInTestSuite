import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kazurayam.ks.TestCaseTreeNode

new TestCaseTreeNode("Test Cases/withTree/TCb2").follows("Test Cases/withTree/TCb1")

WebUI.comment("Test Cases/withTree/TCb2 is running")

KeywordUtil.markFailedAndStop("Test Cases/withTree/TCb2 failed intentionally")