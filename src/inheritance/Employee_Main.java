package inheritance;

import java.util.Scanner;

class Employee {
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

class Permanet extends Employee {
	final String position = "정규직";
	int pay;
	int bonus;

	
	public Permanet() {	}

	public Permanet(String name, int pay, int bonus) {	// 객체를 선언할 때 바로 3개의 변수를 입력받기 위해 선언
		super(name);	// 받은 name을 객체의 name에 할당해줌(부모클래스의  해당 멤버에는 영향x)
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

class Temporary extends Employee {
	final String position = "임시직";
	int pay;
	int time;

	
	public Temporary() {	}
	
	public Temporary(String name, int time, int pay) {	// 객체를 선언할 때 바로 3개의 변수를 입력받기 위해 선언
		super(name);	// 받은 name을 객체의 name에 할당해줌(부모클래스의  해당 멤버에는 영향x)
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
			Permanet per = new Permanet(sc.next(), sc.nextInt(), sc.nextInt());
			
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
			
		}
		Employee em = new Employee();
		System.out.println(em.name);

		sc.close();
	}
}
