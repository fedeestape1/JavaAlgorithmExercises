import java.util.Arrays;
import java.util.HashSet;

/*
 * array de intervalos:
Have the function OverlappingRanges(arr) take the array of numbers stored in arr which will contain 5 positive integers, the first two representing a
range of numbers (a to b), the next 2 also representing another range of integers (c to d), and a final 5th element (x) which will also be a positive
integer, and return the string true if both sets of ranges overlap by at least x numbers. For example: if arr is [4, 10, 2, 6, 3] then your program
should return the string true. The first range of numbers are 4, 5, 6, 7, 8, 9, 10 and the second range of numbers are 2, 3, 4, 5, 6. The last
element in the array is 3, and there are 3 numbers that overlap between both ranges: 4, 5, and 6. If both ranges do not overlap by at least x
numbers, then your program should return the string false.
 */

public class ArraysIntervals {
	
	public static String ArrayChallenge(int[] arr) {
		int[][] intervals = { {arr[0],arr[1]}, {arr[2],arr[3]} };
		Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
		
		if(intervals[1][0] > intervals[0][1]) {
			return "false";
		} else {
			if(intervals[1][1] > intervals[0][1]) {
				return "" + ((intervals[0][1] - intervals[1][0] + 1) >= arr[4]);
			} else {
				return "" + ((intervals[1][1] - intervals[1][0] + 1) >= arr[4]);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,3,3,5,1}; //should return true
		int[] nums2 = {3,5,0,5,3}; //should return true
		int[] nums3 = {11,21,0,5,5}; //should return false
		int[] nums4 = {1,3,1,5,3}; //should return true
		int[] nums5 = {1,5,1,3,4}; //should return false
		System.out.println(ArrayChallenge(nums));
		System.out.println(ArrayChallenge(nums2));
		System.out.println(ArrayChallenge(nums3));
		System.out.println(ArrayChallenge(nums4));
		System.out.println(ArrayChallenge(nums5));
		System.out.println();
		System.out.println(ArrayChallenge2(nums));
		System.out.println(ArrayChallenge2(nums2));
		System.out.println(ArrayChallenge2(nums3));
		System.out.println(ArrayChallenge2(nums4));
		System.out.println(ArrayChallenge2(nums5));
	}
	
	
	
	
	//Solucion hecha por mí que sinceramente NO ME GUSTA PARA NADA... hay otra seguramente mucho mejor y muchisimo mas eficiente... como la de arriba ;)
	//pero bueno, esta funciona igual :shrugg
	public static String ArrayChallenge2(int[] arr) {
		HashSet<Integer> first = new HashSet<Integer>();
		for (int i = arr[0]; i <= arr[1]; i++) {
			first.add(i);
		}
		HashSet<Integer> second = new HashSet<Integer>();
		for (int i = arr[2]; i <= arr[3]; i++) {
			second.add(i);
		}

		first.retainAll(second);
		return "" + (first.size() >= arr[4]);
	}
}
