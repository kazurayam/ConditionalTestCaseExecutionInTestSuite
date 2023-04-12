import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import my.FlowControl

new FlowControl("TC3").assertDependentTestCasePassed("TC2")

WebUI.comment("TC3 is running")
WebUI.delay(20)
