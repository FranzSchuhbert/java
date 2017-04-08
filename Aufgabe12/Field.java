class Field{
	protected Index ind;
	protected MyConst.Color f = MyConst.Color.neutral;
	// Overloading Functions
	char ch () { if (this.ind.getColor()==1) return '_'; return ' '; }
	int[] check( int start, int end) {return null;}
	// getters
	MyConst.Color getColor(){return this.f;}
	// ctor
	Field(int i){ind = new Index(i);}
}
