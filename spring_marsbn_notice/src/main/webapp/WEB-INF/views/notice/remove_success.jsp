<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("${param.pno}공지가 삭제되었습니다.");
    window.location.href = 'list.do';
	window.opener.location.reload();

</script>