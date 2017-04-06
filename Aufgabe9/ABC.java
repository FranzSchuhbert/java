import java.io.*;
import java.util.*;

public class ABC{
	static boolean debug = false;
	public static void main (String [] args){
		File text = new File("test.txt");
		Vector<String> words = new Vector<String>(); 
		Vector<Integer> wordcount = new Vector<Integer>();
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
		if (debug) {System.out.println (""+words);}
		for(int i=0; i<words.size();i++){
			wordcount.add(1);
			for(int j=i+1;j<words.size();){
				if((words.get(i)).compareTo(words.get(j)) ==0   ){
					words.remove(j);
					wordcount.set(i,wordcount.get(i)+1);
					if (debug) {System.out.print(" "+i+"/"+j);}
				}
				else{j++;}
			}
		}
		if (debug) {
		System.out.println (""+words);
		System.out.println (""+wordcount);}
		for(int i=0; i<words.size(); i++){
			System.out.println(words.get(i)+" "+wordcount.get(i));
		}
	}
}
