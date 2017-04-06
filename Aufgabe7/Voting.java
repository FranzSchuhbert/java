
import java.util.*;

public class Voting{
	public static void main (String [] args){
		int maxi, maxj, seatstotal, numberofparties;
		double maximum;
		numberofparties = 4;
		seatstotal = 10;
		maximum = 0;
		maxi = 0;
		maxj = 0;	
		double [][] votes = new double[numberofparties][seatstotal];
		String [] parties = new String[numberofparties];
		int [] seats = new int[numberofparties];
		parties[0] = "P1";
		parties[1] = "P2";
		parties[2] = "P3";
		parties[3] = "P4";
		votes[0][0] = 100;
		votes[1][0] = 50;
		votes[2][0] = 20;
		votes[3][0] = 5;
		for(int i = 0; i < numberofparties; i++){
			for(int j = 1; j < seatstotal; j++){
			votes[i][j] = votes[i][0]/(j+1);
			}
		}
		for(int n=0;n<seatstotal;n++){
			for(int i=0;i<numberofparties;i++){
				for(int j=0;j<seatstotal;j++){
					if(votes[i][j]>maximum){
						maximum = votes[i][j];
						maxi = i;
						maxj = j;
					}
				}
			}
		votes[maxi][maxj] = 0;
		seats[maxi] += 1;
		maximum = 0;
		}
		for(int n=0;n<numberofparties;n++){
		System.out.println("Party "+parties[n]+" has "+seats[n]+" seats.");
		}
	}
}
