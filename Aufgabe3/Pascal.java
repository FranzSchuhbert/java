/**
 * This Program gives back a visually nice pyramid of Pascal numbers.
 * The Program needs one argument to specify the height of the Pyramid.
 */

import java.util.*;

public class Pascal{
	public static void main (String [] args){
		int n = Integer.parseInt(args[0]);
		int [][] numbers = new int[n][n];
		int power = 0;
		int test = 0;
		int highest = 0;
		String [] line = new String[n];
		String buff = new String();
		for(int i=0;i<n;i++){
			numbers[i][0]=1;
			numbers[i][i]=1;
			for(int j=1;j<i;j++){
				numbers[i][j]=numbers[i-1][j-1]+numbers[i-1][j];
			}
		}
		// Get the largest element
		for(int j=0;j<n;j++){
			if(numbers[n-1][j]>=highest){ highest = numbers[n-1][j]; }
		}
		System.out.println("The biggest number is " + highest);
		// See how many digits the largest number has
		while(test==0){
			if((highest - Math.pow(10,power)) >= 0){
				power = power + 1; 
			}
			else{
				test = 1;
			}
		}
		System.out.println("Longest number has "+power+" digits");
		// Buffer is filled with as many spacebars as the biggest number has digits
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
		// print the final result
		for(int i=0; i<n;i++){
			System.out.println(line[i]);
		}
	}
}
