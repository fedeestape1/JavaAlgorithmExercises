import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ValidPassportsFromInputTxt {
	public static void main(String[] args) {
		try {
			System.out.println(getValidPassportsNumber());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Integer getValidPassportsNumber() throws IOException {
		File file = new File("C:\\Users\\Federico\\eclipse-workspace\\HackerRankExercises\\input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		Set<String> allowedFields = new HashSet<String>(Arrays.asList(
				"byr",
				"iyr",
				"eyr",
				"hgt",
				"hcl",
				"ecl",
				"pid"
				));
		
		String line = br.readLine();
		int validPassports = 0;
		while (line != null) {
			HashMap<String, String> singlePassportFields = new HashMap<String, String>();
			while(line != null && !line.isEmpty()) {
				String[] words = line.split(" ");
				for(String word : words) {
					String[] keyValue = word.split(":");
					System.out.println(Arrays.asList(keyValue));
					singlePassportFields.put(keyValue[0], keyValue[1]);
				}
				line = br.readLine();
			}
			
			HashSet<String> passportKeys = new HashSet<String>(singlePassportFields.keySet());
			
			if(passportKeys.containsAll(allowedFields) && FieldsValidator.validate(singlePassportFields)) {
				validPassports++;
			}
			
			line = br.readLine();
		}
		br.close();
		return validPassports;
	}
}

abstract class FieldsValidator {
	
	private static HashMap<String, FieldsValidator> validators = new HashMap<String, FieldsValidator>();
	
	static {
		validators.put("byr", new BYRValidator());
		validators.put("iyr", new IYRValidator());
		validators.put("eyr", new EYRValidator());
		validators.put("hgt", new HGTValidator());
		validators.put("hcl", new HCLValidator());
		validators.put("ecl", new ECLValidator());
		validators.put("pid", new PIDValidator());
		validators.put("cid", new DefaultValidator());
	}
	
	public static boolean validate(HashMap<String, String> fields) {
		System.out.println("validating fields: " + fields);
		return fields.keySet().stream().allMatch(key -> validators.get(key).validate(fields.get(key)));
	}
	
	public abstract boolean validate(String value);
}

class BYRValidator extends FieldsValidator {

	@Override
	public boolean validate(String value) {
		Integer year = Integer.parseInt(value);
		
		return 1920 <= year && year <= 2002;
	}

}

class IYRValidator extends FieldsValidator {

	@Override
	public boolean validate(String value) {
		Integer year = Integer.parseInt(value);
		
		return 2010 <= year && year <= 2020;
	}

}
class EYRValidator extends FieldsValidator {

	@Override
	public boolean validate(String value) {
		Integer year = Integer.parseInt(value);
		
		return 2020 <= year && year <= 2030;
	}

}
class HGTValidator extends FieldsValidator {

	@Override
	public boolean validate(String value) {
		Integer height = Integer.parseInt(value.substring(0, value.length()-2));
		if(value.charAt(value.length()-1) == 'm') {
			return 150 <= height && height <= 193;
		}
		else {
			return 59 <= height && height <= 76;
		}
	}

}
class HCLValidator extends FieldsValidator {

	private static String ALLOWED_CHARACTERS= "0123456789abcdef";
	
	@Override
	public boolean validate(String value) {
		if(value.charAt(0) != '#'  || value.length() != 7)
			return false;
		for(Character c : value.substring(1, value.length()).toCharArray()) {
			if(!ALLOWED_CHARACTERS.contains(c.toString())) {
				System.out.println(c);
				return false;
			}
		}
		return true;
	}

}
class ECLValidator extends FieldsValidator {

	private static List<String> ALLOWED_EYE_COLOR = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"); 
	
	@Override
	public boolean validate(String value) {
		return ALLOWED_EYE_COLOR.contains(value);
	}

}
class PIDValidator extends FieldsValidator {

	@Override
	public boolean validate(String value) {
		try {
			Integer.parseInt(value);
			return value.length() == 9;
		} catch (Exception e){
			return false;
		}
	}

}

class DefaultValidator extends FieldsValidator{
	@Override
	public boolean validate(String value) {
		return true;
	}
}
