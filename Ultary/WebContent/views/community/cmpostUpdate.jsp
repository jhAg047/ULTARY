<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*, java.util.ArrayList"%>
<%
	String title = (String)request.getAttribute("title");
	String content = (String)request.getAttribute("content");
	int range = (int)request.getAttribute("range");
	int pno = (int)request.getAttribute("pno");
	ArrayList<Media> mlist = (ArrayList<Media>)request.getAttribute("mlist");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common/완성본틀.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/community/cmpostWrite.css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="script.js"></script>
<body>
	<div id="all">
		<div id="all-wrap">
			<%@ include file ="/views/common/commonheader.jsp" %>
			<%@ include file ="/views/common/cm_nav.jsp" %>
			<div id="asidesection">
			<%@ include file ="/views/common/cm_aside.jsp" %>
				<section>
					<form action="<%= request.getContextPath() %>/cmUpdate.po" method="post" encType="multipart/form-data">
					<div id="sectiondiv1">
						<div id="sTop">게시글 수정</div>
						<hr>
						<div id="sTitle">
							<label>Title : </label>
							<input type="hidden" name="pno" value="<%= pno%>">
							<input type="text" name="title"value="<%= title %>">
							<select name="postRange">
								<option value="1" selected>전체공개</option>
								<option value="2">내관심회원만</option>
								<option value="3">나만보기</option>
							</select>
						</div>
						<hr>
						<div id="sContent">
							<label>Content : </label><br>
							<textarea name="postContent"><%= content %></textarea>
						</div>
						<hr>
						<div id="sAdd">
							<label>카테고리 설정&nbsp;&nbsp;| </label>
							<select name="categorynum" id="categorynum">
								<option value="2" selected>펫일상</option>
								<option value="3">펫지식</option>
								<option value="4">펫리뷰</option>
								<option value="5">펫분양</option>
							</select>
						</div>
						<hr>
						<div id="sMedia">
							<div class="sMedia" id="media1">
								<img id="mediaImg1" width="100%" height="100%">
							</div>
							<div class="sMediaL"></div>
							<div class="sMedia" id="media2">
								<img id="mediaImg2" width="100%" height="100%">
							</div>
							<div class="sMediaL"></div>
							<div class="sMedia" id="media3">
								<img id="mediaImg3" width="100%" height="100%">
							</div>
							<div class="sMediaL"></div>
							<div class="sMedia" id="media4">
								<img id="mediaImg4" width="100%" height="100%">
							</div>
							<% if(!mlist.isEmpty()) { %>
								<% for(int i = 0; i<mlist.size();i++){ 
									Media m = mlist.get(i); %>
									<input type="hidden" name="medianum<%= i %>" value="<%= m.getMediaNum() %>">
								<% } %>
							<% } %>
						</div>
						<hr>
						<div id="sSubmit">
							<input type="submit" value="Complete">
						</div>
						<div id="fileArea">
							<input type="file" id="Img1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)">
							<input type="file" id="Img2" multiple="multiple" name="thumbnailImg2" onchange="LoadImg(this,2)">
							<input type="file" id="Img3" multiple="multiple" name="thumbnailImg3" onchange="LoadImg(this,3)">
							<input type="file" id="Img4" multiple="multiple" name="thumbnailImg4" onchange="LoadImg(this,4)">
						</div>
					</div>
<script>
	$(function(){
		/* 사진 넣어주기 */
		<% if(!mlist.isEmpty()) { %>
			<% for(int i = 0; i<mlist.size();i++){ 
				Media m = mlist.get(i); %>
				var media = "#mediaImg"+(<%= i %>+1);
				var img = "#Img"+(<%= i %>+1);
				$(media).attr("src", "<%=request.getContextPath() %>/uploadFiles/<%= m.getWebName() %>");
			<% } %>
		<% } %>
		
		$("#fileArea").hide();
		
		$("#media1").click(function(){
			$("#Img1").click();
		});
		$("#media2").click(function(){
			$("#Img2").click();
		});
		$("#media3").click(function(){
			$("#Img3").click();
		});
		$("#media4").click(function(){
			$("#Img4").click();
		});
		
	});
	function LoadImg(value, num){
		if(value.files && value.files[0]){
			var reader = new FileReader();
							
			reader.onload = function(e){								
				switch(num){
				case 1: 
					$("#mediaImg1").attr("src", e.target.result);
					break;
				case 2:
					$("#mediaImg2").attr("src", e.target.result);
					break;
				case 3: 
					$("#mediaImg3").attr("src", e.target.result);
					break;
				case 4:
					$("#mediaImg4").attr("src", e.target.result);
					break;
				}
			}
							
			reader.readAsDataURL(value.files[0]);
		}
	}
	$('#complete').click(function check(){
		if($('#title').val() == ""){
			alert('제목을 입력해주세요');
			$('#title').focus();
			return false;
		} else if($('#postContent').val() ==""){
			alert('내용을 입력해주세요');
			$('#postContent').focus();
			return false;
		}
		return true;
	});
</script>
				</form>
				
				</section>
			</div>
			<footer>from.hoseong</footer>
		</div>
	</div>
</body>
</html>