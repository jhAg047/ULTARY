package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostService;
import post.model.vo.CAns;

/**
 * Servlet implementation class CansInsertServlet
 */
@WebServlet("/insertCAns.tl")
public class CansInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CansInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNum = Integer.parseInt(request.getParameter("cNumber"));
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int alkind = 2;
		
		CAns ca = new CAns();
		ca.setcNum(cNum);
		ca.setMemberid(writer);
		ca.setAnsContent(content);
		
		String allink = "/cmdetail.po?pno="+pNum;
		int result = new PostService().insertCAns(ca);
		int result2 = new PostService().insertAlert2(allink, writer, alkind, cNum);
		
		if(result == 0 || result2 == 0) {
			request.setAttribute("msg", "답글 입력에 실패헀습니당");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
