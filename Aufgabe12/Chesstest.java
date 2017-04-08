class Chesstest{
	public static void main(String[] args){
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
	}
}
