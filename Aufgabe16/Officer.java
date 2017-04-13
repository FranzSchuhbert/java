class Officer extends Figure{
	// Shadowing
	char ch () { return '#'; }
	int[] check(int start, int end){ return null;}
	// ctor
	Officer(int idx, MyConst.Color ff){super(idx, ff);}
}

