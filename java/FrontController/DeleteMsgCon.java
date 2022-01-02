package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

public class DeleteMsgCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			// 1. 파라미터 수집
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			
			// 2. DAO 객체 생성
			DAO dao = new DAO();
			
			// 3. DAO의 메소드 사용
			int cnt =dao.DeleteMsg(bnum);
			
			if(cnt > 0) {
				System.out.println("메시지 삭제 성공!");
			}else {
				System.out.println("메시지 삭제 실패!");
			}
			
			// 페이지 이동
			response.sendRedirect("main.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
