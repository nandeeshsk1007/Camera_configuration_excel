package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ConfigDetails {
	public String conf(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("D:\\javanew\\Cam1\\src\\test\\java\\Utilities\\Data.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Cell c = book.getSheet("Sheet1").getRow(row).getCell(cell);
		return c.getStringCellValue();
	}
}
