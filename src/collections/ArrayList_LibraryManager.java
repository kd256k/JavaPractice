package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Book 클래스
class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book() {
	}
	
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books = new ArrayList<>();;

	// 책 추가 (용량 초과 시 에러메시지 출력)
	public void addBook(Book book) {
		if (books.size() >= CAPACITY) {
			System.out.println("error");
		}	else {
			books.add(book);
		}
	}

	// 책 삭제 (빈 목록에서 삭제 시 에러메시지 출력)
	public Book removeBook() {
		if (books.size() == 0) {
			System.out.println("error");
			return null;
		}
		return books.remove(0);
	}

	// 메시지와 함께 library에 저장된 도서 출력
	public void printBooks(String msg) {
		System.out.println(msg);
		for(int i=0; i<books.size(); i++) {
			System.out.println(books.get(i));
		}
		System.out.println("-".repeat(60));
	}

	// 제목으로 정렬
	public void sortBooksByTitle() {
		Collections.sort(books, new BookTitleComparator());
	}

	// ISBN으로 정렬
	public void sortBooksByISBN() {
		Collections.sort(books, new BookIsbnComparator());
	}

	// books에서 title을 검색해서 리턴, 없으면 null 리턴
	public Book searchBookByTitle(String title) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				return books.get(i);
			}
		}
		return null;
	}
}

class BookTitleComparator implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareTo(b2.getTitle());
	}
}

class BookIsbnComparator implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return Integer.parseInt(b2.getIsbn())-Integer.parseInt(b1.getIsbn());
	}
}

public class ArrayList_LibraryManager {
	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		library.sortBooksByTitle(); // 제목으로 도서 목록 정렬
		library.printBooks("정렬후 최종 도서 목록:");

		// 특정 제목으로 도서 검색 후 출력
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook != null)
			System.out.println(searchTitle + " 검색결과\n[" + foundBook + "]");
		else
			System.out.println(searchTitle + " 검색결과가 없습니다.");
		System.out.println("-".repeat(60));

		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");
		
		library.removeBook();
	}
}