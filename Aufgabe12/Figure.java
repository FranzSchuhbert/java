class Figure extends Field{
	// Shadowing
	char ch(){ return '?';}
	int[] check(int start, int end){return null;}
	// ctor
	Figure(int ind, MyConst.Color ff){super(ind);this.f = ff;}
}
