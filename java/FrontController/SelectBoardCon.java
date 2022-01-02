package FrontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BoardVO;
import Model.DAO;
import Model.MemberVO;

public class SelectBoardCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			// 1. 파라미터 수집
			int num = Integer.parseInt(request.getParameter("num"));
			
			// 2. DAO 객체 생성
			DAO dao = new DAO();
			// 3. DAO 메소드 사용해서 BoardVO 받아오기
			BoardVO bvo =dao.SelectOne(num);
			// 4. BoardVO를 담고 request의 영역에 저장하고
			request.setAttribute("bvo", bvo);
			// 5.  Forward방식으로 viewBoard.jsp
			
			
		         
		         RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
		         rd.forward(request, response);
		         
		     
			
		} catch (Exception e) {
			
		}

	}

}
