package com.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report2 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkRepoter);
		
		extentReports
		.createTest("Text based test")
		.log(Status.INFO,"info1")
		.log(Status.INFO,"<b>info2</b>")
		.log(Status.INFO,"<i>info3</i>")
		.log(Status.INFO,"<i><b>info4</i></b>");
		
	String xmlData = "<menu id=\"file\" value=\"File\">\r\n"
			+ "  <popup>\r\n"
			+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
			+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
			+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
			+ "  </popup>\r\n"
			+ "</menu>";
	extentReports
	.createTest("XML based Test")
	.info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
	
	String jsonData="{\"menu\": {\r\n"
			+ "  \"id\": \"file\",\r\n"
			+ "  \"value\": \"File\",\r\n"
			+ "  \"popup\": {\r\n"
			+ "    \"menuitem\": [\r\n"
			+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
			+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
			+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
			+ "    ]\r\n"
			+ "  }\r\n"
			+ "}}";
	extentReports
	.createTest("JSON based Test")
	.info(MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
	
	List<String> listData = new ArrayList<>();
	listData.add("Akheem");
	listData.add("Pasha");
	listData.add("Khan");
	
	extentReports
	.createTest("List based test")
	.info(MarkupHelper.createOrderedList(listData))
	.info(MarkupHelper.createUnorderedList(listData));
	
	
	Map<Integer,String> mapData = new HashMap<>();
	mapData.put(101,"Akheem");
	mapData.put(102,"Pasha");
	mapData.put(103,"Khan");
	extentReports
	.createTest("map based test")
	.info(MarkupHelper.createOrderedList(mapData))
	.info(MarkupHelper.createUnorderedList(mapData));
	
	Set<Integer> setData = mapData.keySet();
	extentReports
	.createTest("set based test")
	.info(MarkupHelper.createOrderedList(setData))
	.info(MarkupHelper.createUnorderedList(setData));
	
	extentReports
	.createTest("Highlight log test")
	.info("This is not highlightes a message")
	.info(MarkupHelper.createLabel("highlighted a message", ExtentColor.RED));
	
	try {
		int i = 5/0;
	    }
		catch(Exception e) {
			extentReports
			.createTest("exception Test-1")
			.info(e);
		}
	
	Throwable t = new RuntimeException("This is custom exception");
	extentReports
	.createTest("exception Test-2")
	.info(t);
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
