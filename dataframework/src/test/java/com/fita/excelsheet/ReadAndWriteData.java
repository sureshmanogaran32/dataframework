package com.fita.excelsheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadAndWriteData {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Load the Page
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		String title = driver.getTitle();
		System.out.println("Title of Page : "+title);
		
		FileInputStream file =new FileInputStream("C:\\Users\\Suresh Priya\\Downloads\\FormFilling.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Identify and print the number of row and column
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(0).getLastCellNum();
		
		System.out.println("number of rows:"+ totalRows);
		System.out.println("number of cells:"+ totalCells); 
		
		//identify row and move to cell and copy and pass the value   
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell1 = row.getCell(0);
			String principalAmount = cell1.toString();
		XSSFCell cell2 = row.getCell(1);
			String roiPercentage = cell2.toString();
		XSSFCell cell3 = row.getCell(2);
			String tenureMonth = cell3.toString();
		
		//close the pop-up
		
		WebElement noThanks = driver.findElement(By.id("wzrk-cancel"));
		noThanks.click();
		
		//Fill the form
		WebElement principal = driver.findElement(By.id("principal"));
		principal.sendKeys(principalAmount);
		
		WebElement roi = driver.findElement(By.id("interest"));
		roi.sendKeys(roiPercentage);
		
		WebElement period = driver.findElement(By.id("tenure"));
		period.sendKeys(tenureMonth);
		
		WebElement tenurePeriod = driver.findElement(By.id("tenurePeriod"));
		Select select = new Select(tenurePeriod);
		select.selectByValue("12");
		
		WebElement frequency = driver.findElement(By.id("frequency"));
		Select select1 = new Select(frequency);
		select1.selectByValue("0");
		

		
		//calculate the loan
		WebElement calculate = driver.findElement(By.xpath("//img[@src=\"https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif\"]"));
		calculate.click();
		
		//fetch result
		String result = driver.findElement(By.id("resp_matval")).getText();
		System.out.println("Maturity Value : "+result);
		
		FileOutputStream writeFile=new FileOutputStream("C:\\\\Users\\\\Suresh Priya\\\\Downloads\\\\FormFilling.xlsx");

			row.createCell(3).setCellValue(result);
			workbook.write(writeFile);
			
		workbook.close();
		file.close();
		System.out.println("File is updated.....");
		
	}

}
