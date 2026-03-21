package stack;

//int형 고정길이 스택
public class IntStack {
	private int[] stk; // 스택용 배열
	private int capacity; // 용량
	private int ptr; // 포인터

	// 생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int getCapacity() {
		return capacity;
	}

	// 예외:스택이 비어있음
	@SuppressWarnings("serial")
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// 예외: 스택이 가득 참
	@SuppressWarnings("serial")
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// 스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		return stk[ptr++] = x; // 포인터 값 x로 초기화 후 +1
	}

	// 스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 스택에서 데이터를 피크
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// 스택을 비움
	public void clear() {
		ptr = 0;
	}

	// 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; 0 <= i; i--) {// i(ptr-1)이 0이 될 때 까지 감소
			if (stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	// 꼭대기 쪽부터 선형검색
	// 검색성공
	// 검색실패

	// 스택의 용량을 반환

	public static void main(String[] args) {
		IntStack intStack = new IntStack(5);

		intStack.push(10);
		intStack.push(20);
		intStack.push(30);

		System.out.println("peek: " + intStack.peek());

		int result = intStack.indexOf(20);

		if (result == -1) {
			System.out.println("20 검색 실패");
		} else {
			System.out.println("20 검색 성공, 인덱스: " + result);
		}

		System.out.println("pop: " + intStack.pop());

		System.out.println("용량: " + intStack.getCapacity());

	}

}
