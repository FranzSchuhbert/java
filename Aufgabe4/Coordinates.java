
import java.util.*;

public class Coordinates{
	private static double getDelta(double lam, double phi){
		return Math.acos(Math.cos(lam/2)*Math.cos(phi));
	}
	private static double getAlpha(double lam, double phi){
		double delta = getDelta(lam, phi);
		return Math.acos((Math.sin(phi))/(Math.sin(delta)));
	}
	private static double getX(double lam, double phi){
		double x;
		double delta;
		double alpha;
		delta = getDelta(lam, phi);
		alpha = getAlpha(lam, phi);
		x = (phi+(delta)*(Math.cos(alpha)))/2;
		x = Math.round(10000000*x)/10000000.0;
		return x;
	}
	private static double getY(double lam, double phi){
		double y, delta, alpha, phi0;
		phi0 = Math.toRadians(40);
		delta = getDelta(lam, phi);
		alpha = getAlpha(lam, phi);
		y = (lam*Math.cos(phi0)+2*delta*Math.sin(alpha))/2;
		y = Math.round(10000000*y)/10000000.0;
		return y;
	}	
		
	public static void main (String [] args){
		double [] lam, phi, x, y, delta, alpha;
		lam = new double[args.length/2];
		phi= new double[args.length/2];
		x = new double[args.length/2];
		y = new double[args.length/2];
		alpha = new double[args.length/2];
		delta = new double[args.length/2];
		System.out.println("\u03BB     \u03C6        x           y");
		// Computation of x and y from the input arguments and printing to the screen
		for(int i=0; i<(args.length/2); i++){
			lam[i] = Math.toRadians(Double.parseDouble(args[2*i]));
			phi[i] = Math.toRadians(Double.parseDouble(args[2*i+1]));
			x[i] = getX(lam[i], phi[i]);
			y[i] = getY(lam[i], phi[i]);
			System.out.println(args[2*i]+"    "+args[2*i+1]+"   "+x[i]+"   "+y[i]);	
		}
	}
}
