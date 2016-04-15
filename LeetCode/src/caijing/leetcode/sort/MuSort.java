package caijing.leetcode.sort;

import java.util.Stack;

public class MuSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = {1,4,7,3,8,9,2,6,5,2,1};
//		insertionSort(datas);
//		bInsertionSort(datas);
//		shellSort1(datas);
//		shellSort2(datas);
//		quickSort递归(datas, 0, datas.length - 1);
//		quickSort非递归(datas, 0, datas.length - 1);
		heapSort(datas);
//		bubblingSort(datas);
//		mergeSort递归(datas, 0, datas.length - 1);
//		mergeSort非递归(datas);
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i] + ",");
		}
	}
	
	/**
	 * 堆排序
	 * @param datas
	 */
	public static void heapSort(int[] datas) {
		for (int i = datas.length/2 - 1; i >= 0; i--) {
			createMaxHeap(datas, i, datas.length - 1);
		}
		
		int temp;
		for(int j = datas.length - 1; j > 0; j --) {
			temp = datas[0];
			datas[0] = datas[j];
			datas[j] = temp;
			
			createMaxHeap(datas, 0, j - 1);
		}
	}
	
	public static void createMaxHeap(int[] datas, int i,/**最后节点*/int n) {
		int temp = datas[i]; //当前节点
		int j = i * 2; //当前节点的左子节点
		while (j < n) {
			if (j < n && datas[j] < datas[j + 1]) {
				j ++;
			}
			
			if (temp < datas[j]) {
				datas[i] = datas[j];
				i = j;
				j = i * 2;
			}else {
				j = n;
			}
			
			datas[i] = temp;
		}
	}
	
	/**
	 * 快速排序递归
	 * @param datas
	 */
	public static void quickSort递归(int[] datas, int left, int right) {
		if (left < right) {
			int i = partition(datas, left, right);
			if (left < i - 1) {
				quickSort递归(datas, left, i - 1);
			}

			if (right > i + 1) {
				quickSort递归(datas, i + 1, right);
			}
		}
	}

	/**
	 * 快速排序非递归
	 * @param datas
	 */

	public static void quickSort非递归(int[] datas, int left, int right) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(left);
		stack.push(right);
		while (!stack.isEmpty()) {
			int r = stack.pop();
			int l = stack.pop();
			int i = partition(datas, l, r);
			if (l < i - 1) {
				stack.push(left);
				stack.push(i - 1);
			}

			if (r > i + 1) {
				stack.push( i + 1);
				stack.push(right);
			}
		}
	}

	private static int partition(int[] datas, int left, int right) {
		int i = left;
		int j = right;
		int temp = datas[i];
		while (i < j) {
			while (temp < datas[j] && i < j) {
				j--;
			}
			if (i < j) {
				datas[i] = datas[j];
				i++;
			}

			while (temp > datas[i] && i < j) {
				i++;
			}
			if (i < j) {
				datas[j] = datas[i];
				j--;
			}

			datas[i] = temp;
		}
		return i;
	}
	
	
	/**
	 * 希尔排序
	 * @param datas
	 */
	public static void shellSort1(int[] datas) {
		//将数据分为一次分为多组, i表示多少组
		for(int i = datas.length / 2; i > 0; i /= 2) {
			//对每个组进行排序
			for(int j = 0; j < i; j ++) {
				for (int k = j + i; k < datas.length; k += i) {
					int temp = datas[k];
					int l = k - i;
					while (l >= 0 && temp < datas[l]) {
						datas[l + i] = datas[l];
						l -= i;
					}
					
					datas[l + i] = temp;
				}
			}
		}
	}
	
	
	/**
	 * 希尔排序
	 * @param datas
	 */
	public static void shellSort2(int[] datas) {
		//将数据分为一次分为多组
		for(int i = datas.length / 2; i > 0; i /= 2) {
			//对每个组进行排序
			for(int j = i; j < datas.length; j ++) {
				int temp = datas[j];
				int k = j - i;
				while (k >= 0 && temp < datas[k]) {
					datas[k + i] = datas[k];
					k -= i;
				}
				
				datas[k + i] = temp;
			}
		}
	}

	/**
	 * 插入排序
	 * @param datas
	 */
	public static void insertionSort(int[] datas) {
		//1.循环遍历
		for(int i = 1; i < datas.length; i++ ){
			//取出当前数
			int data = datas[i];
			int j = i - 1;
			//与之前的有序数据比较
			while (j >= 0 && data < datas[j]) {
				datas[j + 1] = datas[j];
				j -- ;
			}
			//最后插入
			datas[j + 1] = data;
		}
	}
	
	/**
	 * 二分法排序
	 * @param datas
	 */
	public static void bInsertionSort(int[] datas){
		for (int i = 1; i < datas.length; i++) {
			int data = datas[i];
			int start = 0;
			int end = i - 1;
			while(start <= end) {
				int mid = (start + end)/2;
				if (data < datas[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
			for(int j = i; j > end; j --) {
				datas[j] = datas[j - 1];
			}
			datas[end + 1] = data;
		}
	}

	/**
	 * 冒泡排序
	 * @param datas
	 */
	public static void bubblingSort(int[] datas) {
		for (int i = 0; i < datas.length; i ++) {
			for (int j = datas.length - 1; j > i; j --) {
				if (datas[j] < datas[j - 1]) {
					int temp = datas[j - 1];
					datas[j - 1] = datas[j];
					datas[j] = temp;
				}
			}
		}
	}

	/**
	 * 归并排序递归
	 * @param datas
	 */
	public static void mergeSort递归(int[] datas, int left, int right) {
		if (left < right){
			int mid = (left + right) / 2;
			mergeSort递归(datas, left, mid);    //左边有序
			mergeSort递归(datas, mid + 1, right); //右边有序
			mergeData(datas, left, mid, right); //再将二个有序数列合并
		}
	}

	/**
	 * 归并排序非递归
	 * @param datas
	 */
	public static void mergeSort非递归(int[] datas) {
		int gap = 1;
		int i = 0;
		while (gap < datas.length) {
			// 归并gap长度的两个相邻子表
			for (i = 0; i + 2 * gap < datas.length; i = i + 2 * gap) {
				mergeData(datas, i, i + gap - 1, i + 2 * gap - 1);
			}

			// 余下两个子表，后者长度小于gap
			if (i + gap - 1 < datas.length) {
				mergeData(datas, i, i + gap - 1, datas.length - 1);
			}

			gap *= 2;
		}
	}

	private static void mergeData(int[] datas, int left, int mid, int right) {
		int i = left;
		int j =  mid + 1;
		int k = 0;
		int[] temps = new int[right - left + 1];

		while (i <= mid && j <= right) {
			if (datas[i] < datas[j]) {
				temps[k] = datas[i];
				i ++;
			}else {
				temps[k] = datas[j];
				j ++;
			}
			k ++;
		}

		while (i <= mid) {
			temps[k] = datas[i];
			k ++;
			i ++;
		}

		while (j <= right) {
			temps[k] = datas[j];
			k ++;
			j ++;
		}

		// 将合并序列复制到原始序列中
		for (k = 0, i = left; i <= right; i++, k++) {
			datas[i] = temps[k];
		}
	}

}
