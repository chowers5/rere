<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	/* function check() {
		var title = document.frm.title.value;
		var userId = document.frm.userId.value;
		var content = document.frm.content.value;
		if (title.length > 0 && userId.length >0 && content.length != "") {
			return true;	
		} else {
			alert('제목이 없거나,\r\n작성자가 없거나,\r\n 내용이 없습니다!');
			return false;
		}
	} */
	function boardCheck() {
		if(document.frm.userId.value.length == 0){
			alert("작성자를 입력하세요");
			return false;
		}
		if(document.frm.password.value.length == 0){
			alert("비밀번호를 입력하세요");
			return false;
		}
		if(document.frm.title.value.length == 0){
			alert("제목을 입력하세요");
			return false;
		}
		return true;
	}
	function open_win(url,name){
		window.open(url, name, "width=800, height=500");
	}
	function passCheck() {
			if(document.frm.password.value.length == 0){
				alert('비밀번호를 입력하세요.');
				return false;
			}
			return true;
	}
		
</script>
</head>
<body>
	<h2>게시글 수정</h2>
	<form method="post" name="frm" action="community.do">
	<input type="hidden" name="command" value="community_update" />
	<input type="hidden" name="communityNum" value="${cboard1.communityNum }" />
	
		제목(*) : <input type="text" name="title" /> <br />
		작성자(*) : <input type="text" name="userid"  value="${cboard1.userid }"/> <br />
		내용(*) : <textarea rows="15" cols="70" name="content"></textarea> <br />
		
		<input type="submit" value="수정" onclick="return boardCheck()"/> 
		<input type="reset" value="다시작성" />
		<input type="button" value="목록으로" onclick="location.href='community.do?command=community_list';" />
	</form>
</body>
</html>