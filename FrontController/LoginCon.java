package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

public class LoginCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. id, pw �Ķ���� ����
		   String email = request.getParameter("email");
		   String pw = request.getParameter("pw");
		   
		   // DAO ��ü ����
		   DAO dao = new DAO();
		   dao.Login(email, pw);
		   MemberVO vo = dao.Login(email, pw);
		   
		   // �α��� ���� / ���� �Ǵ�
		   // vo�� null�̸� : �α��� ����
		   // vo�� null�� �ƴ϶�� : �α��� ����
		   
		   if(vo != null) {
			   //����
			   System.out.println("�α��� ����");
			   
			   // ���ǿ� ������ ������ ��Ƽ� ����
			   // 1. ���� ��ü ����
			   HttpSession session = request.getSession();
			   
			   // 2. ���ǿ� Attribute �߰�
			   session.setAttribute("vo", vo);
			   
		   }else {
			   //����
			   System.out.println("�α��� ����");
		   }
		   
		   // ��ü������ �������� �̵��� ��, try/catch���� ������Ѵ�.
	       try {
	           
	           //��ü������ �������� �̵��� ��, try/catch�� ����Ѵ�
	           response.sendRedirect("main.jsp");
	        }catch(Exception e) {
	           e.printStackTrace();
	        }
		
	}
	

}
