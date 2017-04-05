
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
		long time;
		File log = new File("log.txt");
		File backup = new File("backup.txt");
		if (log.exists()) System.out.println("File log.txt already exists");
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
//			System.out.println("Kilometer total: "+kilometer);
		}
		catch ( Exception e){
		System.out.println("Reading file did not work.");
		System.out.println(e.toString());
		}
		Path path1 = Paths.get("log.txt");
		Path path2 = Paths.get("backup.tmp");
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
	}
}
