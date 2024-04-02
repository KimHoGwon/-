<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/module/header.jsp" %>
<div class="wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>공지사항</h1>
                </div>              
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>공지사항</a></li>
                  
                    </ol>
                </div>
            </div>           
        </div>
    </section>
    <section class="content container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card card-outline card-primary">
                    <div class="card-header">
                        <h3>공지사항 수정</h3>
                    </div>
                    <div class="card-body">
                        <form role="form" method="post" action="modify.do" name="modifyForm">
                            <input type="hidden" name="n_number" value="${notice.n_number }" />
                            
                            <div class="form-group">
                                <label for="n_writer">작성자</label> 
                                <input type="text" id="n_writer" readonly name="n_writer" class="form-control" value="${notice.n_writer }">
                            </div>
                            <div class="form-group">
                                <label for="n_title">제 목</label> 
                                <input type="text" id="n_title" value="${notice.n_title }" name='n_title' class="form-control" placeholder="제목을 쓰세요">
                            </div>
                            <div class="form-group">
                                <label for="n_content">내 용</label>
                                <textarea id="n_content" class="form-control" rows="5" name="n_content">${notice.n_content}</textarea>
                            </div>
  
                        </form>
                    </div>
                    <div class="card-footer">
                        <button type="button" class="btn btn-warning" id="modifyBtn" onclick="modify_submit();">수 정</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn" id="cancelBtn" onclick="history.go(-1);">취 소</button>
                    </div>
                </div>              
            </div>
        </div>
    </section>
</div>

<%@ include file="/WEB-INF/views/module/common_js.jsp" %>

<script>
function modify_submit(){
	
	
    let form = $('form[name="modifyForm"]');
    
    // 유효성 체크
    if($("input[name='title']").val()==""){
        alert("제목은 필수입니다.");
        $("input[name='title']").focus();
        return;
    }
    
    
    form.submit();
}

</script>

<%@ include file="/WEB-INF/views/module/footer.jsp" %>