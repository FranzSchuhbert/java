import java.net.URL;
import java.util.*;
import java.io.*;
	

public class CurrencyChange {
	public static void main(String[] args)throws Exception{
		boolean debug = false;
		Vector<String> table = new Vector<String>();
		InputStream input = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml").openStream();
		Scanner sc = new Scanner(input);
		String str;
		while( sc.hasNext() ){
			str = sc.nextLine();
			if(debug){System.out.println(str);}
			StringTokenizer st = new StringTokenizer(str,"/<>' =");
                                         while(st.hasMoreElements()){
                                                 table.add(st.nextToken());
                                         }
			if(debug){System.out.println(table);}
		}
		Vector<String> currencies = new Vector<String>();
		Vector<String> rate = new Vector<String>();
		for(int i=0;i<table.size();i++){
			if((table.get(i)).compareTo("currency")==0){
				currencies.add(table.get(i+1));}
			if((table.get(i)).compareTo("rate")==0){
				rate.add(table.get(i+1));}
		}
		if(debug){System.out.println(currencies+"\n"+rate);}
		System.out.println("Current values of foreign currencies in euros:");
		for(int i=0;i<currencies.size();i++){
			System.out.println(currencies.get(i)+"      "+rate.get(i));
		}
	}
}
