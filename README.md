## 목차
- [CircularQueue - 라운드로빈 스케줄링](#1-circularqueue)
- [ArrayList 정렬 - Comparable & Comparator](#2-arraylist-정렬)
- [도서관리 - 컬렉션 종합 실습](#3-도서관리)

---

## 1. CircularQueue - 라운드로빈 스케줄링
**파일:** `src/re/Train4.java`

### 구현 내용
- CircularQueue 자료구조 직접 구현 (enqueue, dequeue, peek, display)
- 라운드로빈 스케줄링 알고리즘 구현
- timeQuantum 기반 작업 처리 및 완료 시간 추적

### 핵심 학습
- front/rear/size로 순환 배열 관리
- `(rear + 1) % capacity` 순환 공식

### 발견
- `this.capacity` 누락으로 `isFull()`이 항상 true 반환 → enqueue 불가

---

## 2. ArrayList 정렬 - Comparable & Comparator
**파일:** `src/re/실습_10_3_ArrayList정렬.java`

### 구현 내용
- `Arrays.sort()` — 기본 타입 배열 정렬
- `Collections.sort()` — ArrayList 정렬
- `StudentComparator1` — name 기준 오름차순 정렬
- `StudentComparator2` — sid 기준 오름차순 정렬

### 핵심 학습
- `Comparator<T>` 인터페이스를 외부 클래스로 구현
- `String.compareTo()` — 문자열 비교 (사전순)
- `s1.getSid() - s2.getSid()` — 정수 비교 (빼기 패턴)
- `Arrays.sort()` vs `Collections.sort()` 사용 대상 구분

---

## 3. 도서관리 - 컬렉션 종합 실습
**파일:** `src/re/실습_10_4_도서관리.java`

### 구현 내용
- `Book` 클래스 — `Comparable<Book>` 구현 (title 기준)
- `Library` 클래스 — `ArrayList<Book>` 기반 도서 관리
  - `addBook()` — 용량(5) 초과 시 에러 출력
  - `removeBook()` — 빈 목록 삭제 시 에러 출력
  - `printBooks()` — 메시지 포함 전체 목록 출력
  - `searchBookByTitle()` — 제목 선형 탐색
  - `sortBooksByTitle()` — 제목 가나다순 정렬
  - `sortBooksByISBN()` — ISBN 숫자 내림차순 정렬
- `BookTitleComparator` — `String.compareTo()` 활용
- `BookIsbnComparator` — `Integer.parseInt()` 변환 후 정수 비교

### 핵심 학습
- `private` 필드는 외부 클래스에서 직접 접근 불가 → getter 필수
- `Comparable` (클래스 내부, 매개변수 1개) vs `Comparator` (외부 클래스, 매개변수 2개)
- 같은 파일에 여러 클래스 선언 가능 — `public` 클래스는 하나만
