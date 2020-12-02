package dayTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

	public static void main(String[] sa) {
		String filePath = new File("").getAbsolutePath() + "\\Data\\day 2.txt";
		List<Rule> rules = new ArrayList<Rule>();
		List<String> passwords = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String text = br.readLine();
			String[] firstSplit = text.split(":");
			while (!text.equals(null)) {
				String[] ruleSplit = firstSplit[0].trim().split(" |\\-"); //split on space or hyphen
				rules.add(new Rule(Integer.parseInt(ruleSplit[0]), Integer.parseInt(ruleSplit[1]), ruleSplit[2].charAt(0)));
				passwords.add(firstSplit[1].trim());
				text = br.readLine();
				firstSplit = text.split(":");
			}
			br.close();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int count = 0;
		for (int i = 0; i < rules.size(); i++) {
			if (rules.get(i).isValid(passwords.get(i))) {
				count++;
			}
		}
		System.out.println(count);
	}

}
