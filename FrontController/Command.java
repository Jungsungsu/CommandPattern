package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

public interface Command {

	// �߻�޼ҵ常 ��������
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
