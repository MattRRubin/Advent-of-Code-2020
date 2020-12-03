package dayThree;

import java.util.ArrayList;

public class Grid {
	private ArrayList<ArrayList<Character>> tiles;
	private int numRow = 0;
	private int numCol = 0;
	
	public Grid() {
		this.tiles = new ArrayList<>();
	}
	
	public void addLine(String s) {
		this.tiles.add(new ArrayList<>());
		 for (char c : s.toCharArray()) {
		      this.tiles.get(this.tiles.size()-1).add(c);
		 }
		 this.setNumCol(s.length());
		 this.setNumRow(this.getNumRow() + 1);
	}

	public char get(int x, int y) {
		return this.tiles.get(y).get(x);
	}

	public int getNumRow() {
		return this.numRow;
	}

	public void setNumRow(int numRow) {
		this.numRow = numRow;
	}

	public int getNumCol() {
		return this.numCol;
	}

	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}
	
}
