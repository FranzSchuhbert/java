class Chesstest{
	public static void main(String[] args){
		if((args.length==1) && (args[0].compareTo("-d")==0)){ MyConst.setDebug();}
		PlayField b = new PlayField();
		b.print();
		b.clearFigure(11);
		b.print();
		b.createFigure(32, 't');
		b.print();
		b.Zug(3, 51);
		b.print();
		b.createFigure(11, 'p');
		b.print();
		b.Zug(51, 3);
		b.print();
		System.out.println("Press any key to quit.");
		System.console().readLine();
	}
}
