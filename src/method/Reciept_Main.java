package method;

import java.util.Scanner;

class Reciept{
	public static final double TEX_RATE = 1.1;
	String food;
	int price;
	int num;
	static int totPrice;	// 각 개체별 합 금액을 받아야 하므로 static 처리
	double gong;
	double tex;
	int rPay;
	
	public Reciept() {}
	
	public Reciept(String food, int price, int num) {
		this.food = food;
		this.price = price;
		this.num = num;
	}
	
	int totPrice(int money){
		totPrice += money;	// 총금액
		
		return totPrice; 
	}
	
	void rPay() {	// totPrice외에는 객체의 값을 받을 필요가 없으므로 static 상관 없음
		gong = totPrice/TEX_RATE;
		tex = totPrice - gong;
		rPay = (int)(gong + tex);
		
		prn(gong, tex, rPay);
	}
	
	
	void prn(double gong, double tex, int rPay) {
		System.out.println("=============================");
		System.out.printf("공급가액\t\t%.0f원\n", gong);
		System.out.printf("부가세\t\t%.0f원\n", tex);
		System.out.println("=============================");
		System.out.printf("청구금액\t\t%,d원", rPay);
	}
}


public class Reciept_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 갯수 입력: ");
		Reciept[] rc = new Reciept[sc.nextInt()];	// 배열 갯수 지정
		Reciept rcTot = new Reciept();
		
		System.out.println("품명, 단가, 수량을 입력하세요");
		for(int i = 0; i < rc.length; i++) {
			rc[i] = new Reciept(sc.next(), sc.nextInt(), sc.nextInt());
			System.out.println("=============================");
		}
		
		for(int i = 0; i < rc.length; i++) {
			Reciept.totPrice = rc[i].totPrice(rc[i].price*rc[i].num);
			System.out.println(Reciept.totPrice);
		}
		
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("=============================");
		for(int i = 0; i < rc.length; i++) {
			System.out.println(rc[i].food + "\t" + rc[i].price + "\t" + rc[i].num + "\t" + (rc[i].price*rc[i].num) + "원");	
		}
		rcTot.rPay();	// rPay는 static메서드로 지정하지 않았기 때문에 객체를 선언해서 호출
			
		sc.close();
	}
}
