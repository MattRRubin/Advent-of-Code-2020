package dayThree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DayThree {

	public static void main(String[] sa) {
		String filePath = new File("").getAbsolutePath() + "\\Data\\day 3.txt";
		Grid data = new Grid();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String text;
			while ((text = br.readLine()) != null) {
				data.addLine(text);
			}
			br.close();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(countTrees(data, 3, 1)); // part 1
		System.out.println(
				(long) countTrees(data, 1, 1) *
				(long) countTrees(data, 3, 1) *
				(long) countTrees(data, 5, 1) *
				(long) countTrees(data, 7, 1) *
				(long) countTrees(data, 1, 2)
		); // part 2
	}
	
	private static int countTrees(Grid grid, int delta_x, int delta_y) {
		int count = 0;
		int x = 0;
		int y = 0;
		while (y < grid.getNumRow()) {
			char c = grid.get(x % grid.getNumCol(), y);
			if (c == '#') {
				count++;
			}
			x += delta_x;
			y += delta_y;
		}
		return count;
	}

}
