## MEMO

### 라운드로빈
- 병렬이 아니라 순차 처리
- 한 번에 하나씩 꺼내서 처리하고 안 끝나면 뒤에 insert

### 변수/상수
- 변수: front, rear, size (매 enqueue/dequeue마다 변함)
- 상수: capacity (큐 생성 시 고정)

### enqueue/dequeue 역할
- enqueue: rear로 위치 라벨링 후 job insert
- dequeue: front로 위치 라벨링 후 job 반환