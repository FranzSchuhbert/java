class PlayField{
    private Field[] b = new Field[MyConst.getNumb()];
    private Field Officer(int ind, MyConst.Color f){
	    Field p;
	    if ((ind%7) == 0){ p = new Tower (ind, f);}
	    else if ( (ind%7 -1) % 5 == 0){ p = new Knight (ind, f);}
	    else if ((ind%7-2) % 3 == 0){ p = new Bishop (ind, f);}
	    else if (ind%7 == 3){ p = new Queen (ind, f);}
	    else if (ind%7 == 4){ p = new King (ind, f);}
	    else {System.out.println("Something went wrong"); p = new Figure(ind, f); MyConst.Error(1); }
	    return p;
	}
    public void createFigure ( int ind, char fig){
	switch(fig){
		case 'P':	b[ind] = new Pawn(ind, MyConst.Color.white); break;
		case 'p':	b[ind] = new Pawn(ind, MyConst.Color.black); break;
		case 'T':	b[ind] = new Tower(ind, MyConst.Color.white); break;
		case 't':	b[ind] = new Tower(ind, MyConst.Color.black); break;
		case 'N':	b[ind] = new Knight(ind, MyConst.Color.white); break;
		case 'n':	b[ind] = new Knight(ind, MyConst.Color.black); break;
		case 'B':	b[ind] = new Bishop(ind, MyConst.Color.white); break;
		case 'b':	b[ind] = new Bishop(ind, MyConst.Color.black); break;
		case 'Q':	b[ind] = new Queen(ind, MyConst.Color.white); break;
		case 'q':	b[ind] = new Queen(ind, MyConst.Color.black); break;
		case 'K':	b[ind] = new King(ind, MyConst.Color.white); break;
		case 'k':	b[ind] = new King(ind, MyConst.Color.black); break;
	}}
    public void clearFigure ( int ind){ b[ind] = new Field(ind); }
					// Nimmt Array von Fieldern die zwischen Start und Ziel liegen von jeweiligem Objekt auf
    public void Zug ( int start, int end){	// und prüft ob die Fielder mit Figuren gleicher/gegnerischer MyConst.Color belegt sind
		int[] felder = (b[start]).check(start, end);
		if(MyConst.debug){System.out.println("felder: "+felder+"\nstart-end; "+(start-end));}
    		if ( (felder == null) || (start-end==0) || (b[start].getColor()==MyConst.Color.neutral) ) {System.out.println("Invalid turn, nothing happens");}
    		else {
    		if(MyConst.debug){System.out.println("Size: "+felder[0]);}
    		if ( felder != null){
    		if(MyConst.debug){System.out.println("No null");}
    		int tester = 0;
    		int size = felder[0];
    		int x;
    		System.out.println("Size: "+size);
    		for ( int m = size-1; m > 0; m--){
    			x = felder[m];
    			if(MyConst.debug){System.out.println("Current testd field: "+x+" Current character: "+b[x].ch());}
    			if ( b[x].getColor() != MyConst.Color.neutral ){
    				tester = 1;
    			}
    		}
    		if ( b[felder[size]].getColor()==b[start].getColor() ) {if(MyConst.debug){System.out.println("Set tester to 1");}tester = 1; }
    		if (tester==0){
    		b[end] = b[start];
    		clearFigure (start);}
    		else{ System.out.println("Invalid turn, nothing happens");}}
    		else { MyConst.Error(4); }}
	}
	public void print(){
	   int i;
	    System.out.print("\n   ");
	    for (i = 0; i < MyConst.getSize(); i++){ System.out.print("  "+MyConst.spch (i));}
	    System.out.println();
	    for (i = 0; i < 3* MyConst.getSize()+4; i++){ System.out.print("-");}
	    for (i = 0; i < MyConst.getNumb(); i++)
	    {
	        if ((i % MyConst.getSize())==0)
	        {
	            System.out.println();
	            System.out.print(MyConst.getSize()-i/MyConst.getSize()+": ");
	        }
	        System.out.print("  "+((b[i]).ch ()));
	    }
	    System.out.println();
	    for (i = 0; i < 3*MyConst.getSize()+4; i++) System.out.print("-");
	    System.out.print("\n   ");
	    for (i = 0; i <MyConst.getSize(); i++){ System.out.print("  "+MyConst.spch (i));}
	    System.out.println("\n");
	}
	// ctor
    PlayField(){
	    int i;
	    for(i=0;i<MyConst.getNumb();i++)
	    {
	        if (i<8)
	        {
	            this.b[i] = Officer (i, MyConst.Color.black);
	        }
	        else if (i < 16)
	        {
	            this.b[i] = new Pawn (i, MyConst.Color.black);
	        }
	        else if (i < 48)
	        {
	            this.b[i] = new Field (i);
	        }
	        else if (i < 56)
	        {
	            this.b[i] = new Pawn (i, MyConst.Color.white);
	        }
	        else
	        {
	            this.b[i] = Officer (i, MyConst.Color.white);
	        }
	    }
	}
}
