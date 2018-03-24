import java.lang.*;
import java.io.*;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import java.util.*;
import java.text.DecimalFormat;

public class TestListener extends RunListener
{
	@Override
	public void testRunStarted(Description description) throws Exception 
	{
		System.out.println("Tests started");
		
	}

	@Override
    public void testRunFinished(Result result) throws Exception 
    {
    	ArrayList<CodeCoverageData> list = CodeCoverageInformationContainer.getCodeCoverage();
    	ArrayList<MethodInformation> listMethods = CodeCoverageInformationContainer.getMethodCoverage();
    	
    	//System.out.println(listMethods.size());
		System.out.println("\n");
		System.out.println("===================================================================\n"
						+  "\t\tCODE COVERAGE REPORT\n"
						+  "\tAuthors: Amanda Pierce, Ineke van der Berg,\n"
						+  "\t  Steyn van Litsenborgh, Jako Groenewald\n"
						+  "===================================================================\n\n");

		for(int i = 0; i < list.size();i++)
		{
		//System.out.println("Entered test loop");
			list.get(i).printResult();

		}

		int methodCount = 0;

		for(int i = 0; i < listMethods.size();i++)
		{
		//System.out.println("Entered test loop");
			listMethods.get(i).printResult();
			if (listMethods.get(i).isExecuted()) {
				methodCount++;
			}
		}

		CodeCoverageInformationContainer.printResult();
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("Project Method Coverage Percentage is: " + df.format((100.0 * methodCount)/listMethods.size()));
		System.out.println("===================================================================\n");
    }
	
	@Override
	public void testStarted(Description description) throws java.lang.Exception
	{
		 //System.out.println(description.getClassName()+":"+description.getMethodName() + System.lineSeparator());
		
	}
} 
