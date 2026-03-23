# Heap & HeapSort

## 핵심 개념

배열 기반 MaxHeap 구현 및 HeapSort.

- 인덱스 1번부터 사용
- 부모: `i/2`, 왼쪽 자식: `2*i`, 오른쪽 자식: `2*i+1`

---

## 구조

```java
interface MaxHeap {
    void insert(int x);
    int deleteMax();
}

class Heap implements MaxHeap {
    int[] arr;
    int maxSize;
    int n;

    public Heap(int sz) {
        arr = new int[sz + 1]; // 인덱스 0 미사용
        maxSize = sz;
        n = 0;
    }
}
```

---

## insert (bottom-up)

마지막 위치에 넣고, 부모보다 크면 위로 올려보냄.

```java
public void insert(int k) {
    if (n == maxSize) { heapFull(); return; }
    int i = ++n;
    while (i > 1 && arr[i / 2] < k) {
        arr[i] = arr[i / 2];
        i = i / 2;
    }
    arr[i] = k;
}
```

---

## deleteMax (top-down)

루트(최댓값)를 꺼내고, 마지막 노드를 루트에 올린 뒤 아래로 내려보냄.

```java
public int deleteMax() {
    if (n == 0) { heapEmpty(); return Integer.MIN_VALUE; }
    int max = arr[1];
    int temp = arr[n]; // 내려보낼 값 저장
    n--;
    int i = 1, j;
    while (2 * i <= n) {
        if (2 * i + 1 <= n && arr[2 * i + 1] > arr[2 * i])
            j = 2 * i + 1;
        else
            j = 2 * i;
        if (temp > arr[j]) break;
        arr[i] = arr[j];
        i = j; // 인덱스를 자식으로 교체 (값 교체 아님)
    }
    arr[i] = temp; // 최종 위치에 놓기
    return max;
}
```

---

## 핵심 포인트

| 항목 | 설명 |
|---|---|
| `n--` | 마지막 노드를 논리적으로 제거 (배열에서 실제 삭제 아님) |
| `2*i+1 <= n` | `<`가 아니라 `<=` — 마지막 노드가 오른쪽 자식 위치일 수 있음 |
| `temp` 패턴 | 내려보낼 값을 미리 저장, 루프 끝난 뒤 `arr[i] = temp` |
| `i = j` | 값 교체가 아니라 인덱스 이동 |
| `Integer.MIN_VALUE` | 힙이 비었을 때 반환하는 sentinel 값 |
