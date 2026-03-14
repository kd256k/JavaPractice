package re;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
 
/*
 * 1) 정수의 정렬
 *  1.1) 정수 배열의 정렬
 *  1.2) ArrayList의 정렬
 * 2) 객체의 정렬
 *  2.1 객체 배열의 정렬
 *  2.2 ArrayList<Student>의 정렬
 * 
 */

class Student {
	private int sid;
	private String name;

	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
	}

	public int getSid() {
		return this.sid;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "sid:" + sid + ", 이름:" + name;
	}
}

//s1의 name이 s2의 name보다 앞선다면 -1을 리턴
//s1이 name과 s2의 name이 같다면 0을 리턴
//s1의 name이 s2의 name 뒤진다면 1을 리턴
class StudentComparator1 implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

//s1의 sid가 s2의 sid 작다면 -1을 리턴
//s1이 sid와 s2의 sid가 같다면 0을 리턴
//s1의 sid가 s2의 sid 크다면 1을 리턴
class StudentComparator2 implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getSid() - s2.getSid();
	}
}
public class 실습_10_3_ArrayList정렬 {

	private static Random random = new Random();
	
	public static void main(String[] args) {

		System.out.println("1. 정수 배열의 정렬");
		System.out.println("-".repeat(40));
		int data[] = new int[10];

		// 배열에 랜덤으로 데이터를 입력 후 출력
		for (int i = 0; i < data.length; i ++) {
			data[i] = random.nextInt(100);
			System.out.print(data[i] + " ");
		}
		System.out.println();

		// 정렬 후 출력
		System.out.println("순서 정렬");
		Arrays.sort(data);
		for (int n : data)
			System.out.print(n + " ");
		System.out.println();
		
		//---------------
		System.out.println("=".repeat(40));
		System.out.println("2. ArrayList<Integer>정수 배열의 정렬");
		System.out.println("-".repeat(40));		
		ArrayList<Integer> alist = new ArrayList<>();
		
		// 리스트에 랜덤으로 데이터를 입력 후 출력
		for (int j = 0; j < data.length; j++) {
			alist.add(random.nextInt(100));
			System.out.print(alist.get(j) + " ");
		}
		System.out.println();
		
		// 정렬 후 출력
		System.out.println("순서 정렬");
		Collections.sort(alist);
		for (int n : alist)
			System.out.print(n + " ");
		System.out.println();
		
		//---------------
		System.out.println("=".repeat(40));
		System.out.println("3. 객체 배열의 정렬");
		Student []st = new Student[6];
		st[0] = new Student(11,"hong");
		st[1] = new Student(51,"kim");
		st[2] = new Student(31,"han");
		st[3] = new Student(88,"park");
		st[4] = new Student(33,"go");
		st[5] = new Student(55,"song");
		for (Student stx : st)
			System.out.println(stx);

		// 배열 st에 저장된 데이터를 정렬 
		Arrays.sort(st, 0, st.length, new StudentComparator1());
		System.out.println();
		System.out.println("이름순 정렬");
		for (Student s : st)
			System.out.println(s);
		
		//---------------
		System.out.println("=".repeat(40));		
		System.out.println("4. 객체 리스트의 정렬");
		ArrayList<Student> blist = new ArrayList<>();
		blist.add(new Student(11,"hong"));
		blist.add(new Student(51,"kim"));
		blist.add(new Student(31,"han"));
		blist.add(new Student(88,"park"));
		blist.add(new Student(33,"go"));
		blist.add(new Student(55,"song"));
		for (Student s : blist)
			System.out.println(s);
		
		// 컬렉션 blist에 저장된 데이터를 정렬 
		Collections.sort(blist, new StudentComparator2());
		System.out.println();
		System.out.println("학번순 정렬");
		for (Student s : blist)
			System.out.println(s);
			
	}
}
