import java.util.*;
import java.lang.*;

public class Fermat extends Factorization{
	boolean debug = true;
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
				if(y==1){ result.add(x); }
				else if(x==1){ result.add(y); }
				else{
					Factorization n,m;
					n = new Fermat(x-y);
					m = new Fermat(x+y);
					result.addAll(n.factorize());
					result.addAll(m.factorize());
				}
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
