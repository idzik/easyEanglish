package en.App;

import java.awt.FileDialog;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import en.verify.VerifyWords;
import en.words.WordModel;
import en.words.Words;


public class AppService {
	
	Words words = new Words();
	JFrame a = null;
	VerifyWords verWords = new VerifyWords();
	private Map<String, WordModel> wordsMap = new HashMap<String, WordModel>();
	Scanner sc = new Scanner(System.in);
	
	public void startApp(){
		
		String path = selectFile();
		Map<String, WordModel> startMap = words.loadWords(path, wordsMap );
		System.out.println("pierwsza mapa " + startMap.size());
		System.out.println("Czy dodać kolejną porcje słów ?");
		String decision = sc.next();
		while(decision.equals("t")){
			startMap = words.loadWords(selectFile(), startMap);
			System.out.println("Czy dodać kolejną porcje słów ?");
			decision = sc.next();
		}
		
		System.out.println("kolejna mapa " + startMap.size());
		
		String end = verWords.checkAnswer(startMap);
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
