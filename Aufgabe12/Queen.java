import java.lang.Math;

class Queen extends Officer{
	// Shadowing
    char ch () { if (f == MyConst.Color.white){ return 'Q';} else{ return 'q';} }
    int[] check(int start, int end){
	 if ( start < 0 || start > 63 || end < 0 || end > 63 ){MyConst.Error(0);}
	            System.out.println("Current figure is queen");
	                int length = Math.abs(start-end);
	                int test1 = length%7;
	                int test2 = length%9;
	                int test3 = length%8;
	                int test4 = end%8;
	                int test5 = start%8;
	                if ( test1==0 && test3!=0 ){
	                        int path = Math.abs(start-end)/7;
	                        int[] fields = new int[path+1];
	                        fields[0] = path;
	                        System.out.println("Arraysize: "+fields[0]);
	                        while ( path > 0){
	                                if ( start > end){
	                                        fields[path] = start - 7 * path;
	                                }
	                                else {
	                                        fields[path] = start + 7 * path;
	                                }
	                                path = path - 1;
	                        }
	                return fields; }
	                else if (test2==0){
	                        int path = Math.abs(start-end)/9;
	                        int[] fields = new int[path];
	                        fields[0] = path;
	                        	System.out.println("Arraysize: "+fields[0]);
		                        while ( path > 0){
		                                if ( start > end){
		                                        fields[path] = start - 9 * path;
		                                }
		                                else {
		                                        fields[path] = start + 9 * path;
		                                }
		                                path = path -1;
		                        }
		                return fields; }
			else if ( test3 == 0 ){
	                        int path = Math.abs(start-end)/8;
	                        int[] fields = new int[path+1];
	                        fields[0] = path;
	                        System.out.println("Arraysize: "+fields[0]);
	                        while ( path > 0){
	                                if ( start > end){
	                                        fields[path] = start - 8 * path;
	                                }
	                                else {
	                                        fields[path] = start + 8 * path;
	                                }
	                                path = path - 1;
	                        }
	                        return fields;
	                }
	                else if ( length < 8 && start-end>0 && test5 > length ){
	                        int[] fields = new int[length+1];
	                        fields[0] = length;
	                        System.out.println("Arraysize: "+fields[0]);
	                        while ( length > 0){
	                                fields[length] = start - length;
	                                length = length - 1;
	                        }
	                        return fields;
	                           }
	                else if ( length < 8 && start-end<0 && test4 > length ){
	                        int[] fields = new int[length+1];
	                        fields[0] = length;
	                        System.out.println("Arraysize: "+fields[0]);
	                        while ( length > 0){
	                                fields[length] = start + length;
	                                length = length - 1;
	                        }
	                        return fields;
	                        }
	                else {return null; }
	}

	// ctor
    Queen(int ind, MyConst.Color ff){super(ind, ff);}
}
