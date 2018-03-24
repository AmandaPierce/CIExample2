import java.util.*;
import java.lang.*;


public class ValidFile
{
	ArrayList<String> notValidFiles = new ArrayList<String>(Arrays.asList("java", "org/junit", "org/apache/maven", "sun", "test", "tests", "junit", "tutorial1/tut1", "org/hamcrest", "codecoveragedata"));

	public boolean isValid(String cname)
	{
		for(int i = 0; i < notValidFiles.size(); i++)
		{
			if(cname.toLowerCase().contains(notValidFiles.get(i)))
			{
				return false;
			}
			
		}
		//System.out.println("Apparently valid:" + cname);
		return true;

	}

}