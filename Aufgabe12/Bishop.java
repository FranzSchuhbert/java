import java.lang.Math;

class Bishop extends Officer{
    char ch(){ if (f == MyConst.Color.white) return 'B'; return 'b'; }
    int[] check(int start, int end){
	   if ( start < 0 || start > 63 || end < 0 || end > 63 ){MyConst.Error(0);}
	            System.out.println("Current figure is bishop");
	                int test1 = Math.abs(start-end)%7;
	                int test2 = Math.abs(start-end)%9;
	                if ( test1==0 ){
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
	                else { return null; }
	}
	//ctor
    Bishop(int idx, MyConst.Color ff){super(idx, ff);}
}
