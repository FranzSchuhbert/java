public class Taxes{
	static boolean debug = false;
	private static int getTarif(double income){
		int tarif;
		if(income<256304){
			if(income<54058){
				if(income<13770){
					if(income<8821){
						tarif = 1;
					}
					else{	tarif = 2;}
				}
				else{		tarif = 3;}
			}
			else{			tarif = 4;}
		}
		else{				tarif = 5;}		
		return tarif;
	}
	private static int getTaxes(double income){
		int tarif = getTarif(income);		
		double taxes=0.0;
		int x;
		double y,z;
		x = (int) income;
		y = (x - 8820)/10_000.0;
		z = (x -13769)/10_000.0;
		if(debug){System.out.println("x: "+x+"  y: "+y+"  z: "+z);};
		switch(tarif){
			case 1: taxes = 0; if(debug){System.out.println("Case1");};break;
			case 2: taxes = (1007.27 * y + 1400) * y; if(debug){System.out.println("Case2");};break;
			case 3: taxes = (223.76 * z + 2397) * z + 939.57;if(debug){System.out.println("Case3");};break;
			case 4: taxes = 0.42 * x -8475.44;if(debug){System.out.println("Case4");};break;
			case 5: taxes = 0.45 * x - 16164.53;if(debug){System.out.println("Case5");};break;
		}
		return (int)taxes;
	}
	public static void main (String [] args){
		double income,tarif;
		int taxes;
		try{
			income = Double.parseDouble(args[0]);
		}
		catch(Exception e){
			income = 0.0;
			System.out.println(e.toString());
		}
		tarif = getTarif(income);
		taxes = getTaxes(income);
		System.out.println("Income: "+income+"\nTarif: "+tarif+"\nTaxes: "+taxes);
	}
}
