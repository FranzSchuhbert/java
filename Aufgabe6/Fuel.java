
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fuel
{
	public static void main (String [] args) throws IOException{
		int kilometer, lastfuel, totalfuel;
		int kilometernew, lastfuelnew, totalfuelnew;
		long time;
		double averageconsumption;
		File log = new File("log.txt");
		File backup = new File("backup.txt");
		Scanner sc = new Scanner(System.in);
		kilometer = 0;
		totalfuel = 0;
		kilometernew = 0;

		if (log.exists()) System.out.println("File log.txt found");
		try{
			FileReader f = new FileReader(log);
			BufferedReader fb = new BufferedReader(f);
			String s = new String();
			String l;
			int i = 0;
			l = null;
			while((s=fb.readLine())!= null) l = s;
			StringTokenizer st = new StringTokenizer (l);
			kilometer = Integer.parseInt( st.nextToken());
			lastfuel = Integer.parseInt( st.nextToken());
			totalfuel = Integer.parseInt( st.nextToken());
		}
		catch ( Exception e){
		System.out.println("Reading file did not work.");
		System.out.println(e.toString());
		}
		Path path1 = Paths.get("log.txt");
		Path path2 = Paths.get("backup.tmp");
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Please put in the total kilometers:");
		while(true){
			try{
				kilometernew = sc.nextInt();
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input, please try again:");
				sc.next();
				continue;
			}	
		}
		while(kilometernew < kilometer){
			System.out.println("Wrong input, new kilometers are less than last kilometers");
			kilometernew = sc.nextInt();
		}
		System.out.println("Please put in the filled fuel:");
		while(true){
			try{
				lastfuelnew = sc.nextInt();
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input, please try again:");
				sc.next();
				continue;
			}
		}	
		time = System.currentTimeMillis();
		Date datenow = new Date(time);
		System.out.println("New data added at "+datenow);
		totalfuelnew = totalfuel + lastfuelnew;
		averageconsumption = ((double)totalfuelnew)/(100*(double)kilometernew);
		System.out.println("Average fuel consumption: "+Math.round(1000*averageconsumption)/1000.0+" liter per 100 kilometer");
		try{
			FileWriter f = new FileWriter(log,true);
			BufferedWriter fb = new BufferedWriter(f);
			PrintWriter fd = new PrintWriter(fb);
			fd.println(""+kilometernew+" "+lastfuelnew+" "+totalfuelnew+" "+time);
			fd.flush();
			fd.close();
		}
		catch ( Exception e){
		System.out.println("Writing to file did not work.");
		System.out.println(e.toString());
		}
	}
}
