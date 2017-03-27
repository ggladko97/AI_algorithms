package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ggladko97 on 16.03.17.
 */
public class ExcelReader {
    public static HashMap<Integer, Fruit> readFromSpreadsheet(){


        HashMap<Integer,Fruit> fruits = new HashMap<Integer,Fruit>();
        try {
            FileInputStream file = new FileInputStream(new File("/home/ggladko97/Desktop/owoc.xlsx"));


//Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

//Iterate through each rows one by one
// Iterator<Row> rowIterator = sheet.iterator();
            int rowNumber = 0;
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {


                Row row = rit.next();
                String[] cells = new String[row.getPhysicalNumberOfCells()];

                int i = 0;
                for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
                    Cell cell = cit.next();


                    cells[i++] = cell.getStringCellValue();
                }
                Fruit fruit = new Fruit();
                if(cells.length>1) {
                    fruit.setColor(cells[0]);
                    fruit.setSize(cells[1]);
                    fruit.setShape(cells[2]);
                    fruit.setTaste(cells[3]);
                    fruit.setWeight(cells[4]);
                    fruit.setName(cells[5]);

                    rowNumber++;

                    fruits.put(rowNumber, fruit);
                }

//                System.out.println(Arrays.toString(cells));
//                System.out.println("");

            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruits;
    }
}
