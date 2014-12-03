package caijing.leetcode;

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
		int taget = 9;
		twoSum_1(array, taget);
	}
	
	/**
	 * 循环遍历
	 * @param array
	 * @param taget
	 */
	public static void twoSum_1(int[] array, int taget) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			for (int j = i+1; j < array.length; j++) {
				if (temp == taget-array[j]) {
					System.out.println((i+1) + "  and  " + (j+1)); //加1是因为上面的index是第一个数输出的是1不是0
				}
			}
		}
	}
	
	public static void twoSum_2(int[] array, int taget) {
		
	}

}
