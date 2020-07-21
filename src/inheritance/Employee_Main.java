package inheritance;

import java.util.Scanner;

class Employee {	// 부모클래스
	String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return 0;
	}

}

class Permanent extends Employee {	// 자식클래스
	final String position = "정규직";
	private int pay;	// getter 메서드를 만들때   getPay()로 오버라이딩 될 수 있으니 변수명을 바꾸는게 좋음
	private int bonus;

	
	public Permanent() {	}

	public Permanent(String name, int pay, int bonus) {	// 객체를 선언할 때 바로 3개의 변수를 입력받기 위해 선언
		super(name);	// 받은 name을 객체의 name에 할당해줌
		this.pay = pay;
		this.bonus = bonus;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public int getPay() {
		return pay + bonus;
	}

}

class Temporary extends Employee {	// 자식클래스
	final String position = "임시직";
	private int pay;	// getter 메서드를 만들때   getPay()로 오버라이딩 될 수 있으니 변수명을 바꾸는게 좋음
	private int time;

	
	public Temporary() {	}
	
	public Temporary(String name, int time, int pay) {	// 객체를 선언할 때 바로 3개의 변수를 입력받기 위해 선언
		super(name);	// 받은 name을 객체의 name에 할당해줌
		this.time = time;
		this.pay = pay;
	}
	
	
	public String getPosition() {
		return position;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int getPay() {
		return pay * time;
	}

}

public class Employee_Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("고용형태-정규직<P>, 임시적<T>를 입력하세요.");
		String choice = sc.next();

		if (choice.equalsIgnoreCase("P")) {
			System.out.println("이름, 기본급, 보너스를 입력하세요.");
			Permanent per = new Permanent(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("===============================");
			System.out.println("고용형태: " + per.getPosition());
			System.out.println("이름: " + per.getName());
			System.out.printf("급여: %,d원\n", per.getPay());
			
		} else if (choice.equalsIgnoreCase("T")) {
			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
			Temporary tem = new Temporary(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("===============================");
			System.out.println("고용형태: " + tem.getPosition());
			System.out.println("이름: " + tem.getName());
			System.out.printf("급여: %,d원\n", tem.getPay());
			
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}

		sc.close();
	}
}
