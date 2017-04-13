import java.util.*;
import java.lang.*;

public class FactorisationTest{
	static boolean debug = false;
		// MAIN 
	public static void main (String [] args){
		int testnumber = Integer.parseInt(args[0]);
		Testdivision thread1 = new Testdivision(testnumber);
		thread1.start();
		Fermat thread2 = new Fermat(testnumber);
		thread2.start();
	}
}
