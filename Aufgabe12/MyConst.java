class MyConst{
	private static int size = 8;
	private static int numb = size * size;
	public static boolean debug = true;
	public static char spch (int i) { return (char) (i % size + 'a');}
	public static enum Color{ white, black, neutral};
	public static void Error(int i){System.out.println("Error Nr. "+i+"\nProgram will terminate now"); System.exit(i);}
	// getter
	static int getSize(){return size;}
	static int getNumb(){return numb;}
}
