package en.verify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class VerifyWords {
	
	private int re = 0;
	Map<String, String> badAnswer ;
	FileInputStream fileInput = null;
	Player player = null;

	
	public String checkAnswer(Map<String, String> mapWords){
		re++;
		
		badAnswer = new HashMap<String, String>();		
		Scanner sc = new Scanner(System.in);
		
		for(String key : mapWords.keySet()){
			
			System.out.print(key + " Podaj odpowiedź  ");
			String ans = sc.nextLine();
			String goodAnswer = mapWords.get(key);
			try {
				fileInput = new FileInputStream("patient.mp3");
				
				if(goodAnswer.equals(ans) != true){	
					System.out.println("Prawidłowa odpowiedz to : " + goodAnswer);
					badAnswer.put(key, goodAnswer);			
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
			System.out.println("Udzieliłeś " + badAnswer.size() + " błędnych odpowiedzi. Popraw się");
			checkAnswer(badAnswer);
		}
		sc.close();
		
		return "koniec !!!! Powtarzałeś " + re + " razy";
	}
}
