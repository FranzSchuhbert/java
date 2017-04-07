import java.io.*;
import java.util.*;

public class ABC{
	static boolean debug = false;
	private static Vector<String> addFileToStringV(File text) {
		Vector<String> words = new Vector<String>();
		try{
			BufferedReader fb = new BufferedReader(new FileReader(text));
			String s = new String();
			while((s=fb.readLine())!= null){
				if(!s.isEmpty()){
					StringTokenizer st = new StringTokenizer(s,"\t\r\n .,!?:;");
					while(st.hasMoreElements()){
						words.add(st.nextToken());
					}
				}
			}
		}
		catch( Exception e){
			System.out.println(e.toString());
		}
	return words;
	}
	private static Vector<String> reduceAndCount( Vector<String> input, Vector<Integer> wordcount){
		Vector<String> words = (Vector)input.clone();
		for(int i=0; i<words.size();i++){
			wordcount.add(1);
			for(int j=i+1;j<words.size();){
				if((words.get(i)).compareTo(words.get(j)) ==0   ){
					words.remove(j);
					wordcount.set(i,wordcount.get(i)+1);
					if (debug) {System.out.print(" "+i+"/"+j);}			// DEBUG
				}
				else{j++;}
			}
		}
	return words;
	}
	private static Vector<String> bubbleSort(Vector<String> input, Vector<Integer> wordcount){
		Vector<String> words = (Vector)input.clone();
		boolean domore=true;
		String strpuffer = new String();
		int numpuffer=0;
		while(domore){
			domore=false;
			for(int i=0; i<words.size()-1;i++){
				if(((words.get(i)).compareTo(words.get(i+1))>0)){
					strpuffer = words.get(i);
					words.setElementAt(words.get(i+1),i);
					words.setElementAt(strpuffer,i+1);
					numpuffer=wordcount.get(i);
					wordcount.setElementAt(wordcount.get(i+1),i);
					wordcount.setElementAt(numpuffer,i+1);
					domore=true;
				}
			}
		}
	return words;
	}
	private static Vector<String> splitWordsToChars(Vector<String> words){
		Vector<String> letters = new Vector<String>();
		String test = new String();
		for(int i=0; i<words.size();i++){
			test = words.get(i).replaceAll("", " ");
			StringTokenizer st = new StringTokenizer(test);
                                         while(st.hasMoreElements()){
                                                letters.add(st.nextToken());
                                         }
		}
	return letters;
	}
					

		// MAIN @@@@@
	public static void main (String [] args){
		File text = new File("test.txt");
		Vector<String> words;
		Vector<String> letters;
		Vector<String> sortedWords;
		Vector<String> reducedWords;
		Vector<Integer> wordcount = new Vector<Integer>();
		Vector<Integer> lettercount = new Vector<Integer>();

		words = addFileToStringV (text);
		reducedWords = reduceAndCount( words, wordcount);	
		sortedWords = bubbleSort(reducedWords, wordcount);	

		if (debug) {System.out.println (""+words);}						// DEBUG
		if (debug) {System.out.println (""+words);System.out.println (""+wordcount);}		// DEBUG

		letters = splitWordsToChars(words);
		letters = reduceAndCount(letters, lettercount);
		letters = bubbleSort(letters, lettercount);

		for(int i=0; i<letters.size(); i++){
			System.out.println(letters.get(i)+" "+lettercount.get(i));
		}
		System.out.println("\n\n");
		for(int i=0; i<sortedWords.size(); i++){
			System.out.println(sortedWords.get(i)+" "+wordcount.get(i));
		}
	}
}
