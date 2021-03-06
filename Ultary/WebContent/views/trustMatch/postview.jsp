<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*,trust.model.vo.*,java.util.*"%>
<%
	Member m = (Member)request.getAttribute("m");
	TrustPost tp = (TrustPost)request.getAttribute("tp");
	Media proImg = (Media)request.getAttribute("proImg");
	Pet pet = (Pet)request.getAttribute("pet");
	Media media = (Media)request.getAttribute("Media");
	int petnum =(int)request.getAttribute("petnum");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티용</title>
</head>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common/완성본틀.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="script.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/trust/matching03.css">
<body>
	<div id="all">
		<div id="all-wrap">
			<%@ include file ="/views/common/commonheader.jsp" %>
			<%@ include file ="/views/common/tr_nav.jsp" %>
			<div id="asidesection">
			<%@ include file ="/views/common/tr_aside.jsp" %>
				<section>
				
				
					<div>
            <form action="<%=request.getContextPath()%>/Tpostsend.tu">
            <div id="matching">
				<h1 id="title">의뢰관리</h1>
				<p id="title-1">위탁 내용 상세보기와 진행사항을 보여드립니다.</p>
					<hr style="margin-left:10px;">
				<br clear="all">
				</div>
			<div id="page">
				<div id="page1">
					<div id="page2">
						<div id="page2-1">
						 <%if(proImg == null){ %>
						 	<img src="<%= request.getContextPath() %>/image/프로필.png" id="userphoto" class="profile-photo">
						 <%} else{ %>
						 	<img src="<%= request.getContextPath() %>/uploadFiles/<%=proImg.getWebName() %>" id="userphoto" class="profile-photo">
						 <%} %>
							<h3 id="nick1"><%=m.getNickname() %><input type="hidden" name = "memberid" value="<%=m.getMemberId()%>"></h3>
						</div>
						<div id="page2-2">
							<h3 id="pcoment">님 에게 위탁 요청</h3>
						</div>
					</div>
					<div id= "page3">
						<div id="page3-1">
							<h3 style="text-align: center;">반려동물 정보</h3>
						</div>
						<div id="page3-2">
				<%if(pet == null) {%>
					<table id="page3_table">
						<th>pet을 불러오는데 실패했습니다.</th>
					</table>
				<%} else{ %>
							<table id="page3_table">
								<tr>
									<td class="page3_td"><div class="petname">반려동물 이름</div></td>
									<td><label><%=pet.getPetName() %></label><input type="hidden" name="petnum" value="<%=pet.getPetNum()%>"></td>
									
								</tr>
								<tr>
									<td class="page3_td"><div class="petname">반려동물 종류</div></td>
									<td><label><%=pet.getPetKind() %></label></td>
								</tr>
								<tr>
									<td class="page3_td"><div class="petname">성별</div></td>
									<td><label><%=pet.getPetGender() %></label></td>
								</tr>
								<tr>
									<td class="page3_td"><div class="petname">반려동물 나이</div></td>
									<td><label><%=pet.getPetage() %>살</label></td>
								</tr>
							</table>
						</div>
						<div id="page3-3">
						<%if(media == null){ %>
						 	<img src="<%= request.getContextPath() %>/image/프로필.png" id="pet-photo" class="pet-photo">
						 <%} else{ %>
						 	<img src="<%= request.getContextPath() %>/uploadFiles/<%=media.getWebName() %>" id="pet-photo" class="pet-photo">
						 <%} %>
						</div>
				<% }%>
					</div>
					<div id="page4">
						<table id="page4-in">
							<tr>
								<td class="page4-1-1">
									<div class="page4-1">거주지역</div>
								</td>
								<td colspan ="2">
									<label><%=m.getAddress() %></label>
								</td>
							</tr>
						
							<tr>
								<td class="page4-1-1">
									<div class="page4-1">돌봄기간</div>
								</td>
								<td>
									<label>시작날자</label><input type="text" readonly name="startDate" id="startDate" value="<%=tp.getTrustsDue()%>">
								</td>
								<td>
									<label>끝나는 날자</label><input type="text" name="endDate" id="endDate" value="<%=tp.getTrusteDue() %>" readonly>
								</td>
							</tr>
							<tr>
								<td class="page4-1-1">
									<div class="page4-1">위탁방식</div>
								</td>
								<td>
									<input type="text" value="<%=tp.getTrustMeans()%>" readonly>
								</td>
								<td>
								</td>
							</tr>
							<tr>
								<td class="page4-1-1">
									<div class="page4-1">비상연락처</div>
								</td>
								<td>
									<input type="text" name="tel" id="tel" value="<%=tp.getTrustPhone()%>" readonly>
								</td>
								<td>
								</td>
							</tr>
						</table>
					<div id="page5">
					<br><br>
						<div id="page5-title">
						<%=m.getNickname() %> 님에게 보내는 메세지
						</div>
						<textarea id="page5-textarea" cols="30" rows="30" name="trustAdd" readonly><%=tp.getTrustPS() %></textarea>
					</div>
						<input type="button" name="sub" id="sub" value="요청취소" onclick="location.href='<%=request.getContextPath()%>/updateTp.tu?tpnum=<%=tp.getTpostNum()%>'">
					</div>
				</div>
			</div>
            </form>

         </div>
				
				
				
				
				
				
				
				</section>
			</div>
			<footer></footer>
		</div>
	</div>
</body>
</html>