import java.util.*;

public class Primzahlen{
	public static void main (String [] args){
		int n = Integer.parseInt(args[0]);
		Vector<Integer> prim = new Vector<Integer>();
		for(int i=2; i<n+1; i++){
			prim.add(i);
		}
		System.out.println("Initial vectorfield: "+prim+
		"\nSize of vectorfield: "+prim.size());
		for(int i=0; i<prim.size(); i++){
			for(int j=i+1; j<prim.size(); j++){
				if((prim.get(j) % prim.get(i)) == 0){
					prim.removeElementAt(j);
				}
			}
		System.out.println("Tested number="+prim.get(i)+"\nRemaining primes: "+prim);	
		}
		
	}
}
