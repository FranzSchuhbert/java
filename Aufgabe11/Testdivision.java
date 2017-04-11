import java.util.*;

public class Testdivision extends Factorization{
	public void run(){
		Vector<Integer> result;
		Factorization t;
		t = new Testdivision(numb);
		result = t.factorize();
		System.out.println(result);
		}
		// Memberfield
	boolean debug = false;
		// Interface Method
	public Vector<Integer> factorize(){
		Vector<Integer> out = new Vector<Integer>();
		int i = 0;
		while(numb!=1){
			int test = 0;
			if(i==0){test=2;}
			else{test=2*i+1;}
			if(numb%(test)==0){
				numb /= test;
				out.add(test);
				out.add(numb);
				break;
			}
			else{i++;}
		}	
		return out;	
	}
	Testdivision( int i){
		this.numb = i;
	}
	Testdivision(){this.numb=1;}
}
