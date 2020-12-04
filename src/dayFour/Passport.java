package dayFour;

import java.util.HashMap;

public class Passport {
	HashMap<String, String> data;
	
	public Passport() {
		this.data = new HashMap<String, String>();
	}
	
	public void put(String key, String value) {
		this.data.put(key, value);
		return;
	}
	
	public String get(String key) {
		return this.data.get(key);
	}
	
	public boolean isOldValid() { //part 1
		return (
			this.data.containsKey("byr") && this.data.containsKey("iyr") && this.data.containsKey("eyr") &&
			this.data.containsKey("hgt") && this.data.containsKey("hcl") && this.data.containsKey("ecl") &&
			this.data.containsKey("pid")
		);
	}
	
	public boolean isValid() { //part 2
		return (
			this.validByr() && this.validIyr() && this.validEyr() && this.validHgt() &&
			this.validHcl() && this.validEcl() && this.validPid() && this.validCid()
		);
	}
	
	private boolean validByr() {
		if (this.data.containsKey("byr")) {
			try {
				int byr = Integer.parseInt(this.data.get("byr"));
				return (1920 <= byr && byr <= 2002);
			} catch (Exception ex) {
				return false;
			}
		}
		return false;
	}
	
	private boolean validIyr() {
		if (this.data.containsKey("iyr")) {
			try {
				int iyr = Integer.parseInt(this.data.get("iyr"));
				return (2010 <= iyr && iyr <= 2020);
			} catch (Exception ex) {
				return false;
			}
		}
		return false;
	}

	private boolean validEyr() {
		if (this.data.containsKey("eyr")) {
			try {
				int eyr = Integer.parseInt(this.data.get("eyr"));
				return (2020 <= eyr && eyr <= 2030);
			} catch (Exception ex) {
				return false;
			}
		}
		return false;
	}
	
	private boolean validHgt() {
		if (this.data.containsKey("hgt")) {
			String hgt = this.data.get("hgt");
			if (hgt.matches("\\d+cm")) {
				try {
					int n = Integer.parseInt(hgt.substring(0, hgt.indexOf("cm")));
					return (150 <= n && n <= 193);
				} catch (Exception ex) {
					return false;
				}
			} else if (hgt.matches("\\d+in")) {
				try {
					int n = Integer.parseInt(hgt.substring(0, hgt.indexOf("in")));
					return (150 <= n && n <= 193);
				} catch (Exception ex) {
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean validHcl() {
		if (this.data.containsKey("hcl")) {
			String hcl = this.data.get("hcl");
			if (hcl.length() == 7 && hcl.matches("#(\\d|[a-f])+")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validEcl() {
		if (this.data.containsKey("ecl")) {
			String ecl = this.data.get("ecl");
			return (ecl.matches("amb|blu|brn|gry|grn|hzl|oth"));
		}
		return false;
	}
	
	private boolean validPid() {
		if (this.data.containsKey("pid")) {
			String pid = this.data.get("pid");
			return (pid.length() == 9 && pid.matches("\\d+"));
		}
		return false;
	}
	
	private boolean validCid() {
		return true;
	}

}
