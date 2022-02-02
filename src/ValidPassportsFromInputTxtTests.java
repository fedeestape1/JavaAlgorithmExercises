import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ValidPassportsFromInputTxtTests {
	public static void main(String[] args) {
		assert new BYRValidator().validate("1925");
		assert new IYRValidator().validate("2015");
		assert new EYRValidator().validate("2025");
		assert new HGTValidator().validate("165cm");
		assert new HCLValidator().validate("#123abc");
		assert new ECLValidator().validate("amb");
		assert new PIDValidator().validate("000056789");
		
		System.out.println("all good");
	}
}