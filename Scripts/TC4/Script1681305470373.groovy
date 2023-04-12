import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import my.FlowControl

new FlowControl("TC4").assertDependentTestCasePassed("TC1")

WebUI.comment("TC4 is running")