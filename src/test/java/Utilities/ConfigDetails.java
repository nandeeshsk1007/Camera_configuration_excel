package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ConfigDetails {
	public String conf(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream filein = new FileInputStream("D:\\javanew\\Cam1\\src\\test\\java\\Utilities\\Data.xlsx");
		Workbook book = WorkbookFactory.create(filein);
		Cell c = book.getSheet(sheet).getRow(row).getCell(cell);
		return c.getStringCellValue();
	}
	public void conf1(String sheet, int row, int cell, String val) throws EncryptedDocumentException, IOException {
		FileInputStream filein = new FileInputStream("D:\\javanew\\Cam1\\src\\test\\java\\Utilities\\Data.xlsx");
		Workbook book = WorkbookFactory.create(filein);
		Cell c = book.getSheet(sheet).createRow(row).createCell(cell);
		c.setCellValue(val);
		FileOutputStream fileout = new FileOutputStream("D:\\javanew\\Cam1\\src\\test\\java\\Utilities\\Data.xlsx");
		book.write(fileout);
	}
}
