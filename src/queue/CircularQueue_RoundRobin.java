package queue;

public class CircularQueue_RoundRobin {
	
	static class Job {
		String name;
		int remainingTime;
		int completionTime;
		
		Job(String name, int remainingTime){
			this.name = name;
			this.remainingTime = remainingTime;
		}
	}
	
	static class Queue {
		Job[] queue;
		int capacity;
		int size;
		int front;
		int rear;
		
		Queue(int capacity){
			queue = new Job[capacity];
			this.capacity = capacity;
			size = 0;
			front = 0;
			rear = -1;
		}
		
		boolean isFull() {
			return size == capacity;
		}
		
		boolean isEmpty() {
			return size == 0;
		}
		
		void enqueue(Job job) {
			if(isFull()) {
				return;
			}
			rear = (rear + 1) % capacity;
			queue[rear] = job;
			size++;		
		}
		
		Job dequeue() {
			if(isEmpty()) {
				return null;
			}
			Job job = queue[front];
			front = (front + 1) % capacity;
			size--;
			return job;
		}	
		
		Job peek() {
			if(isEmpty()) {
				return null;
			}	else {
				return queue[front];
			}
		}
		
		void display() {
			for(int i = 0; i < size; i++) {
				int idx = (front + i) % capacity;
				System.out.println("현재작업  : " + queue[idx].name + ", 남은 시간 : " + queue[idx].remainingTime);
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Queue CircularQueue = new Queue(5); //CircularQueue객체 생성
		System.out.println("시작");
		
		Job jobA = new Job("작업A", 5); //Job 객체 생성
		Job jobB = new Job("작업B", 8);
		Job jobC = new Job("작업C", 3);
		
		CircularQueue.enqueue(jobA); //enqueue로 큐에 추가
		CircularQueue.enqueue(jobB);
		CircularQueue.enqueue(jobC);
		
		int timeQuantum = 2; //(시간단위)
		int currentTime = 0; //(현재 시간 추적)
		int slice;
		
		while(!CircularQueue.isEmpty()) {
			System.out.println("=== 현재 큐 상태 ===");
			CircularQueue.display();
			Job job = CircularQueue.dequeue();
			
			//System.out.println("현재 작업 : " + job.name + ", 남은시간: " + job.remainingTime);
			if (job.remainingTime < timeQuantum) {
				slice = job.remainingTime;
			} else {
				slice = timeQuantum;
			}
			job.remainingTime -= slice;
			currentTime += slice;
			
			if (job.remainingTime > 0) {
				CircularQueue.enqueue(job);
			} else {
				job.completionTime = currentTime;
				System.out.println(job.name + " 완료, 완료 소요 시간: " + job.completionTime);
			}
			
		}
		System.out.println("모든 작업이 완료되었습니다. 총 소요시간 : " + currentTime);
		
		
	}
	
	
	
}