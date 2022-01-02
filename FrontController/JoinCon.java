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
	      // 0. �޾ƿ� �Ķ���͵��� ���ڵ�
	      
	      // 1. �Ķ���� ����
	      String email = request.getParameter("email");
	      String pw = request.getParameter("pw");
	      String tel = request.getParameter("tel");
	      String address = request.getParameter("address");
	      
	      // DAO ��ü ����
	      DAO dao = new DAO();
	      
	      // DAO�� Join�޼��� ���
	      int cnt = dao.Join(email, pw, tel, address);
	      
	      if(cnt > 0) {
	         System.out.println("ȸ������ ����!");
	         // join_success.jsp
	         // forward ������� �̵�
	         
	         request.setAttribute("vo", new MemberVO(email, pw, tel, address) );
	         
	         RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
	         
	         try {
	        	 rd.forward(request, response);
				
			} catch (Exception e) {
				
			}
	         
	      }else {
	         System.out.println("ȸ������ ����!");
	         // main.jsp
	         // redirect ������� �̵�
	         try {
				
	        	 response.sendRedirect("main.jsp");         
			} catch (Exception e) {
				
			}
	      }
	      
	      
	      
	      
	      

	}

}
