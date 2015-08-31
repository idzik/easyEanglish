package en.verify;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VerifyWords {
	
	private int re = 0;
	Map<String, String> badAnswer ;

	public String checkAnswer(Map<String, String> mapWords){
		re++;
		
		badAnswer = new HashMap<String, String>();		
		Scanner sc = new Scanner(System.in);
		
		for(String key : mapWords.keySet()){
			
			System.out.print(key + " Podaj odpowiedź  ");
			String ans = sc.nextLine();
			String goodAnswer = mapWords.get(key);
			if(goodAnswer.equals(ans) != true){	
				System.out.println("Prawidłowa odpowiedz to : " + goodAnswer);
				badAnswer.put(key, goodAnswer);				
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
