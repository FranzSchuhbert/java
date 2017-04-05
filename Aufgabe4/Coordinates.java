
import java.util.*;

public class Coordinates{
	public static void main (String [] args){
		double [] lam, phi, x, y, delta, alpha;
		double phi0 = Math.toRadians(40);
		lam = new double[args.length/2];
		phi= new double[args.length/2];
		x = new double[args.length/2];
		y = new double[args.length/2];
		alpha = new double[args.length/2];
		delta = new double[args.length/2];
		System.out.println("\u03BB     \u03C6        x           y");
		// Speichern der Daten in Arrays
		for(int i=0; i<(args.length/2); i++){
			lam[i] = Math.toRadians(Double.parseDouble(args[2*i]));
			phi[i] = Math.toRadians(Double.parseDouble(args[2*i+1]));

			delta[i] = Math.acos(Math.cos(lam[i]/2)
			*Math.cos(phi[i]));
			
			alpha[i] = Math.acos((Math.sin(phi[i]))
			/(Math.sin(delta[i])));
			
			x[i] = (phi[i]
			+(delta[i])*(Math.cos(alpha[i])))/2;
			
			x[i] = Math.round(10000000*x[i])/10000000.0;
			
			y[i] = (lam[i]*Math.cos(phi0)
			+2*delta[i]*Math.sin(alpha[i]))/2;

			y[i] = Math.round(10000000*y[i])/10000000.0;
		
			System.out.println(args[2*i]+"    "+args[2*i+1]+"   "+x[i]+"   "+y[i]);	
		}
	}
}
