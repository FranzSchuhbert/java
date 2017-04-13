import java.util.*;

abstract public class Factorization extends Thread{
	int numb;
	static boolean debugall=true;
//	private static boolean gotResult;
////	Factorization(){ Supervision.gotResult = false; }
	abstract Vector<Integer> factorize();
	abstract public void run();
//	public static synchronized void setResult(){ Supervision.gotResult = true; }
//	public static synchronized boolean getResult(){ return Supervision.gotResult; }
}
