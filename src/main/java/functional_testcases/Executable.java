package functional_testcases;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;
import utility.Constant;

import java.util.List;
 
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class, TestListenerAdapter.class })

public class Executable {

	public static void main(String[] args)   {
		if (args.length == 2) {
			System.out.println(args[1]);
			System.setProperty("Device",args[1]);
			}	
	
		{
			// whatever code is needed for initialization goes here
			// TODO Au to-generated constructor stub-
			
			System.setProperty("atu.reporter.config",
					Constant.PATH_TESTDATA+"/ATUReporter_Selenium_testNG_5.5 BETA + ATU Recorder 2.1+javadoc+propfile/atu.properties");
			
			///Users/swathi/Desktop/Mobilize_Android_project/src/dependencies/ATUReporter_Selenium_testNG_5.5 BETA + ATU Recorder 2.1+javadoc+propfile/atu.properties
		}
		try {
			
			TestListenerAdapter tla = new TestListenerAdapter();
			// Create object of TestNG Class
			TestNG testng = new TestNG();
			testng.addListener(tla);
			// testng.run();
			List<String> suites = Lists.newArrayList();
			suites.add( Constant.PATH_TESTDATA+"/testNG.xml");// path
																						// to
																						// xml..
			// suites.add("/Users/shiva/Documents/Workspace/Mobilize/src/testNG2.xml");//path
			// to xml..
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}





























/*if (args.length == 1) {
Constant.PATH_TESTDATA = args[0];
}	

{
// whatever code is needed for initialization goes here
// TODO Au to-generated constructor stub-

System.setProperty("atu.reporter.config",
		Constant.PATH_TESTDATA+"/ATUReporter_Selenium_testNG_5.5 BETA + ATU Recorder 2.1+javadoc+propfile/atu.properties");
}
try {
TestListenerAdapter tla = new TestListenerAdapter();
// Create object of TestNG Class
TestNG testng = new TestNG();
testng.addListener(tla);
// tes  tng.run();
List<String> suites = Lists.newArrayList();
suites.add( Constant.PATH_TESTDATA+"/testNG.xml");// path
																			// to
																			// xml..
// suites.add("/Users/shiva/Documents/Workspace/Mobilize/src/testNG2.xml");//path
// to xml..
testng.setTestSuites(suites);
testng.run();
} catch (Exception e) {
e.printStackTrace();
}
*/




























// testng.setTestClasses(new Class[] { Parallel_Test.class });
// testng.setTestClasses(new Class[] { Login.class });

/*
 * XmlSuite suite = new XmlSuite(); suite.setName("Smoke Test");
 *                                                                                                         
 * XmlTest test = new XmlTest(suite); test.setName("Registration Test");
 * List<XmlClass> classes = new ArrayList<XmlClass>(); classes.add(new
 * XmlClass("testcase.Parallel_Test")); classes.add(new
 * XmlClass("testcase.Login")); test.setXmlClasses(classes) ;
 * 
 * List<XmlSuite> suites = new ArrayList<XmlSuite>(); suites.add(suite); TestNG
 * tng = new TestNG(); tng.setXmlSuites(suites); tng.run();
 */