import java.util.*;

public class FactorisationTest{
	static boolean debug = false;
		// Thread
/*
	public void run(){
		Vector<Integer> result;
		Factorization t;
		t = new Testdivision(12);
		result = t.factorize();
		System.out.println(result);
		}*/
		// MAIN @@@@@
	public static void main (String [] args){
		int testnumber = 12;
		Testdivision thread1 = new Testdivision(testnumber);
		thread1.start();
		Fermat thread2 = new Fermat(testnumber);
		thread2.start();
	}
}
