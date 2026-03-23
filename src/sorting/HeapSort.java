package sorting;

import java.util.Random;

interface MaxHeap {
	public void insert(int x);

	public int deleteMax();
}

class Heap implements MaxHeap {

	int[] arr;
	int maxSize;
	int n;

	// arr: 노드 배열
	// sz: 최대 노드 갯수를 정해주는 숫자
	// maxSize : 최대 노드 갯수
	// n : 현재 노드 갯수
	public Heap(int sz) {
		arr = new int[sz + 1];
		maxSize = sz;
		n = 0;
	}

	private void heapFull() {
		System.out.println("Heap Full");
	}

	private void heapEmpty() {
		System.out.println("Heap Empty");
	}

	public void insert(int k) {
		if (n == maxSize) {
			heapFull();
			return;
		}

		int i = ++n;

		while (i > 1 && arr[i / 2] < k) {
			arr[i] = arr[i / 2];
			i = i / 2;
		}
		arr[i] = k;
	}

	public int deleteMax() {
		if (n == 0) {
			heapEmpty();
			return Integer.MIN_VALUE;
		}
		int max = arr[1];
		int temp = arr[n];
		n--;

		int i = 1;
		int j;
		while (2 * i <= n) {
			if (2 * i + 1 <= n && arr[2 * i + 1] > arr[2 * i]) {
				j = 2 * i + 1;
			} else {
				j = 2 * i;
			}
			if (temp > arr[j]) {
				break;
			} else {
				arr[i] = arr[j];
				i = j; // 루트 인덱스를 자식 인덱스로 교체
			}
		}
		arr[i] = temp;
		return max;
	}

	public void display() {
		for (int i = 1; i <= n; i++) {
			System.out.println(arr[i]);
		}
	}
}

public class HeapSort {
	public static void main(String[] args) {

		Heap h = new Heap(10);

		Random random = new Random();

		System.out.println("== 1단계: 입력 ==");
		for (int i = 0; i < 10; i++) {
			int num = random.nextInt(100);
			h.insert(num);
			System.out.println(num);
		}
		System.out.println("== 2단계: 힙 상태 ==");
		h.display();

		System.out.println("== 3단계: 정렬 ==");
		for (int i = 0; i < 10; i++) {
			System.out.println(h.deleteMax());
		}

	}

}
