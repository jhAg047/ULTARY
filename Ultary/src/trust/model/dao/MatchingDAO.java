package trust.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;

import member.model.vo.Media;
import member.model.vo.Member;
import member.model.vo.Pet;
import trust.model.vo.TrustPost;
import trust.model.vo.TrustReview;

public class MatchingDAO {
	
	private Properties prop = new Properties();
	
	public MatchingDAO() {
		String fileName = MatchingDAO.class.getResource("/sql/matching/matching-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public int getListCount(Connection conn, Member member, String pet, String loginId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		
		String query = prop.getProperty("getListCount");
		
		StringTokenizer arr = new StringTokenizer(member.getTrustfield(), ",");
		String[] li =new String[6];
		
		for(int i=0;i<li.length;i++) {
			if(arr.hasMoreTokens()) {
				li[i]="%"+arr.nextToken()+"%";
			}else {
				li[i]="%%";
			}
		}
		System.out.println(member.getAddress());
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, li[0]);
			pstmt.setString(2, li[1]);
			pstmt.setString(3, li[2]);
			pstmt.setString(4, li[3]);
			pstmt.setString(5, li[4]);
			pstmt.setString(6, li[5]);
			pstmt.setInt(7,member.getTrustmeans());
			pstmt.setString(8,member.getAddress());
			pstmt.setString(9, loginId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	

	public ArrayList<Member> selectList(Connection conn, int currentPage, int memberLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list =null;
		
		String query =prop.getProperty("selectMatching");
		
		int startRow = (currentPage-1) *memberLimit +1;
		int endRow = startRow + memberLimit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<Member> serchList(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		String query = prop.getProperty("matchingSerch");
		StringTokenizer arr = new StringTokenizer(member.getTrustfield(), ",");
		String[] li =new String[6];
		
		for(int i=0;i<li.length;i++) {
			if(arr.hasMoreTokens()) {
				li[i]="%"+arr.nextToken()+"%";
			}else {
				li[i]="%%";
			}
		}
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, li[0]);
			pstmt.setString(2, li[1]);
			pstmt.setString(3, li[2]);
			pstmt.setString(4, li[3]);
			pstmt.setString(5, li[4]);
			pstmt.setString(6, li[5]);
			rset=pstmt.executeQuery();
			
			list=new ArrayList<Member>();

			while(rset.next()) {
				Member m = new Member(rset.getString("memberid"),
						  rset.getString("nickname"),
						  rset.getString("memberName"),
						  rset.getString("password"),
						  rset.getString("gender").charAt(0),
						  rset.getString("birth"),
						  rset.getString("email"),
						  rset.getString("phone"),
						  rset.getDate("enrolldate"),
						  rset.getString("address"),
						  rset.getInt("pwQuery"),
						  rset.getString("pwqAns"),
						  rset.getString("trust").charAt(0),
						  rset.getInt("trustmeans"),
						  rset.getString("trustField"),
						  rset.getString("trustAdd"),
						  rset.getInt("markscore"),
						  rset.getString("warn").charAt(0),
						  rset.getString("Status").charAt(0));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
	public ArrayList<Member> MemberList(Connection conn, int currentPage, Member member, int memberLimit, String pet) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list =null;
		
		String query =prop.getProperty("selectMatching");
		
		StringTokenizer arr = new StringTokenizer(member.getTrustfield(), ",");
		String[] li =new String[6];
		
		for(int i=0;i<li.length;i++) {
			if(arr.hasMoreTokens()) {
				li[i]="%"+arr.nextToken()+"%";
			}else {
				li[i]="%%";
			}
		}
		
		int startRow = (currentPage-1) *memberLimit +1;
		int endRow = startRow + memberLimit -1;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, li[0]);
			pstmt.setString(2, li[1]);
			pstmt.setString(3, li[2]);
			pstmt.setString(4, li[3]);
			pstmt.setString(5, li[4]);
			pstmt.setString(6, li[5]);
			pstmt.setInt(7, member.getTrustmeans());
			pstmt.setString(8,member.getAddress());
			pstmt.setString(9, member.getMemberId());
			pstmt.setInt(10, startRow);
			pstmt.setInt(11, endRow);
			
			rset=pstmt.executeQuery();
			list=new ArrayList<Member>();

			while(rset.next()) {
				String[] addressA = rset.getString("address").split("/");
				String address = addressA[addressA.length-1];
				
				Member m = new Member(rset.getString("memberid"),
						  rset.getString("nickname"),
						  rset.getString("memberName"),
						  rset.getString("password"),
						  rset.getString("gender").charAt(0),
						  rset.getString("birth"),
						  rset.getString("email"),
						  rset.getString("phone"),
						  rset.getDate("enrolldate"),
						  address,
						  rset.getInt("pwquery"),
						  rset.getString("pwqAns"),
						  rset.getString("trust").charAt(0),
						  rset.getInt("trustmeans"),
						  rset.getString("trustField"),
						  rset.getString("trustAdd"),
						  rset.getInt("markscore"),
						  rset.getString("warn").charAt(0),
						  rset.getString("Status").charAt(0));
				list.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Member DetailView(Connection conn, String memberid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query=prop.getProperty("detailView");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, memberid);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String[] addressA = rset.getString("address").split("/");
				String address = addressA[addressA.length-1];
			m = new Member(rset.getString("memberid"),
					  rset.getString("nickname"),
					  rset.getString("memberName"),
					  rset.getString("password"),
					  rset.getString("gender").charAt(0),
					  rset.getString("birth"),
					  rset.getString("email"),
					  rset.getString("phone"),
					  rset.getDate("enrolldate"),
					  address,
					  rset.getInt("pwQuery"),
					  rset.getString("pwqAns"),
					  rset.getString("trust").charAt(0),
					  rset.getInt("trustmeans"),
					  rset.getString("trustField"),
					  rset.getString("trustAdd"),
					  rset.getInt("markscore"),
					  rset.getString("warn").charAt(0),
					  rset.getString("Status").charAt(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return m;
	}

	public Pet DetailPet(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Pet pet = null;
		
		String query = prop.getProperty("DetailPet");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pet = new Pet( rset.getInt("petnum"),
								rset.getString("petname"),
								rset.getInt("petage"),
								rset.getString("petgender").charAt(0),
								rset.getString("petkind").charAt(0),
								rset.getString("memberId"));
			}
			System.out.println(pet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return pet;
	}

	public Member MemberDetail(Connection conn, String memberid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = prop.getProperty("memberDetail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberid);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String[] addressA = rset.getString("address").split("/");
				String address = addressA[addressA.length-1];
				m = new Member(rset.getString("memberid"),
						  rset.getString("nickname"),
						  rset.getString("memberName"),
						  rset.getString("password"),
						  rset.getString("gender").charAt(0),
						  rset.getString("birth"),
						  rset.getString("email"),
						  rset.getString("phone"),
						  rset.getDate("enrolldate"),
						  address,
						  rset.getInt("pwQuery"),
						  rset.getString("pwqAns"),
						  rset.getString("trust").charAt(0),
						  rset.getInt("trustmeans"),
						  rset.getString("trustField"),
						  rset.getString("trustAdd"),
						  rset.getInt("markscore"),
						  rset.getString("warn").charAt(0),
						  rset.getString("Status").charAt(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int sendTrustpost(Connection conn, TrustPost tp) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("sendTrust");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, tp.getTrustsDue());
			pstmt.setDate(2, tp.getTrusteDue());
			pstmt.setInt(3, tp.getTrustMeans());
			pstmt.setString(4, tp.getTrustPhone());
			pstmt.setString(5, tp.getTrustPS());
			pstmt.setString(6, tp.getSushin());
			pstmt.setString(7, tp.getBalshin());
			pstmt.setInt(8, tp.getPetnum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public ArrayList<TrustPost> MyBalshin(Connection conn, String loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TrustPost> tpArr = new ArrayList<TrustPost>();
		
		String query = prop.getProperty("myBalshin");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUser);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				TrustPost tp = new TrustPost(rset.getInt("tpostnum"),
											 rset.getDate("trustsdue"),
											 rset.getDate("trustedue"),
											 rset.getInt("trustmeans"),
											 rset.getString("trustphone"),
											 rset.getString("trustps"),
											 rset.getString("susin"),
											 rset.getString("balsin"),
											 rset.getInt("position"),
											 rset.getInt("petnum"),
											 rset.getInt("tr_num"));
				tpArr.add(tp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return tpArr;
	}

	public ArrayList<TrustPost> MySusin(Connection conn, String loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TrustPost> tpArr = new ArrayList<TrustPost>();
		
		String query = prop.getProperty("mysusin");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUser);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				TrustPost tp = new TrustPost(rset.getInt("tpostnum"),
											 rset.getDate("trustsdue"),
											 rset.getDate("trustedue"),
											 rset.getInt("trustmeans"),
											 rset.getString("trustphone"),
											 rset.getString("trustps"),
											 rset.getString("susin"),
											 rset.getString("balsin"),
											 rset.getInt("position"),
											 rset.getInt("petnum"),
											 rset.getInt("tr_num"));
				tpArr.add(tp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return tpArr;
	}

	public int changePosition(Connection conn, int position, int tpostNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changePosition");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, position);
			pstmt.setInt(2, tpostNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public TrustPost RwriteView(Connection conn, String user, String loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TrustPost tp = null;
		
		String query = prop.getProperty("RwriteView");
		
		
		return null;
	}

	public TrustPost serchtp(Connection conn, int tpostnum) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		TrustPost tp = null;
		
		String query = prop.getProperty("serchtp");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tpostnum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				tp = new TrustPost(rset.getInt("tpostnum"),
						 rset.getDate("trustsdue"),
						 rset.getDate("trustedue"),
						 rset.getInt("trustmeans"),
						 rset.getString("trustphone"),
						 rset.getString("trustps"),
						 rset.getString("susin"),
						 rset.getString("balsin"),
						 rset.getInt("position"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return tp;
	}
	public int review(Connection conn, TrustReview tr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query= prop.getProperty("review");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tr.getTrScore());
			pstmt.setString(2, tr.getTrContent());
			pstmt.setString(3, tr.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<TrustReview> trList(Connection conn, String loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TrustReview> trArr = new ArrayList<TrustReview>();
		
		String query = prop.getProperty("trList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUser);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				TrustReview tr = new TrustReview(rset.getInt("tr_num"),
												 rset.getInt("tr_score"),
												 rset.getString("tr_content"),
												 rset.getString("memberid"),
												 rset.getDate("tr_uploaddate"));
				
				trArr.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return trArr;
	}

	public TrustReview serchtr(Connection conn, int trnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TrustReview tr = null;
		
		String query = prop.getProperty("serchtr");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, trnum);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				tr = new TrustReview(rset.getInt("tr_num"),
									 rset.getInt("tr_score"),
									 rset.getString("tr_content"),
									 rset.getString("memberid"),
									 rset.getDate("tr_uploaddate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return tr;
	}
	
	public int updatetr(Connection conn, TrustReview tr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatetr");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tr.getTrContent());
			pstmt.setInt(2, tr.getTrScore());
			pstmt.setInt(3, tr.getTrNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int deletetr(Connection conn, int trnum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deletetr");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, trnum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int insertTpnum(Connection conn, int tpnum, int trnum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertTpnum");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, trnum);
			pstmt.setInt(2, tpnum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int gettrnum(Connection conn, String user) {
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		int trnum=0;
		
		String query = prop.getProperty("gettrnum");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				trnum=rset.getInt(1);
System.out.println(trnum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return trnum;
	}

	public ArrayList<TrustReview> trReview(Connection conn, String memberid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TrustReview> trList = new ArrayList<TrustReview>();
		
		String query= prop.getProperty("trReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				TrustReview tr = new TrustReview(rset.getInt("tr_num"),
												 rset.getInt("tr_score"),
												 rset.getString("tr_content"),
												 rset.getString("memberid"),
												 rset.getDate("tr_uploaddate"));
				trList.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return trList;
	}

	public TrustPost tpview(Connection conn, int tpnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TrustPost tp = null;
		
		String query = "select * from trustpost where TPOSTNUM = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tpnum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				tp = new TrustPost(rset.getInt("tpostnum"),
								   rset.getDate("trustsdue"),
								   rset.getDate("trustedue"),
								   rset.getInt("trustmeans"),
								   rset.getString("trustphone"),
								   rset.getString("trustps"),
								   rset.getString("susin"),
								   rset.getString("balsin"),
								   rset.getInt("position"),
								   rset.getInt("petnum"),
								   rset.getInt("tr_num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return tp;
	}

	public int deletetp(Connection conn, int tpnum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deletetp");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tpnum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Pet SerchPet(Connection conn, int petnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Pet p = null;
		
		String query = prop.getProperty("serchpet");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,petnum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Pet(rset.getInt("petnum"),
							rset.getString("petname"),
							rset.getInt("petage"),
							rset.getString("petgender").charAt(0),
							rset.getString("petkind").charAt(0),
							rset.getString("memberid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	public Media serchpetImg(Connection conn, int petnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Media m = null;
		
		String query = prop.getProperty("petImg");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, petnum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Media(rset.getInt("medianum"),
									rset.getString("imgroute"),
									rset.getString("imgname"),
									rset.getString("webname"),
									rset.getInt("mediause"),
									rset.getString("memberid"),
									rset.getInt("postnum"),
									rset.getInt("petnum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
				
		return m;
	}

	public ArrayList<Media> selectAllImg(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Media> all = new ArrayList<Media>();
		
		String query = prop.getProperty("selectAllImg");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Media m = new Media(rset.getInt("medianum"),
						rset.getString("imgroute"),
						rset.getString("imgname"),
						rset.getString("webname"),
						rset.getInt("mediause"),
						rset.getString("memberid"),
						rset.getInt("postnum"),
						rset.getInt("petnum"));
				
				all.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return all;
	}



}
