package en.App;

import java.awt.FileDialog;
import java.util.Map;

import javax.swing.JFrame;

import en.verify.VerifyWords;
import en.words.WordModel;
import en.words.Words;


public class AppService {
	
	Words words = new Words();
	JFrame a = null;
	VerifyWords verWords = new VerifyWords();
	
	public void startApp(){
		
		String path = selectFile();
		Map<String, WordModel> startMap = words.loadWords(path);
		String end =verWords.checkAnswer(startMap);
		System.out.println(end);
	}
		

	public void parentWindow(){
	     a = new JFrame ("Okno macierzyste");
	     a.setBounds(20,20,400,500);
	     a.setVisible(true);
	     a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     
	     

	}
	
	public String selectFile(){
	     FileDialog fd =new FileDialog(a,"Wczytaj dane z Exela",FileDialog.LOAD);
	   // Ewentualnie: FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
	     fd.setVisible(true);
	     String katalog=fd.getDirectory();
	     String plik=fd.getFile();

	     return katalog + plik ;
	}

}
