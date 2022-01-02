package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

public class LoginCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. id, pw 파라미터 수집
		   String email = request.getParameter("email");
		   String pw = request.getParameter("pw");
		   
		   // DAO 객체 생성
		   DAO dao = new DAO();
		   dao.Login(email, pw);
		   MemberVO vo = dao.Login(email, pw);
		   
		   // 로그인 실패 / 성공 판단
		   // vo가 null이면 : 로그인 실패
		   // vo가 null이 아니라면 : 로그인 성공
		   
		   if(vo != null) {
			   //성공
			   System.out.println("로그인 성공");
			   
			   // 세션에 유저의 정보를 담아서 전달
			   // 1. 세션 객체 생성
			   HttpSession session = request.getSession();
			   
			   // 2. 세션에 Attribute 추가
			   session.setAttribute("vo", vo);
			   
		   }else {
			   //실패
			   System.out.println("로그인 실패");
		   }
		   
		   // 객체에서는 페이지를 이동할 때, try/catch문을 써줘야한다.
	       try {
	           
	           //객체에서는 페이지를 이동할 때, try/catch를 사용한다
	           response.sendRedirect("main.jsp");
	        }catch(Exception e) {
	           e.printStackTrace();
	        }
		
	}
	

}
