import java.util.*;

public class Testdivision extends Factorization{
		// Memberfield
	boolean debug = false;
	Vector<Integer> prim = new Vector<Integer>();
		// Membermethod
	private Vector<Integer> getPrimes(int n){
	        Vector<Integer> prim = new Vector<Integer>();
	        for(int i=2; i<n+1; i++){
	                prim.add(i);
	        }       
	        if(debug){System.out.println("Initial vectorfield: "+prim+"\nSize of vectorfield: "+prim.size());}
	        for(int i=0; i<prim.size(); i++){
	                for(int j=i+1; j<prim.size(); j++){
	                        if((prim.get(j) % prim.get(i)) == 0){
	                                prim.removeElementAt(j);
	                        }       
	                }       
	        }
	        return prim;
	}       
		// Interface Method
	public Vector<Integer> factorize(){
		Vector<Integer> out = new Vector<Integer>();
		int i = 0;
		while(numb!=1){
			if(numb%(prim.get(i))==0){
				numb /= prim.get(i);
				out.add(prim.get(i));
			}
			else{i++;}
		}		
		return out;
	}
	Testdivision( int i){
		this.numb = i;
		prim = getPrimes(i);
	}
	Testdivision(){this.numb=1;}
}
