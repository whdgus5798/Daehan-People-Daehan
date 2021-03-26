package page.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.model.FestaDAO;
import page.model.FestaVO;
import page.model.PopularityDAO;
import page.model.PopularityVO;
import page.model.RouteDAO;
import page.model.RouteVO;

/**
 * Servlet implementation class PageController
 */
@WebServlet("*.page")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageController() {
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
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));
		
		String path = "";
		
		//Festival servlet
		if(uri.equals("page/showAllFestival")) {
			FestaDAO fedao1 = new FestaDAO();
			ArrayList<FestaVO> alist1 = fedao1.showAllFestival();
			//pageContext>request>session>application
			request.setAttribute("alist1", alist1);
			
			path = "FestivalMain.jsp"; 
		} else if(uri.equals("page/showOneFestival")) {
	
			String festa_name = request.getParameter("festa_name");
			FestaDAO fedao = new FestaDAO();
			FestaVO fv = fedao.showOneFestival(festa_name);
			request.setAttribute("ftv", fv);
			
			path = "FestivalSev.jsp"; //view를 맡은 jsp
		}
		//mainPage servlet
		else if(uri.equals("page/mainPage")) {
			RouteDAO rdao = new RouteDAO();
			ArrayList<RouteVO> rlist = rdao.showAllRoute("조회순");
			request.setAttribute("rlist", rlist);
			
			FestaDAO fedao = new FestaDAO();
			ArrayList<FestaVO> flist = fedao.showAllFestival();
			request.setAttribute("flist", flist);
			
			path = "mainPage.jsp";	
		}
		//popularity servlet
		else if(uri.equals("page/showAllPopularity")) {
			PopularityDAO podao1 = new PopularityDAO();
			ArrayList<PopularityVO> plist1 = podao1.showAllPopularity();
			request.setAttribute("plist1", plist1);
			
			path = "PopularityMain.jsp";
			
		} else if(uri.equals("page/showOnePopularity")) {
			String popular_name = request.getParameter("popular_name");
			PopularityDAO podao = new PopularityDAO();
			PopularityVO pv = podao.showOnePopularity(popular_name);
			request.setAttribute("ptv", pv);
			
			path ="PopularitySev.jsp";
		}
		//route servlet
		else if(uri.equals("page/showAllRoute")) {
			RouteDAO dao = new RouteDAO();
			String condition = request.getParameter("condition");
			ArrayList<RouteVO> rlist = dao.showAllRoute(condition);
			int cnt = dao.Routecount();
			request.setAttribute("rlist", rlist);
			request.setAttribute("cnt", cnt);;
			path = "CoseMain.jsp";
		} else if(uri.equals("page/showOneRoute")) {
			RouteDAO dao = new RouteDAO();
			String route_name = request.getParameter("route_name");
			dao.increaseHit(route_name);
			RouteVO vo = dao.showOneRoute(route_name);
			request.setAttribute("vo", vo);
			path="CoseSub.jsp";
		}
		
		dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
		
	}

}
