package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

public class DeleteMsgCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			// 1. �Ķ���� ����
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			
			// 2. DAO ��ü ����
			DAO dao = new DAO();
			
			// 3. DAO�� �޼ҵ� ���
			int cnt =dao.DeleteMsg(bnum);
			
			if(cnt > 0) {
				System.out.println("�޽��� ���� ����!");
			}else {
				System.out.println("�޽��� ���� ����!");
			}
			
			// ������ �̵�
			response.sendRedirect("main.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
