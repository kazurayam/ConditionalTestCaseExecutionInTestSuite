import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kazurayam.ks.TestCaseTreeNode

new TestCaseTreeNode("Test Cases/withTree/TCb4").follows("Test Cases/withTree/TCb1")

WebUI.comment("Test Cases/withTree/TCb4 is running")