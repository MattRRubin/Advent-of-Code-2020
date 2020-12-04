package dayFour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayFour {

	public static void main(String[] sa) {
		String filePath = new File("").getAbsolutePath() + "\\Data\\day 4.txt";
		List<Passport> data = new ArrayList<Passport>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String text;
			Passport temp = new Passport();
			while ((text = br.readLine()) != null) {
				if (!text.trim().isEmpty()) { //if the line isn't empty, add to current passport
					String[] parts = text.split(" ");
					for (String s : parts) {
						String[] entries = s.split(":");
						temp.put(entries[0], entries[1]);
					}
				} else {
					data.add(temp);
					temp = new Passport();
				}
			}
			data.add(temp); //adds final passport to list
			br.close();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int count = 0;
		for (Passport p : data) {
			if (p.isValid()) {
				count++;
			}
		}
		System.out.println(count);
	}

}
