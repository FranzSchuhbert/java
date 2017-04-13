class King extends Officer{
	// Shadowing
    char ch () { if (f == MyConst.Color.white){ return 'K';}else{ return 'k'; }}
    int[] check(int start, int end){
    	    if ( start < 0 || start > 63 || end < 0 || end > 63 ){MyConst.Error(0);}
    	    if(MyConst.debug){System.out.println("Current figure is king");}
    	    int[] fields = new int[2];
    	    fields[0] = 1;
    	    if(MyConst.debug){System.out.println("Arraysize: "+fields[0]);}
    	    switch ( start - end ){
    	    case  9 : 
    	    case  8 :
    	    case  7 :
    	    case  1 :
    	    case -1 :
    	    case -7 :
    	    case -8 :
    	    case -9 : fields[1]=end; return fields;
    	    default : return null;
    	    }
	}
	// ctor
    King (int idx, MyConst.Color ff){super(idx, ff);}
}
