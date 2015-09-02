package en.words;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Words {
	
	

	@SuppressWarnings("static-access")
	public Map<String, WordModel> loadWords(String path, Map<String, WordModel> wordsMap){
			
		Workbook workBook = null;
		WordModel wordModel = null;
		
		try {
			workBook = workBook.getWorkbook(new File(path));
			Sheet ark = workBook.getSheet(0);
							
			for (int row = 0; row<ark.getRows(); row++){
				wordModel = new WordModel(ark.getCell(1, row).getContents(), ark.getCell(3, row).getContents());
				
				wordsMap.put(ark.getCell(0, row).getContents(), wordModel);
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
