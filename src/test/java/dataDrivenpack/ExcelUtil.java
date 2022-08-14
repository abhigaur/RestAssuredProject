package dataDrivenpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String fileName = System.getProperty("user.dir") + "\\src\\test\\java\\dataDrivenpack\\TestData.xlsx";
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// its return data based on row and cloumn passing

	public static Object getCellValue(String sheetName, int rowNo, int cellNo/* column no. */) {

		Object data = null;

		try {

			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			workBook.close();

			if (cell.getCellType() == cell.getCellType().NUMERIC) {

				data = (int) cell.getNumericCellValue();

				return data;
			}

			else if (cell.getCellType() == cell.getCellType().STRING) {

				data = cell.getStringCellValue();

				return data;
			}

			else if (cell.getCellType() == cell.getCellType().BOOLEAN) {

				data = cell.getBooleanCellValue();

				return data;
			}

		}

		catch (Exception e)

		{
			return "";

		}

		return data;
	}

	public static int getRowCount(String sheetName) {

		try

		{

			inputStream = new FileInputStream(fileName);
			// create XSSFWorkBook Class object for excel file manipulation

			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);

			// get total no. of rows
			int ttlRows = excelSheet.getLastRowNum() + 1;

			workBook.close();

			return ttlRows;

		}

		catch (Exception e)

		{

			return 0;

		}

	}

	public static int getColCount(String sheetName) {

		try

		{

			FileInputStream inputStream = new FileInputStream(fileName);
			// create XSSFWorkBook Class object for excel file manipulation
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet = workBook.getSheet(sheetName);

			// get total no. of columns
			int ttlCells = excelSheet.getRow(0).getLastCellNum();

			workBook.close();
			return ttlCells;

		}

		catch (Exception e)

		{

			return 0;

		}

	}

	// Method to print complete excel in one go

	public static void readCompleteExcel(String sheetName) {
		
		
		try {
			inputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		excelSheet = workBook.getSheet(sheetName);
	
		

		int totalRow = excelSheet.getLastRowNum();

		for (int i = 0; i <= totalRow; i++) {
			XSSFRow row = excelSheet.getRow(i);

			short totalColumn = row.getLastCellNum();

			for (int j = 0; j < totalColumn; j++) {
				XSSFCell cell = row.getCell(j);

				if (cell.getCellType() == cell.getCellType().NUMERIC) {

					int data = (int) cell.getNumericCellValue();

					System.out.print(data + " ");
				}

				else if (cell.getCellType() == cell.getCellType().STRING) {

					String data = cell.getStringCellValue();

					System.out.print(data + " ");
				}

				else if (cell.getCellType() == cell.getCellType().BOOLEAN) {

					boolean data = cell.getBooleanCellValue();

					System.out.print(data + " ");
				}

			}

			System.out.println(" ");
		}
	}
	
	
	
	
	
	
	//Method to store complete excel in array list
	
	
	public static ArrayList<Object> readCompleteExcelArray(String sheetName) {
		
		
		try {
			inputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		excelSheet = workBook.getSheet(sheetName);
	

	int totalRow = excelSheet.getLastRowNum();
	ArrayList<Object> arrayList = new ArrayList<Object>();

	for (int i = 0; i <= totalRow; i++) {
		XSSFRow row = excelSheet.getRow(i);

		short totalColumn = row.getLastCellNum();

		for (int j = 0; j < totalColumn; j++) {
			XSSFCell cell = row.getCell(j);

			if (cell.getCellType() == cell.getCellType().NUMERIC) {

				int data =(int)cell.getNumericCellValue();

				//System.out.print(data+ " ");
				arrayList.add(data);
			}

			else if (cell.getCellType() == cell.getCellType().STRING) {

				String data = cell.getStringCellValue();
				arrayList.add(data);
				//System.out.print(data+ " ");
			}

			
			else if (cell.getCellType() == cell.getCellType().BOOLEAN) {

				boolean data = cell.getBooleanCellValue();
				arrayList.add(data);
				//System.out.print(data+ " ");
			}
			
		}
		
		//System.out.println(" ");
	}
	
	
	
	return arrayList;
	
	
	
}
	

}
