import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CodeCoverageInformationContainer
{
	static HashMap<String, HashMap<Integer, Boolean>> hashMap = new HashMap<String, HashMap<Integer, Boolean>>();
	static HashMap<Integer,HashMap<Integer, Boolean>> mi = new HashMap<Integer ,HashMap<Integer, Boolean>>();
	static ArrayList<CodeCoverageData> temp = new ArrayList<CodeCoverageData>();
	static ArrayList<MethodInformation> methodTemp = new ArrayList<MethodInformation>();
	static ArrayList<MethodInformation> methodFinal = new ArrayList<MethodInformation>();


	public static void insertLine(String cname, String mname, int line)
	{
		//System.out.println("test1");
		
		HashMap<Integer, Boolean> temp3 = null;

		if(hashMap.containsKey(cname))
		{
			temp3 = hashMap.get(cname);
			temp3.put(line, false);

		}
		else
		{
			temp3 = new HashMap<Integer, Boolean>();
			hashMap.put(cname, temp3);
			temp3.put(line, false);
		}

		int index = -1;

		for(int i = 0; i < methodTemp.size(); i++)
		{

			if(methodTemp.get(i).getMethodName().equals(mname) && methodTemp.get(i).getClassName().equals(cname))
			{
				index = i;
			}
		}

		if(index == -1)
		{
			MethodInformation methodInfo = new MethodInformation(cname, mname);
			HashMap<Integer, Boolean> newHash = new HashMap<Integer, Boolean>();
			methodTemp.add(methodInfo);
			mi.put((methodTemp.size() - 1), newHash);
			newHash.put(line, false);
		}
		else
		{
			HashMap<Integer, Boolean> newHash = mi.get(index);
			//System.out.println(newHash + " " + newHash.values());
			newHash.put(line, false);
			index = -1;
		}

		/*Iterator it = mi.entrySet().iterator();
		boolean found = false;

		while(it.hasNext() == true)
		{

			Map.Entry temp2 = (Map.Entry)it.next();
			//MethodInformation mn = methodTemp((MethodInformation)temp2.getKey());

			//System.out.println(mname);
			//System.out.println(cname);

			if(mn.getMethodName().equals(mname) && mn.getClassName().equals(cname))
			{

				HashMap<Integer, Boolean> newHash = mi.get(temp2.getKey());
				//System.out.println(newHash + " " + newHash.values());
				newHash.put(line, false);
				found = true;
			}
			
			
			it.remove();
		}

		if(found == false)
		{

			MethodInformation methodInfo = new MethodInformation(cname, mname);
			HashMap<Integer, Boolean> newHash = new HashMap<Integer, Boolean>();
			mi.put(methodInfo,newHash);
			newHash.put(line, false);
			System.out.println(mi.size());
			//System.out.println(mi.getMethodName());
			
		}
		else
		{
			found = false;
		}

		//System.out.println(mi.size());*/
	
	}

	public static void LineExecuted(String cname, String mname, Integer line)
	{
		hashMap.get(cname).put(line, true);

		int index = -1;

		for(int i = 0; i < methodTemp.size(); i++)
		{

			if(methodTemp.get(i).getMethodName().equals(mname) && methodTemp.get(i).getClassName().equals(cname))
			{
				index = i;
			}
		}

	
		HashMap<Integer, Boolean> newHash = mi.get(index);
		//System.out.println(newHash + " " + newHash.values());
		newHash.put(line, true);


		
		/*Iterator it = mi.entrySet().iterator();
		HashMap<Integer, Boolean> newHash = null;

		while(it.hasNext() == true)
		{

			Map.Entry temp2 = (Map.Entry)it.next();
			MethodInformation mn = ((MethodInformation)temp2.getKey());

			if(mn.getMethodName().equals(mname) && mn.getClassName().equals(cname))
			{
				mi.get(temp2.getKey()).put(line, true);
			}
			
			
			it.remove();
		}*/

	}


	public static CodeCoverageData getClassCodeCoverage(String cname)
	{
		//System.out.println("Nou in getClassCodeCoverage()");
		//System.out.println(cname);
		HashMap<Integer,Boolean> temp = hashMap.get(cname);

		int lines = temp.size();

		//System.out.println(lines);

		int counter = 0;

		for(Integer i: temp.keySet())
		{
			if(temp.get(i))
			{
				counter++;
			}
		}
		//System.out.println("lines " + lines);
		//System.out.println("Counter " + counter);
		CodeCoverageData ccd = new CodeCoverageData(lines, counter, cname);
		return ccd;
	}

	public static MethodInformation getMethodCodeCoverage(int index)
	{
	

		HashMap<Integer,Boolean> getValues = mi.get(index);

		int lines = getValues.size();
		methodTemp.get(index).addMethodLines(lines);

		int counter = 0;

		for(Integer i: getValues.keySet())
		{
			if(getValues.get(i))
			{
				counter++;
			}
		}

		methodTemp.get(index).addMethodExecutedLines(counter);
		
		return methodTemp.get(index);

	}

	public static ArrayList<MethodInformation> getMethodCoverage()
	{
		//System.out.println("Now in getMethodCoverage");
		//System.out.println(mi.size());
		Iterator it = mi.entrySet().iterator();

		while(it.hasNext())
		{

			Map.Entry temp2 = (Map.Entry)it.next();
			int tempMI = ((Integer)temp2.getKey());
			
			MethodInformation mmi = getMethodCodeCoverage(tempMI);
			methodFinal.add(mmi);
			
			it.remove();
		}

		
		return methodFinal;


	}

	public static ArrayList<CodeCoverageData> getCodeCoverage()
	{
		//System.out.println("Now in getProjectCodeCoverage");
		//System.out.println(hashMap.containsKey("Stack"));

		//System.out.println(hashMap.size());
		//System.out.println(hashMap.size());

		Iterator it = hashMap.entrySet().iterator();

		while(it.hasNext())
		{
			//System.out.println("Entered loop");
			Map.Entry temp2 = (Map.Entry)it.next();
			//System.out.println(temp2.getKey().toString());
			
			CodeCoverageData ccd = getClassCodeCoverage(temp2.getKey().toString());
			temp.add(ccd);
			it.remove();
		}
		//System.out.println(temp.get(0));
		return temp;


	}

	public static double getProjectCodeCoverage()
	{
		if (temp.size() == 0) {
			return 0;
		}
		double total = 0.0;

		for(int i = 0; i < temp.size(); i++)
		{
			total += temp.get(i).getCoveragePercentage();
		}

		return total/temp.size();
	}

	public static void printResult()
	{
		DecimalFormat df = new DecimalFormat("#0.00");

		System.out.println();
    	System.out.println("===================================================================");
		System.out.println("\t\tCoverage for Project");
		System.out.println("===================================================================\n");
    	System.out.println("Project Line Coverage Percentage is: " + df.format(getProjectCodeCoverage()));
	}


	


	
}