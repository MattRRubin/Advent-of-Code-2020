package dayTwo;

public class Rule {
	private int min;
	private int max;
	private char token;
	
	public Rule (int min, int max, char token) {
		this.setMin(min);
		this.setMax(max);
		this.setToken(token);
	}

	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
		return;
	}

	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
		return;
	}

	public char getToken() {
		return this.token;
	}

	public void setToken(char token) {
		this.token = token;
		return;
	}
	
	public boolean isOldValid(String input) { //used for part one of the prompt
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == this.token) {
				count++;
			}
		}
		return (this.min <= count && count <= this.max);
	}
	
	public boolean isValid(String input) { //used for part two of the prompt
		boolean first = input.charAt(this.min - 1) == this.token;
		boolean second;
		try {
			second = input.charAt(this.max - 1) == this.token;
		} catch (java.lang.StringIndexOutOfBoundsException ex) {
			second = false;
		}
		return (first ^ second);
	}

}
