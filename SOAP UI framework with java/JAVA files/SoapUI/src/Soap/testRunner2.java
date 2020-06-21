package Soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class testRunner2 {
	
	@Test
	public void SingleTest() throws XmlException, IOException, SoapUIException {
		
		WsdlProject project = new WsdlProject("C:\\Users\\Santhosh\\Documents\\Docs\\EmployeeAutomation-soapui-project.xml");
		//grab the testsuite in the project
		WsdlTestSuite testsuite = project.getTestSuiteByName("Testing");
		WsdlTestCase testcase = testsuite.getTestCaseByName("GetEmployee");
		TestRunner runner = testcase.run(new PropertiesMap(), false);
		Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
	}
	
	@Test
	public void SecondTest() throws XmlException, IOException, SoapUIException {
		WsdlProject project = new WsdlProject("C:\\Users\\Santhosh\\Documents\\Docs\\EmployeeAutomation-soapui-project.xml");
		//grab the testsuite in the project
		WsdlTestSuite testsuite = project.getTestSuiteByName("Testing");
		WsdlTestCase testcase = testsuite.getTestCaseByName("Automation Script");
		TestRunner runner = testcase.run(new PropertiesMap(), false);
		Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
	}
	
	

}
