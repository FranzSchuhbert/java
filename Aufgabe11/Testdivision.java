import java.util.*;

public class Testdivision extends Factorization{
	public void run(){
		Vector<Integer> result;
		Factorization t;
		t = new Testdivision(numb);
		result = t.factorize();
		System.out.println("Test "+result);
		}
		// Memberfield
	boolean debug = false;
		// Interface Method
	public Vector<Integer> factorize(){
		Vector<Integer> out = new Vector<Integer>();
		int i = 0;
		int j = 0;
		while((numb!=1) && (Supervision.getResult()==false)){
			int test = 0;
			if(i==0){test=2;}
			else{test=2*i+1;}
			if(numb%(test)==0){
				numb /= test;
				out.add(test);
				out.add(numb);
				Supervision.setResult();
				if(debugall){System.out.println("Testresult: "+Supervision.getResult());}
				System.out.println("Testdivision was faster");
				break;
			}
			else{i++;}
			j++;
		}	
		if(debugall){System.out.println("Test j= "+j);}
		return out;	
	}
	Testdivision( int i){
		this.numb = i;
	}
	Testdivision(){this.numb=1;}
}
