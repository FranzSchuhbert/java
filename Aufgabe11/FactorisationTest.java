import java.util.*;

public class FactorisationTest{
	static boolean debug = false;
		// MAIN @@@@@
	public static void main (String [] args){
		int testnumber = 12;
		Vector<Integer> result1, result2;
		Factorization t1,t2;
		t1 = new Testdivision(12);
		result1 = t1.factorize();
		System.out.println(result1);
		t2 = new Fermat(12);
		result2 = t2.factorize();
		System.out.println(result2);

		
	}
}
