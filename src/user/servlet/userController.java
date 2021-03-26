package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import user.model.UserDAO;
import user.model.UserVO;

/**
 * Servlet implementation class userController
 */
@WebServlet("*.user")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dp;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
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
		doGet(request, response);
	}
	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		HttpSession session = request.getSession();
		
		String path ="";
		
		if(uri.equals("page/login")) {
			
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			UserDAO dao = new UserDAO();
			int result = dao.confirmLogin(loginId, loginPw);
			
			if(result == 1) {
				UserVO vo = dao.getUserInfo(loginId);
				session.setAttribute("user_id", vo.getUser_id());
				session.setAttribute("user_name", vo.getUser_name());
			}
			request.setAttribute("result", result);
			path = "UserAlter.jsp";
			
		} else if(uri.equals("page/registMember")) {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			String user_name = request.getParameter("user_name");
			UserDAO dao = new UserDAO();
			if(dao.doubleCheckId(user_id)) {
				dao.registMember(user_id, user_pw, user_name);
				request.setAttribute("result", 10);
			} else {
				request.setAttribute("result", -10);
			}
			path = "UserAlter.jsp";
			
		} else if(uri.equals("page/MyPage")) {
			
			String user_id = (String) session.getAttribute("user_id");
			UserDAO dao = new UserDAO();
			UserVO vo = dao.getUserInfo(user_id);
			request.setAttribute("vo", vo);
			path = "UserMyPage.jsp";
			
		} else if(uri.equals("page/searchPw")) {
			
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String pw = "";
			UserDAO dao = new UserDAO();
			UserVO vo = dao.getUserInfo(user_id);
			if(user_name.equals(vo.getUser_name())) {
				pw = vo.getUser_pw();
			} else {
				pw = "x";
			}
			request.setAttribute("resultStr", pw);
			path = "UserAlter.jsp";
		} else if(uri.equals("page/userUpdate")) {
			
			String user_id = (String) session.getAttribute("user_id");
			UserDAO dao = new UserDAO();
			UserVO vo = dao.getUserInfo(user_id);
			
			request.setAttribute("userVO", vo);
			path = "UserUpdate.jsp";
			
		} else if(uri.equals("page/UserUpdateConfirm")) {
			
			String user_id = (String) session.getAttribute("user_id");
			String user_pw = request.getParameter("user_pw");
			String user_name = request.getParameter("user_name");
			session.setAttribute("user_name", user_name);
			UserDAO dao = new UserDAO();
			UserVO vo = new UserVO(user_id, user_pw, user_name);
			dao.changeUserInfo(vo);
			
			path="MyPage.user";
		} else if(uri.equals("page/userDelete")) {
			
			String user_id = (String) session.getAttribute("user_id");
			UserDAO dao = new UserDAO();
			dao.deleteUser(user_id);
			session.invalidate();
			request.setAttribute("result", -100);
			
			path = "UserAlter.jsp";
			
		} else if(uri.equals("page/Logout")) {
			session.invalidate();
			request.setAttribute("result", 100);
			path="UserAlter.jsp";
		}
		
		dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
	}

}
