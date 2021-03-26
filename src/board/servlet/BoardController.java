package board.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dp;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doRequest(request, response);
	}

	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		String path = "";
		
		if(uri.equals("page/showAllBoard")) {	
			
			BoardDAO dao = new BoardDAO();
			ArrayList<BoardVO> list = dao.showAllBoard();
			request.setAttribute("boardList", list);
			path = "BoardAllView.jsp";
			
		} else if(uri.equals("page/showBoardInfo")) {
			int bd_id = Integer.parseInt(request.getParameter("bd_id"));
			BoardDAO dao = new BoardDAO();
			dao.incrementHit(bd_id);
			BoardVO vo = dao.showBoardInfo(bd_id);
			request.setAttribute("boardVO", vo);
			path = "BoardView.jsp";
			
		} else if(uri.equals("page/searchBoard")) {
			
			String keyword = request.getParameter("keyword");
			BoardDAO dao = new BoardDAO();
			ArrayList<BoardVO> list = dao.searchBoard(keyword);
			request.setAttribute("boardList", list);
			path="BoardAllView.jsp";
			
		} else if(uri.equals("page/boardModify")) {
			
			int bd_id = Integer.parseInt(request.getParameter("bd_id"));
			BoardDAO dao = new BoardDAO();
			BoardVO vo = dao.showBoardInfo(bd_id);
			request.setAttribute("boardVO", vo);
			path = "BoardModify.jsp";
			
		} else if(uri.equals("page/boardModifyConfirm")) {
			int bd_id = Integer.parseInt(request.getParameter("bd_id"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			content = content.replaceAll("\n", "<br>");
			BoardDAO dao = new BoardDAO();
			dao.updateContent(bd_id, title, content);
			path="showBoardInfo.board?bd_id="+bd_id;
			
		} else if(uri.equals("page/boardInsert")) {
			BoardDAO dao = new BoardDAO();
			String writer = (String) session.getAttribute("user_id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			content = content.replaceAll("\n", "<br>");
			dao.insertBoard(writer, title, content);
			path="showAllBoard.board";
		} else if(uri.equals("page/boardDelete")) {
			int bd_id = Integer.parseInt(request.getParameter("bd_id"));
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(bd_id);
			path="showAllBoard.board";
		}
		
		dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
		
	}

}
