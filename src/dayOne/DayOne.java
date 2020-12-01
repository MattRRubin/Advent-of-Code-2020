package dayOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {

	public static void main(String[] sa) {
		String filePath = new File("").getAbsolutePath() + "\\Data\\day 1.txt";
		List<Integer> data = new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String text = br.readLine();
			while (!text.equals(null)) {
				data.add(Integer.parseInt(text));
				text = br.readLine();
			}
			br.close();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (!data.isEmpty()) {
			ArrayList<Integer> factors = DayOne.findAddends(data, 2020);
			if (!factors.isEmpty()) {
				int product = factors.get(0) * factors.get(1);
				System.out.println(factors.get(0) + " * " + factors.get(1) + " = " + product);
			} else {
				System.out.println("Addends not found.");
			}
			factors = DayOne.findThree(data, 2020);
			if (!factors.isEmpty()) {
				int product = factors.get(0) * factors.get(1) * factors.get(2);
				System.out.println(factors.get(0) + " * " + factors.get(1) + " * " + factors.get(2) + " = " + product);
			} else {
				System.out.println("Three addends not found.");
			}
		} else {
			System.out.println("Data not found");
		}
	}
	
	public static ArrayList<Integer> findAddends(List<Integer> data, int goal) {
		ArrayList<Integer> addends = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < data.size(); i++) {
			if (map.containsKey(goal - data.get(i))) { //if the paired number exists in the map, return the pair
				addends.add(data.get(i));
				addends.add(goal - data.get(i));
				return addends;
			} else { //else, add it to the map as a key
				map.put(data.get(i), i);
			}
		}
		return null;
	}
	
	public static ArrayList<Integer> findThree(List<Integer> data, int goal) {
		ArrayList<Integer> addends;
		for (int i = 0; i < data.size(); i++) {
			addends = DayOne.findAddends(data, goal - data.get(i));
			if (addends != null) {
				addends.add(data.get(i));
				return addends;
			}
		}
		return null;
	}

}
