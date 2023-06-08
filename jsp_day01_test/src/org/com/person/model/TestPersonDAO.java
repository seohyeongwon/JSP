package org.com.person.model;

import java.util.List;
import java.util.Scanner;

public class TestPersonDAO {

	static Scanner scan = new Scanner(System.in);
	static PersonDAO qwer = new PersonDAO();
	private static Object won;

	//private static char[] won ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a: while (true) {
			switch (menu()) {
			case 1:
				inputwon();
				break;
			case 2:
				outputwon();
				break;
			case 3:
				searchwon();
				break;
			case 4:
				modifywon();
				break;
			case 5:
				deletewon();
				break;
			case 6:
				System.out.println("end!!!");
				break a;
			default:
				System.out.println("nononono");
				break;
			}
			System.out.println("bye");
		}
	}

	private static void deletewon() {
		// TODO Auto-generated method stub
		outputwon();
		System.out.println("delete");

		
		System.out.print("삭제 할 SEQ : ");
		int seq = scan.nextInt();
		qwer.delete(new PersonDTO(seq));

	}

	private static void searchwon() {
		// TODO Auto-generated method stub
		System.out.println("search");

		System.out.print("수정 할 SEQ : ");
		int seq = scan.nextInt();
		PersonDTO won = qwer.selectOne(new PersonDTO(seq));
		if (won == null) {
			System.out.println("검색 된 사람이 없다!");
			return;
		}
		System.out.println(won);

	}

	private static void modifywon() {
		// TODO Auto-generated method stub
		outputwon();
		System.out.println("modify");

		
		System.out.print("수정 할 SEQ : ");
		int seq = scan.nextInt();
		
		PersonDTO won = qwer.selectOne(new PersonDTO(seq));
		if (won == null) {
			System.out.println("수정 할 정보가 부재합니다.");
			return;
		}
		System.out.print("새 아이디: ");
		String newId = scan.next();
		if (!newId.equals(""))
			((PersonDTO) won).setId(newId);
		System.out.print("새 이름: ");
		String newName = scan.next();
		if (!newName.equals(""))
			won.setName(newName);
		System.out.print("새 이메일: ");
		String newEmail = scan.next();
		if (!newEmail.equals(""))
			won.setEmail(newEmail);
		System.out.println("--- 수정 완료! ---");

	}

	private static void inputwon() {
		// TODO Auto-generated method stub
		System.out.println("input");
		System.out.print("아이디 입력: ");
		String id = scan.next();
		System.out.print("성명 입력: ");
		String name = scan.next();
		System.out.print("age 입력: ");
		int age = scan.nextInt();
		System.out.print("이메일 입력: ");
		String email = scan.next();



	}

	private static void outputwon() {
		// TODO Auto-generated method stub
		System.out.println("output");
		List<PersonDTO> list = qwer.selectAll();
		for (PersonDTO won : list) {
			System.out.println(won);
		}

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1.input 2.output 3.search 4.modify 5.delete 6.end");
		System.out.println("choice>>");
		return scan.nextInt();
	}

}
