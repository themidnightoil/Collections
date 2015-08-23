import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
	BufferedReader bFile;
	HashMap<String,WordCountElement> wordCountHashMap = new HashMap<String,WordCountElement>();
	
	private class WordCountElement{
		/** creates a Word Count Object that keeps track of word name and amount of times it appears
		    This object will be placed in a Hash map for easy retrieval.
		 **/
		String word;
		int count = 1;
		
		public WordCountElement(String word){
			this.word = word;
		}
		public String getWord(){
			return word;
		}
		public int getCount(){
			return count;
		}
		public void IncrementCountByOne(){
			count++;
		}
		public String toString(){
			  
			return word + " : " + count;
		}
		
	}//end word Count Object
	
	public WordCounter(String path) throws IOException{
	 FileReader file = new FileReader(path);
	 bFile = new BufferedReader(file);
	 countWords();
	 
	}
	
	private String[] sanatizeString(String line){
		// remove unwanted punctuations and spaces
		return (line.replaceAll("\\W", " ").toLowerCase()).split("\\s+");
	}
	private void countWords() throws IOException{
		String line;
		while((line = bFile.readLine())!=null){
			for(String word: sanatizeString(line)){
				// If the word reference doesn't exist create one with a wordCountelement as its value
				// The wordCountElement.count  is initialized to 1
				if(!wordCountHashMap.containsKey(word)){
					wordCountHashMap.put(word, new WordCountElement(word));
				}else{
					//if the word reference does exist add one to the word Element
					WordCountElement wordCount = wordCountHashMap.get(word);
					wordCount.IncrementCountByOne();
				}//end if		
			}//end for loops	
		}//end while loop	
	}//end countWord
	public void regularPrint(){
		for(Map.Entry<String, WordCountElement>wchm: wordCountHashMap.entrySet()){
			System.out.println(wchm.getValue());
		}
	}

	public void alphabeticalSort(){

	    ArrayList<WordCountElement> alphebeticallySortedList = new ArrayList<WordCountElement>(wordCountHashMap.values());
	    Collections.sort(alphebeticallySortedList, new Comparator<WordCountElement>(){

			@Override
			public int compare(WordCountElement wce1, WordCountElement wce2) {
				return wce1.getWord().compareTo(wce2.getWord());
			}
	    	
	    });
	    for(WordCountElement wce:alphebeticallySortedList){
	    	System.out.println(wce);
	    }
	}
	public void numericalSort(){
	    ArrayList<WordCountElement> numericallySortedList = new ArrayList<WordCountElement>(wordCountHashMap.values());
	    Collections.sort(numericallySortedList, new Comparator<WordCountElement>(){

			@Override
			public int compare(WordCountElement wce1, WordCountElement wce2) {
				return wce1.getCount()-wce2.getCount();
			}
	    	
	    });
	    
	    for(WordCountElement wce : numericallySortedList){
	    	System.out.println(wce);
	    }
		
	}//end numerical sort
}
