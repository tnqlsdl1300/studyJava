package abstract_interface;

import java.util.Scanner;

abstract class Employee{
	
	String name;
	
	public Employee() {	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	abstract int getMoney();
	
}

class Permanent extends Employee{
	
	private int salary;
	private int bonus;
	
	
	public Permanent() {	}
	
	public Permanent(String name, int salary, int bonus) {
		super(name);
		this.salary = salary;
		this.bonus = bonus;
	}
	

	public int getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	int getMoney() {
		return this.salary + this.bonus;
	}
	
}

class Temporary extends Employee{
	
	private int pay;
	private int time;

	
	public Temporary() {	}
	
	public Temporary(String name, int pay, int time) {
		super(name);
		this.pay = pay;
		this.time = time;
	}
	
	
	public int getPay() {
		return pay;
	}

	public int getTime() {
		return time;
	}
	

	@Override
	int getMoney() {
		return this.pay * this.time;
	}
	
}

public class AbstractEmployee_Main {
	public static void main(String[] args) {
		
		String position = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("고용형태-정규직<P>, 임시적<T>를 입력하세요.");
		String menu = sc.next();
		
		if(menu.equalsIgnoreCase("p")) {
			System.out.println("이름, 기본급, 보너스를 입력하세요.");
			Permanent p = new Permanent(sc.next(), sc.nextInt(), sc.nextInt());
			System.out.println("=======================");
			
			position = "정규직";
			System.out.println("고용형태: " + position);
			System.out.println("이름: " + p.getName());
			System.out.printf("급여: %,d원", p.getMoney());
			
		}else if(menu.equalsIgnoreCase("t")) {
			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
			Temporary t = new Temporary(sc.next(), sc.nextInt(), sc.nextInt());
			System.out.println("=======================");
			
			position = "임시직";
			System.out.println("고용형태: " + position);
			System.out.println("이름: " + t.getName());
			System.out.printf("급여: %,d원", t.getMoney());
			
		}else {
			System.out.println("잘못 입력");
		}	
		sc.close();
	}
}