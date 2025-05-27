package com.comcast.ecommerce.genericfileutility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcelUtility(String sheetName, int rowName,int CellName) throws IOException {
    FileInputStream fis = new FileInputStream("./src/test/resources/erail.xlsx");
               Workbook wb =   WorkbookFactory.create(fis);
             String data  =  wb.getSheet(sheetName).getRow(rowName).getCell(CellName).getStringCellValue();    
             wb.close();
             return data;
}
public void setDataIntoExcel(String sheetname,int rownum, int cellnum, String value) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./src/test/resources/erail.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row row = sh.getRow(rownum);
	Cell cel = row.createCell(cellnum);
	cel.setCellValue(value);
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/erail.xlsx");
	wb.write(fos);
	
	wb.close();
}
}