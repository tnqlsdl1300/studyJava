package abstract_interface;

import java.util.Scanner;

interface Shape{
	
	double findArea();
}

class Circle implements Shape{
	
	private int radius;

	Circle(){}
	
	Circle(int radius){
		this.radius = radius;
	}
	
	
	@Override
	public double findArea() {
		return  3.14 * radius * radius;
	}
	
}

class Rectangle implements Shape{
	
	private int width;
	private int height;
	
	public Rectangle() {	}
	
	
	// setter 메서드를 통해 변수 초기화
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	@Override
	public double findArea() {
		return width * height;
	}
	
}


public class Object_Main {
	
	static void prnCircle(Scanner sc) {
		System.out.print("반지름 입력 ==> ");
		Circle c = new Circle(sc.nextInt());
		
		System.out.println("=====================");
		System.out.println("원의 면적: " + c.findArea());
	}
	
	static void prnRectangle(Scanner sc) {
		Rectangle r = new Rectangle();
		
		System.out.print("가로 ==> ");
		r.setWidth(sc.nextInt());
		System.out.print("세로 ==> ");
		r.setHeight(sc.nextInt());
		
		System.out.println("=====================");
		System.out.println("원의 면적: " + r.findArea());
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형을 선택하세요.(1.원형, 2.사각형)");
		System.out.print("도형 선택 ==> ");
		int menu = sc.nextInt();
		
		if(menu == 1) {	// 원
			prnCircle(sc);
		}else if(menu == 2) {	// 사각형
			prnRectangle(sc);
		}
	
		sc.close();
	}
}