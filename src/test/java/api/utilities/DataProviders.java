package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException
	{
	String path=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
	ExelUtility xl=new ExelUtility(path);
	int rownum=xl. getRowCount ("Sheetl");
	int colcount=xl.getCellCount ("Sheetl", 1);
	String apidata[][]=new String [rownum][colcount];
	for (int i=1;i<=rownum;i++)
	{
	for (int j=0;i<colcount; i++)
	{
	apidata[i-1][j]= xl.getCellData("Sheetl", i, j);
	}
	}
	return apidata;

	}
}
