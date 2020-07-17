package method;

public class MemberService {
	
	boolean login(String id, String password) {
		
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}else {
			System.out.println("로그인 실패");
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}

}
