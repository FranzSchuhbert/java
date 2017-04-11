import java.util.*;

abstract public class Factorization extends Thread{
	int numb;
	abstract Vector<Integer> factorize();
	abstract public void run();
}
