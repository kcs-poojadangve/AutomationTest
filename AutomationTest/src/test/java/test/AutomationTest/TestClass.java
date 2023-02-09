package test.AutomationTest;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestClass extends BaseTest{
	
	@Test
	public void startHomePage(Method method) throws Exception {
		startTest(method.getName(), "Scenario of booking the movie ticket");
		homePage.goToWebsite(sURL).searchBar("Surat").selectMovie().bookTicket().language().handleAlert().selectionDate().selectionMall()
		.clickAcceptButton().selectionSeat().selectProceed().getInfo().booking().payProceed().verifyBookingInfo();
		
	}

}
