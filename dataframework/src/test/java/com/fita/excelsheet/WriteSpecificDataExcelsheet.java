package com.fita.excelsheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteSpecificDataExcelsheet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");


		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Data");

		

		XSSFRow currentRow=sheet.createRow(2);
		XSSFCell cell=currentRow.createCell(2);

		cell.setCellValue("Welcome Fita");

		
		workbook.write(file);

		workbook.close();

		file.close();

		

		System.out.println("File is creataed.....");
	}

}
