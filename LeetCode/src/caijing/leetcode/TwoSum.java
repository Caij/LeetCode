package caijing.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

1、其实是首先想到的是循环遍历时间复杂度为O(n(n-1)/2),空间复杂度为O(1);
*/

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 7, 11, 2, 15, 7};
		int target = 9;
//		twoSum_1(array, target);
		twoSum_2(array, target);
	}
	
	/**
	 * 循环遍历
	 * @param array
	 * @param taget
	 */
	public static void twoSum_1(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			for (int j = i+1; j < array.length; j++) {
				if (temp == target-array[j]) {
					System.out.println((i+1) + "  and  " + (j+1)); //加1是因为上面的index是第一个数输出的是1不是0
				}
			}
		}
	}
	
	/**
	 * 在LeetCode 官网还有这种解法 时间复杂度为O(n), 我不这样认为 ，其实map的get里面机制也是循环，
	 * 还有就是如果不止一组数的和为target， 就显示不全。
	 * @param array
	 * @param taget
	 */ 
	public static void twoSum_2(int[] array, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < array.length; i++) {
	        if (map.containsKey(target - array[i])) {
	        	System.out.println((i+1) + "  and  " +map.get(target - array[i]));
	        }
	        map.put(array[i], i + 1);
	    }
	}

}
