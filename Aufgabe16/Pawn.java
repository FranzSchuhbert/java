class Pawn extends Figure{
	// Shadowing
	char ch () { if (f==MyConst.Color.white) return 'P'; return 'p'; }
	int[] check(int start, int end){
		// check if start and end field indexes are still on the board
		if((start<0) || (start>63) || (end<0) || (end>63) ){MyConst.Error(0);}
		if(MyConst.debug){System.out.println("Current figure is a pawn.");}
		if(this.f==MyConst.Color.white){
		        if(start-end==8){
		                int[] zuege = new int[2];
		                zuege[0] = 1;
		                if(MyConst.debug){System.out.println("Array size: "+zuege[0]);}
		                zuege[1] = end;
		                return zuege;
		        }
		        else if((this.ind.getInd()<56) && (this.ind.getInd()>47) && (start-end==16)){
		                int[] zuege = new int[3];
		                zuege[0] = 2;
		                if(MyConst.debug){System.out.println("Array size: "+zuege[0]);}
		                zuege[1] = end + 8;
		                zuege[2] = end;
		                return zuege;
		        }
		        else { return null; }
		}
		if ( this.f==MyConst.Color.white ){
		        if (start-end==-8){
		                int[] zuege = new int[2];
		                zuege[0] = 1;
		                if(MyConst.debug){System.out.println("Array size: "+zuege[0]);}
		                zuege[1] = end;
		                return zuege;
		        }
		        else if((this.ind.getInd()<16) && (this.ind.getInd()>7) && (start-end==-16)){
		                int[] zuege= new int[3];
		                zuege[0] = 2;
		                if(MyConst.debug){System.out.println("Array size: "+zuege[0]);}
		                zuege[1] = end - 8;
		                zuege[2] = end;
		                return zuege;
		        }
		        else { return null; }
		}
		else { return null; }
	}
	// ctor
	Pawn(int ind, MyConst.Color ff){super(ind, ff);}
}
