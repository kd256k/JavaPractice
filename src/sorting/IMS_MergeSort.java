package sorting;

class Term {
	int value;

	Term(int value) {
		this.value = value;
	}
}

public class IMS_MergeSort {
	// 반복문을 사용한 합병정렬 코드
	// - 순열[a]의 끝
	// - 원소를 선택
	// - 원소를 비교
	// - 자리를 배치
	//
	// - 순열[b]의 끝
	// - 원소를 선택
	// - 원소를 비교
	// - 자리를 배치
	//
	// - 합병(a,b)
	// - a.length == b.length
	//

	public static Term[] iMergeSort(Term[] terms) {
		if (terms == null || terms.length <= 1) {
			return terms;
		}

		int n = terms.length;
		Term[] temp = new Term[n];

		// size = 1 //n =5
		for (int size = 1; size < n; size *= 2) {
			// left 0, n = 5

			for (int left = 0; left < n; left += 2 * size) {
				// 0, 0, 4 => 0
				int mid = Math.min(left + size - 1, n - 1);
				// 0, 4 => 0
				int right = Math.min(left + 2 * size - 1, n - 1);
				// terms, temp, 0, 0, 0
				merge(terms, temp, left, mid, right);
			}
		}
		return terms;
	}

	private static void merge(Term[] terms, Term[] temp, int left, int mid, int right) {
		int i = left; // 왼쪽 부분의 시작 인덱스
		int j = mid + 1; // 오른쪽 부분의 시작 인덱스
		int k = left;// 병합된 배열의 인덱스

		while (i <= mid && j <= right) {
			if (terms[i].value < terms[j].value) {
				temp[k] = terms[i];
				i++;
			} else {
				temp[k] = terms[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k++] = terms[i++];
		}

		while (j <= right) {
			temp[k++] = terms[j++];
		}

		for (int idx = left; idx <= right; idx++) {
			terms[idx] = temp[idx];
		}

	}

	public static void main(String[] args) {

		Term[] terms = { new Term(4), new Term(2), new Term(5), new Term(1), };

		IMS_MergeSort.iMergeSort(terms);

		for (Term t : terms) {
			System.out.println(t.value);
		}

	}

}
