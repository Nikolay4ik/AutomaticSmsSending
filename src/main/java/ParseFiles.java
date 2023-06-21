import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ParseFiles {

  private static  HashMap<String, String> phoneNames = new HashMap<>();
    public static String parse(String name) {
        StringBuilder result = new StringBuilder();
        HSSFWorkbook wb = null;
        try (InputStream in = new FileInputStream(name)) {
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        result.append(cell.getStringCellValue() + ",");
                        break;
                    case NUMERIC:
                        result.append((long) cell.getNumericCellValue()+",");
                        break;
                }
            }
        }

        return result.toString();
    }

    public static HashMap<String, String> phoneAndName(String path) {
        String[] arrPhoneName = parse(path).split(",");
        ArrayList<String>phones=new ArrayList<>();
        ArrayList<String>names=new ArrayList<>();

        for (int i = 0; i < arrPhoneName.length; i++) {
            if (i%2==0){
                names.add(arrPhoneName[i]);
            }else {
                phones.add(arrPhoneName[i]);}

        }

        for (int i = 0; i<=1; i++) {
           phoneNames.put(phones.get(i),names.get(i));

        }
        return phoneNames;
    }

}
