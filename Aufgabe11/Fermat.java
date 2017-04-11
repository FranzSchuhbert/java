import java.util.*;
import java.lang.*;

public class Fermat extends Factorization{
	public void run(){
                 Vector<Integer> result;
                 Factorization t;
                 t = new Fermat(numb);
                 result = t.factorize();
                 System.out.println(result);
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
		while(r!=0){
			r = x*x-y*y-numb;
			if(r==0){
				result.add(x-y);
				result.add(x+y);
				return result;
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
		}
		return result;
	}
	// ctor
	Fermat(){this.numb = 1;}
	Fermat(int i){this.numb = i;}
}
