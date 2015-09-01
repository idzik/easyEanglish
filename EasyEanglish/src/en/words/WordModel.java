package en.words;

public class WordModel {

	private String englischWord;
	private String mp3Patch;

	
	public WordModel(String englischWord) {
		this.englischWord = englischWord;
	}
	
	public WordModel(String englischWord, String mp3Patch) {
		this.englischWord = englischWord;
		this.mp3Patch = mp3Patch;
	}
	
	
	
	public String getEnglischWord() {
		return englischWord;
	}
	public void setEnglischWord(String englischWord) {
		this.englischWord = englischWord;
	}
	public String getMp3Patch() {
		return mp3Patch;
	}
	public void setMp3Patch(String mp3Patch) {
		this.mp3Patch = mp3Patch;
	}
	
	
}
