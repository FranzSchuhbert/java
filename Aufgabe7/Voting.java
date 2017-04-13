
import java.util.*;

public class Voting{
	private static boolean debug = false;
	private static int[] getSeats(String[] parties, int[] votes, int seatstotal){
		int maxi, maxj;
		double maximum;
		maximum = 0;
		maxi = 0;
		maxj = 0;	
		double [][] table = new double[parties.length][seatstotal];
		for(int i=0; i<parties.length;i++){
			table[i][0] = votes[i];
		}
		int [] seats = new int[parties.length];
		for(int i = 0; i < parties.length; i++){
			for(int j = 1; j < seatstotal; j++){
			table[i][j] = table[i][0]/(j+1);
			}
		}
		if(debug){for(int i=0;i<parties.length; i++){for(int j=0;j<parties.length;j++){
		System.out.print(table[i][j]+" ");}System.out.println();}}
		for(int n=0;n<seatstotal;n++){
			for(int i=0;i<parties.length;i++){
				for(int j=0;j<seatstotal;j++){
					if(table[i][j]>maximum){
						maximum = table[i][j];
						maxi = i;
						maxj = j;
					}
				}
			}
		table[maxi][maxj] = 0;
		seats[maxi] += 1;
		maximum = 0;
		}
		if(debug){for(int i=0;i<parties.length; i++){for(int j=0;j<parties.length;j++){
		System.out.print(table[i][j]+" ");}System.out.println();}}
		return seats;
	}
	public static void main (String [] args){
		int seatstotal = 10;
		int numberofparties = 4;
		String [] parties = new String[numberofparties];
		int [] votes = new int[parties.length];
		int [] seats;
		parties[0] = "RED";
		parties[1] = "BLUE";
		parties[2] = "YELLOW";
		parties[3] = "BLACK";
		votes[0] = 100;
		votes[1] = 50;
		votes[2] = 20;
		votes[3] = 5;
		seats = getSeats(parties, votes, seatstotal);
		for(int n=0;n<parties.length;n++){
		System.out.println("Party "+parties[n]+" has "+seats[n]+" seats.");
		}
	}
}
