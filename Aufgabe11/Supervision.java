public class Supervision{
	private static boolean gotResult = false;
	public static synchronized void setResult(){ gotResult = true; }
	public static synchronized boolean getResult(){ return gotResult; }
}
