import java.lang.Math;

class Tower extends Officer{
	// Overwriting
    char ch(){if(f==MyConst.Color.white) return 'T'; return 't'; }
    int[] check(int start, int end){
	if((start < 0) || (start > 63) || (end < 0) || (end > 63) ){MyConst.Error(0);}
	            if(MyConst.debug){System.out.println("Current figure is tower"); }
	            int length = Math.abs(start-end);
	            int test2 = length%8;
	            int test3 = end%8;
	            int test4 = start%8;
	            if ( test2 == 0 ){
	                int path = (Math.abs(start-end))/8;
	                int[] fields = new int[path+1];
	                fields[0] = path;
	                if(MyConst.debug){System.out.println("Arraysize: "+fields[0]);}
	                while (path>0){
	                        if(start>end){
	                                fields[path] = start - 8 * path;
	                        }
	                        else {
	                                fields[path] = start + 8 * path;
	                        }
	                        path = path - 1;
	                }
	            return fields;
	            }
	            else if ( (length < 8) && (start-end>0) && (test4 > length) ){
	                   int[] fields = new int[length+1];
	                   fields[0] = length;
	                   if(MyConst.debug){System.out.println("Arraysize: "+fields[0]);}
	                   while (length>0){
	                           fields[length] = start - length;
	                           length = length - 1;
	                   }
	                   return fields;
	                   }
	            else if((length < 8) && (start-end<0) && (test3 > length) ){
	                   int[] fields = new int[length+1];
	                   fields[0] = length;
	                   if(MyConst.debug){System.out.println("Arraysize: "+fields[0]);}
	                   while (length>0){
	                           fields[length] = start + length;
	                           length = length - 1;
	                   }
	                   return fields;
	      }
	            else {return null;}
	}
	// ctor
    Tower(int ind, MyConst.Color ff){super(ind, ff);}
}
