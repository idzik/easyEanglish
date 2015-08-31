package en.words;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Words {
	
	private Map<String, String> wordsMap = new HashMap<String, String>();

	@SuppressWarnings("static-access")
	public Map<String, String> loadWords(String path){
			
		Workbook workBook = null;
		
		
		try {
			workBook = workBook.getWorkbook(new File(path));
			Sheet ark = workBook.getSheet(0);
							
			for (int row = 0; row<ark.getRows(); row++){
				
				wordsMap.put(ark.getCell(0, row).getContents(), ark.getCell(1, row).getContents());
			}
				
				
		
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wordsMap;
	}
}
