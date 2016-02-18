package caijing.leetcode;

public class MuSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = {1,4,7,3,8,9,2,6,5, 2, 1};
//		insertionSort(datas);
//		bInsertionSort(datas);
//		shellSort1(datas);
//		shellSort2(datas);
//		quickSort(datas, 0, datas.length - 1);
		heapSort(datas);
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i] + ",");
		}
	}
	
	/**
	 * 堆排序
	 * @param datas
	 */
	public static void heapSort(int[] datas) {
		for (int i = datas.length/2; i >= 0; i--) {
			createHeap(datas, i, datas.length - 1);
		}
		
		int temp;
		for(int j = datas.length - 1; j > 0; j --) {
			temp = datas[0];
			datas[0] = datas[j];
			datas[j] = temp;
			
			createHeap(datas, 0, j - 1);
		}
	}
	
	public static void createHeap(int[] datas, int i, int n) {
		int temp = datas[i];
		int j = i * 2;
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
	 * 快速排序
	 * @param datas
	 */
	public static void quickSort(int[] datas, int left, int right) {
		int i = left;
		int j = right;
		int temp = datas[i];
		while (i < j) {
			while (temp < datas[j] && i < j) {
				j --;
			}
			if (i < j) {
				datas[i] = datas[j];
				i ++;
			}
			
			while (temp > datas[i] && i < j) {
				i ++;
			}
			if (i < j) {
				datas[j] = datas[i];
				j --;
			}
			
			datas[i] = temp;
			
			if (left < i - 1) {
				quickSort(datas, left, i - 1);
			}
			
			if (i + 1 < right) {
				quickSort(datas, i + 1, right);
			}
			
		}
	}
	
	
	/**
	 * 希尔排序
	 * @param datas
	 */
	public static void shellSort1(int[] datas) {
		//将数据分为一次分为多组
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

}
