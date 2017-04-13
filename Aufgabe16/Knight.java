class Knight extends Officer{
    char ch () { if (f == MyConst.Color.white) return 'N'; return 'n'; }
    int[] check(int start, int end){
	 if ( start < 0 || start > 63 || end < 0 || end > 63 ){MyConst.Error(0);}
	            if(MyConst.debug){System.out.println("Current figure if knight");}
	            int[] fields = new int[2];
	            fields[0] = 1;
	            System.out.println("Array size: "+fields[0]);
	            switch ( start - end ){
	            case -17:   if ( (int)start%8 == 0 ) {MyConst.Error(1);} fields[1]=end;return fields;  
	            case -15:   if ( (int)start%8-7 == 0) {MyConst.Error(2);} fields[1]=end;return fields;  
	            case -10:   if ( ((int)start%8-1 == 0) || ((int)start%8 == 0 )) {MyConst.Error(3);} fields[1]=end;return fields;  
	            case -6:    if ( (int)start%8-7 == 0) {MyConst.Error(5);} fields[1]=end;return fields;  
	            case 6:     if ( (int)start%8-6 == 0) {MyConst.Error(6);} fields[1]=end;return fields;  
	            case 10:    if ( ((int)start%8-7 == 0) || ((int)start%8-6 == 0)){MyConst.Error(7);} fields[1]=end;return fields;  
	            case 15:    if ( (int)start%8-1 == 0 ) {MyConst.Error(9);} fields[1]=end;return fields;  
	            case 17:    if ( (int)start%8-7 == 0 ) {MyConst.Error(10);} fields[1]=end; return fields;  
	            default: return null;  
	            }
	}

	// ctor
    Knight(int idx, MyConst.Color ff){super(idx, ff);}
}
