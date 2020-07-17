package method;

public class CardTest {

	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);	// Card의 width, height 변수가 static이기 때문에 객체 생성 없이 사용할 수 있음
		System.out.println("Card.height = " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		System.out.println("c1은" + c1.kind + ", " + c1.number + "이며, 크기는 (" + Card.width + ", " + Card.height + ")");
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		System.out.println("c2는" + c2.kind + ", " + c2.number + "이며, 크기는 (" + Card.width + ", " + Card.height + ")");
		
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		c1.width = 50;
		c1.height = 80;
		c2.width = 50;
		c2.height = 80;
		
		System.out.println("c1은" + c1.kind + ", " + c1.number + "이며, 크기는 (" + Card.width + ", " + Card.height + ")");
		System.out.println("c2는" + c2.kind + ", " + c2.number + "이며, 크기는 (" + Card.width + ", " + Card.height + ")");
		
		

	}

}
