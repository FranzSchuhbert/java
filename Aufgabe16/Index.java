class Index{
//	void emergencyStop (int i) const;
	private int i;
	private int FieldColor;
	// getter
	public int getInd(){return this.i;}
	public int getColor(){return this.FieldColor;}
	// Ctor
	Index( int idx ) { this.i=idx; this.FieldColor = ((int)(idx/(MyConst.getSize()))+(int)(idx%(MyConst.getSize()))) % 2; }
}
