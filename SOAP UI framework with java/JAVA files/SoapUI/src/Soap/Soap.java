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



public class Soap {
	
	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException {

	
		// TODO Auto-generated method stub
		

				// TODO Auto-generated method stub
				
				//grab the project
				WsdlProject project = new WsdlProject("C:\\Users\\Santhosh\\Documents\\Docs\\EmployeeAutomation-soapui-project.xml");
				//grab the testsuite in the project
				WsdlTestSuite testsuite = project.getTestSuiteByName("Testing");
				//grab the testcases present in the testsuite
				for(int i=0;i<testsuite.getTestCaseCount();i++)
				{
					WsdlTestCase testcase = testsuite.getTestCaseAt(i);
					//code to execute 
					TestRunner runner = testcase.run(new PropertiesMap(), false);
					Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));


					
				}
			}
		}


	


