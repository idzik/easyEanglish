package en.verify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import en.words.WordModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class VerifyWords {
	
	private int re = 0;
	Map<String, WordModel> badAnswer ;
	FileInputStream fileInput = null;
	Player player = null;

	
	public String checkAnswer(Map<String, WordModel> mapWords){
		
		
		badAnswer = new HashMap<String, WordModel>();		
		Scanner sc = new Scanner(System.in);
		WordModel wordsModel = null;
		int nr = 0;
		
		for(String key : mapWords.keySet()){
			nr++;
			System.out.print(nr+" . "+key + " Podaj odpowiedź  ");
			String ans = sc.nextLine();
			wordsModel = mapWords.get(key);
			String goodAnswer = wordsModel.getEnglischWord();
			String mp3Patch = wordsModel.getMp3Patch();
			try {
								
				if(goodAnswer.equals(ans) != true){
					fileInput = new FileInputStream(mp3Patch);
					System.out.println("Prawidłowa odpowiedz to : " + goodAnswer);
					badAnswer.put(key, wordsModel);			
					player = new Player(fileInput);
					player.play();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		if(badAnswer != null && badAnswer.size()>0){
			re++;
			System.out.println("Udzieliłeś " + badAnswer.size() + " błędnych odpowiedzi. Popraw się --------");
			checkAnswer(badAnswer);
		}
		sc.close();
		
		return "koniec !!!! Powtarzałeś " + re + " razy";
	}
}
