package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class NaverInsertServlet
 */
@WebServlet("/naverInsert.mem")
public class NaverInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//memberjoinNaberForm에서 받아온 정보로 인설트하기
		String memberid = request.getParameter("memberid");
		String nickname = request.getParameter("nickname");
		String membername = request.getParameter("membername");
		String password = "불필요정보";
		//성별 name="gender" 로 1항목
		String gen = request.getParameter("gender");
		char gender = gen.charAt(0);
		
		
		//생년월일 name="birth"로 3항목
		String birthY = request.getParameter("birthY");
		String birthM = request.getParameter("birthM");
		String birthD = request.getParameter("birthD");
		String birth = birthY+birthM+birthD;
		
		//email 받기
//		String email_1 = request.getParameter("email_1"); //아이디
//		String email_2 = request.getParameter("email_2"); //직접입력시 이메일주소칸
//		String email = email_1 + "@" + email_2;
		String email = request.getParameter("naverEmail");
		
		//전화번호 합치기
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + phone2 + phone3; 
		
		//도로명주소 합치기
		String zipNo = request.getParameter("zipNo");
		String roadAddrPart1 = request.getParameter("roadAddrPart1");
		String roadAddrPart2 = request.getParameter("roadAddrPart2");
		String addrDetail = request.getParameter("addrDetail");
		
		String address = zipNo+"/"+roadAddrPart1+"/"+roadAddrPart2+"/"+addrDetail;
		
		int pwquery = 0;
		String pwqans = "불필요정보";
		String trustStr = request.getParameter("trust");
		char trust = trustStr.charAt(0);
		int turstmeans = Integer.parseInt(request.getParameter("turstmeans")==null? "0" : request.getParameter("turstmeans"));
		
		//돌봄 방식/위탁환경 중복 선택 name="trustfield"로 총9가지 항목
		String[] trustfieldArr = request.getParameterValues("trustfield");
		String trustfield = null;
		if(trustfieldArr != null) {
			trustfield = String.join(", ", trustfieldArr);
		}
		String trustAdd = request.getParameter("trustAdd");
		
		//회원가입시 받아오는 항목 전체
		Member member = new Member(memberid, nickname, membername, password, gender, birth,
									email, phone, address, pwquery, 
									pwqans, trust, turstmeans, trustfield, trustAdd);
		
		System.out.println(member);
		
		int result = new MemberService().insertMember(member);
		
		String page = "";
		String msg = "";
		
		if(result > 0) {
			page="login.mem";
			Member m = new Member(memberid, password);
			Member loginUser = new MemberService().loginMember(m);
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				session.setMaxInactiveInterval(600);
				response.sendRedirect("views/main/main.jsp");
			} else {
				page= "views/common/errorPage.jsp";	
				msg= "로그인에 실패헀습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher view = request.getRequestDispatcher(page);
				view.forward(request, response);
			}
		} else {
			page= "views/common/errorPage.jsp";	
			msg= "회원가입에 실패했습니다..";
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher(page);
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
