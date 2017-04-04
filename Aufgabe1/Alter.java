/**
 * Aufruf mit Alter tt mm jjjjj
 */

import java.util.Date;
import java.util.Calendar;

public class Alter{
	public static void main (String [] args){
		long ct = System.currentTimeMillis();
		int d,m,y;
		long gt;
		long differenceInMillis, differenceInDays, differenceInSec;
		long factor = 1000L*60L*60L*24L;
		d = Integer.parseInt(args[0]);
		m = Integer.parseInt(args[1])-1;
		y = Integer.parseInt(args[2]);
		Calendar inputDate = Calendar.getInstance();
		inputDate.set(y,m,d,0,0,0);	
		gt = inputDate.getTimeInMillis();
		Date inputDate2 = new Date(gt);
		System.out.println("Eingegebenes Datum: "+inputDate2);
		Date currentDate = new Date(ct);
		System.out.println("Aktuelles Datum: "+currentDate);
		differenceInMillis = ct - gt;
		differenceInDays = differenceInMillis / factor;
		differenceInSec = differenceInMillis / 1000;
		System.out.println("Unterschied in Tagen: " +  differenceInDays+
		"\nUnterschied in Sekunden: "+ differenceInSec);
	}
}
