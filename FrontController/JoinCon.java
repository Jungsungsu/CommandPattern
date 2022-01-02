package FrontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

public class JoinCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		  try {
			
			  request.setCharacterEncoding("euc-kr");
		} catch (Exception e) {
			
		}
	      // 0. 받아올 파라미터들을 인코딩
	      
	      // 1. 파라미터 수집
	      String email = request.getParameter("email");
	      String pw = request.getParameter("pw");
	      String tel = request.getParameter("tel");
	      String address = request.getParameter("address");
	      
	      // DAO 객체 생성
	      DAO dao = new DAO();
	      
	      // DAO의 Join메서드 사용
	      int cnt = dao.Join(email, pw, tel, address);
	      
	      if(cnt > 0) {
	         System.out.println("회원가입 성공!");
	         // join_success.jsp
	         // forward 방식으로 이동
	         
	         request.setAttribute("vo", new MemberVO(email, pw, tel, address) );
	         
	         RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
	         
	         try {
	        	 rd.forward(request, response);
				
			} catch (Exception e) {
				
			}
	         
	      }else {
	         System.out.println("회원가입 실패!");
	         // main.jsp
	         // redirect 방식으로 이동
	         try {
				
	        	 response.sendRedirect("main.jsp");         
			} catch (Exception e) {
				
			}
	      }
	      
	      
	      
	      
	      

	}

}
