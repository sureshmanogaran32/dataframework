package com.fita.excelsheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginOrangeHR {


		public static void main(String[] args) throws IOException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
			FileInputStream file =new FileInputStream("C:\\Users\\Suresh Priya\\Downloads\\Password.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Passwords Sheet");
			/*
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			System.out.println("Row Count: "+firstRowNum +" and "+lastRowNum);
			
			int firstCellNum = sheet.getRow(0).getFirstCellNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			
			System.out.println("Cell Count: "+firstCellNum +" and "+lastCellNum);
			
			for(int i = firstRowNum; i<lastRowNum; i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=firstCellNum; j<lastCellNum; j++) {
					String uname = sheet.getRow(i).getCell(j).toString();
					String pswd = sheet.getRow(i).getCell(j).toString();
					
					//String string = cell.toString();
				//	System.out.println(cell);
				}
			}
			
			*/
			
			
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(1);
			String uname = cell.toString();
			XSSFCell cell1 = row.getCell(1);
			String pswd = cell1.toString();
			
			System.out.println("Row :"+row +","+ "Column: "+cell);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			WebElement userName = driver.findElement(By.name("username"));
			userName.sendKeys(uname);
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys(pswd);
			WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton.click();
			
			workbook.close();
			file.close();	
		}
	}
