import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import my.FlowControl

new FlowControl("TC2").assertDependentTestCasePassed("TC1")
	
WebUI.comment("TC2 is running")
 
KeywordUtil.markFailed("TC2 failed intentionally")