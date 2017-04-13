/**
 * This Program gives back a visually nice pyramid of Pascal numbers.
 * The Program needs one argument to specify the height of the Pyramid.
 */

import java.util.*;

public class Pascal{
		// Get the largest element
	private static int getHighest(int[][] numbers){
		int highest = 0;
		int n = numbers.length;
		for(int j=0;j<n;j++){
			if(numbers[n-1][j]>=highest){ highest = numbers[n-1][j]; }
		}
		System.out.println("The biggest number is " + highest);
		return highest;
	}
		// See how many digits a number has
	private static int getDigits(int highest){
		int test = 0;
		int power = 0;
		while(test==0){
			if((highest - Math.pow(10,power)) >= 0){
				power = power + 1; 
			}
			else{
				test = 1;
			}
		}
		return power;
	}
		// Format the String in a nice way for the output
	private static String[] formatString(int[][] numbers, int power){
		int n = numbers.length;
		String [] line = new String[n];
		String buff = new String();
		for(int m=0;m<power;m++){ buff=buff+" "; }
		for(int i=0;i<n;i++){
			// create empty line
			line[i] = " ";
			for(int m=0;m<n-i-1;m++){ line[i] = line[i] +buff; }
			int j=0;
			// check every number in the row if it if zero or the last one
			while((j<n)&&(numbers[i][j]!=0)){
				int test1=0;
				int power1=0;
				// check for the number of digits and fill empty space with " "
				while(test1==0){
					if((numbers[i][j] - Math.pow(10,power1)) >= 0){
						power1 = power1 + 1; 
						}
					else{
						test1 = 1;
					}
				}
					while((power-power1)>0){	
					line[i]  = line[i]  + " ";
					power1 = power1 + 1;
				}
				// add the number with " " which has exactly the size of buffer
				line[i]  = line[i]  + String.valueOf(numbers[i][j])+buff;
				j = j+1;
			}
		}
		return line;
	}
		// create Pascal numbers
	private static int[][] getNumbers(int n){
		int[][] numbers = new int[n][n];
		for(int i=0;i<n;i++){
			numbers[i][0]=1;
			numbers[i][i]=1;
			for(int j=1;j<i;j++){
				numbers[i][j]=numbers[i-1][j-1]+numbers[i-1][j];
			}
		}
		return numbers;
	}


	public static void main (String [] args){
		int n = Integer.parseInt(args[0]);
		int [][] numbers;
		int power;
		int highest;
		String[] line;
		numbers = getNumbers(n);
		highest = getHighest(numbers);
		power = getDigits(highest);
		System.out.println("Longest number has "+power+" digits");
		line = formatString( numbers, power );
		// print the final result
		for(int i=0; i<n;i++){
			System.out.println(line[i]);
		}
	}
}
