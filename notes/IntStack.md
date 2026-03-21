### 스택 구조
- LIFO(Last In First Out) — 마지막에 넣은 게 먼저 나옴
- `ptr` — 다음에 넣을 빈 위치를 가리킴 (현재 쌓인 개수이기도 함)
- `stk[]` — 실제 데이터를 담는 배열

### 전위/후위 연산
- `stk[ptr++] = x` → 현재 위치에 먼저 저장, 그 다음 ptr 증가 (push)
- `return stk[--ptr]` → ptr 먼저 감소, 그 다음 해당 위치 반환 (pop)
- `return stk[ptr - 1]` → ptr 변경 없이 꼭대기만 읽기 (peek)

### pop vs peek
- `pop` : `--ptr`로 ptr 자체를 변경 → 스택에서 제거됨
- `peek` : `ptr - 1`로 계산만 → ptr 유지, 스택 그대로

### clear()
- `ptr = 0`만으로 충분 — 실제 배열 값을 지우지 않음
- ptr 범위 밖은 없는 것으로 취급, 다음 push 시 덮어씌워짐

### indexOf()
- `ptr - 1`부터 역방향(꼭대기 → 바닥)으로 선형 탐색
- 찾으면 즉시 `return i` → for문 포함 함수 전체 종료
- 못 찾으면 `return -1`
- 탐색 메서드는 내부 상태(`ptr`) 절대 변경 금지

### getter / setter
- `private` 필드 → 외부 클래스에서 직접 접근 불가
- getter : 값을 읽기만 함 (`return capacity`)
- setter : 외부에서 값을 받아 저장 (`this.capacity = capacity`)
- `this` → 현재 인스턴스의 필드 변수를 가리킴 (매개변수명과 구분)
- 불변해야 하는 필드(`capacity`)는 getter만 두고 setter 생략

### serialVersionUID 경고
- `RuntimeException` 상속 시 `Serializable`이 따라옴
- 학습용 코드에서는 `@SuppressWarnings("serial")` 로 경고 억제
