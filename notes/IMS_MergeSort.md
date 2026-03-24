# MergeSort (반복문 기반)

## 핵심 개념

배열을 크기 1짜리부터 시작해서, `size`를 1 → 2 → 4로 두 배씩 늘리면서 구간을 합쳐나가는 방식.
재귀 없이 반복문만으로 구현.

---

## 용어

| 변수 | 설명 |
|---|---|
| `size` | 현재 합치는 구간의 크기 |
| `left` | 합치는 구간의 시작 인덱스 (`left += 2*size`로 이동) |
| `mid` | 왼쪽 구간의 끝 인덱스 (`left + size - 1`) |
| `right` | 오른쪽 구간의 끝 인덱스 (`left + 2*size - 1`) |
| `Math.min(..., n-1)` | 배열 범위 초과 방지 |

---

## merge() 흐름

```java
private static void merge(Term[] terms, Term[] temp, int left, int mid, int right) {
    int i = left, j = mid + 1, k = left;
    // 1. 둘 다 남아있는 동안 비교
    while (i <= mid && j <= right) {
        if (terms[i].value <= terms[j].value)
            temp[k++] = terms[i++];
        else
            temp[k++] = terms[j++];
    }
    // 2. 왼쪽이 남았으면 복사
    while (i <= mid) temp[k++] = terms[i++];
    // 3. 오른쪽이 남았으면 복사
    while (j <= right) temp[k++] = terms[j++];
    // 4. temp → terms 복사
    for (int idx = left; idx <= right; idx++)
        terms[idx] = temp[idx];
}
```

---

## 핵심 포인트

| 항목 | 설명 |
|---|---|
| `temp` 배열이 필요한 이유 | `terms`에서 직접 덮어쓰면 원래 값이 사라짐 |
| 두 while을 나란히 쓰는 이유 | 한쪽이 먼저 끝나면 나머지만 자동으로 실행, `if/else` 불필요 |
| 객체 배열 비교 | `terms[i] < terms[j]` 불가, `terms[i].value < terms[j].value` 사용 |
| `static` 메서드 | 객체 생성 없이 호출 가능, 상태(필드)가 필요 없을 때 사용 |
| 복사 범위 | `idx <= right` (`<`가 아니라 `<=`) |
