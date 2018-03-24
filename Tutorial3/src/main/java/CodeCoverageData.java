import java.util.*;
import java.text.DecimalFormat;
import java.io.*;


public class CodeCoverageData
{

	int numberOfLines;
	int numberOfExecutedLines;
	String className;
	double codeCoveragePercentage;

	public CodeCoverageData(int lines, int eLines, String cname)
	{
		//System.out.println("Now in CodeCoverageData()");
		this.numberOfLines = lines;
		this.numberOfExecutedLines = eLines;
		className = cname;
	}

	public String getClassName()
	{
		return className;
	}

	public int getTotalNumberOfLines()
	{
		return numberOfLines;
	}

	public int getTotalNumberOfLinesExecuted()
	{
		return numberOfExecutedLines;
	}

	public double getCoveragePercentage()
	{
		if (numberOfLines == 0) {
			return 0;
		}
		//System.out.println("Entered getCoveragePercentage");
		//System.out.println(getTotalNumberOfLinesExecuted());
		//System.out.println(this.getTotalNumberOfLines());
		codeCoveragePercentage = ((double)numberOfExecutedLines)/numberOfLines * 100;
		//System.out.println(codeCoveragePercentage);
		return codeCoveragePercentage;
	}

	public void printResult()
	{
		System.out.println();
		System.out.println("===================================================================");
		System.out.println("\t\tCoverage for " + this.getClassName());
		System.out.println("===================================================================");
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("Number of lines in " + this.getClassName() + ": " + this.getTotalNumberOfLines());
		System.out.println("Number of lines executed in " + this.getClassName() + ": " + this.getTotalNumberOfLinesExecuted());
		System.out.println("Line Coverage Percentage for " + this.getClassName() + ": " + df.format(this.getCoveragePercentage()));
	}



}
