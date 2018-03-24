import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class MethodInformation
{
	int lines;
	int executedlines;
	double coveragePercentage;
	String className;
	String methodName;

	public MethodInformation(String cname, String mname)
	{
		lines = 0;
		executedlines = 0;
		methodName = mname;
		className = cname;
	}

	public String getClassName()
	{
		return className;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public void addMethodLines(int l)
	{
		lines = l;
	}

	public void addMethodExecutedLines(int n)
	{
		executedlines = n;
	}

	public int getMethodLines()
	{
		return lines;
	}

	public int getExecutedMethodLines()
	{
		return executedlines;
	}

	public double getCoveragePercentage()
	{
		coveragePercentage = ((double)executedlines/lines) * 100;
		return coveragePercentage;
	}

	public boolean isExecuted()
	{
		if (executedlines > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void printResult()
	{
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\tCoverage for " + this.getMethodName() + "() in " + this.getClassName());
		System.out.println("-------------------------------------------------------------------");
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("Number of lines in " + this.getMethodName() + "(): " + this.getMethodLines());
		System.out.println("Number of lines executed in " + this.getMethodName() + "(): " + this.getExecutedMethodLines());
		System.out.println("Line Coverage Percentage for " + this.getMethodName() + "(): " + df.format(this.getCoveragePercentage()));
	}
}