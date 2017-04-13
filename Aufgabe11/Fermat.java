import java.util.*;
import java.lang.*;

public class Fermat extends Factorization{
	public void run(){
                 Vector<Integer> result;
                 Factorization t;
                 t = new Fermat(numb);
                 result = t.factorize();
                 System.out.println("Fermat "+result);
                 }

	boolean debug = false;
	Vector<Integer> factorize(){
		Vector<Integer> result = new Vector<Integer>();
		int x,y,r,u,v;
		if(((Math.sqrt(numb))%1)==0){
			x = (int)Math.sqrt(numb);
		}
		else{   x = (int)(Math.sqrt(numb)+1);   }
		if(debug){System.out.println("x= "+x);}
		y = 0;
		r = 1; 
		int j = 0;
		while((r!=0) && (Supervision.getResult()==false)){
//			System.out.println("Fermatresult before: "+Supervision.getResult());
			r = x*x-y*y-numb;
			if(r==0){
				result.add(x-y);
				result.add(x+y);
			}
			else if(r>0){
					y = y+1;
					if(debug){System.out.print("y");}
			}
			else if(r<0){
					x = x+1;
					if(debug){System.out.print("x");}
			}
			if(debug){System.out.print("   "+r+"   ");}
			j++;
		}
		if(Supervision.getResult()==false){
			System.out.println("Fermatresult before: "+Supervision.getResult());
			Supervision.setResult();
			System.out.println("Fermatresult: "+Supervision.getResult());
			System.out.println("Fermat was faster");
		}
		if(debugall){System.out.println("Fermat j= "+j);}
		return result;
	}
	// ctor
	Fermat(){this.numb = 1;}
	Fermat(int i){this.numb = i;}
}
