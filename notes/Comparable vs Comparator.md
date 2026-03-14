### Comparable vs Comparator
- `Comparable` → `this` vs 상대방, 매개변수 1개, 클래스 안에 구현
- `Comparator` → 외부인1 vs 외부인2, 매개변수 2개, 별도 클래스에 구현

### 정수 비교 패턴
- `s1.getSid() - s2.getSid()` → 오름차순
- `s2.getSid() - s1.getSid()` → 내림차순
- 문자열은 빼기 불가 → `s1.getName().compareTo(s2.getName())` 사용

### 접근 제어
- `private` 필드 → 같은 클래스 안에서만 직접 접근 가능 (`this.title`)
- 외부 클래스에서는 반드시 getter 사용 (`getTitle()`)

### Arrays.sort vs Collections.sort
- `Arrays.sort()` → 배열(`[]`) 전용
- `Collections.sort()` → ArrayList 등 컬렉션 전용

### 인터페이스
- 몸통 없이 선언만, `implements`하면 반드시 구현해야 함
- `Comparable<T>` implements → `compareTo()` 구현 강제
- `Comparator<T>` implements → `compare()` 구현 강제
