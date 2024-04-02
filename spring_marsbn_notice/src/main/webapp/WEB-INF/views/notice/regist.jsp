<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
                        <li class="breadcrumb-item active">공지사항등록</li>
                    </ol>
                </div>
            </div>
        </div>
    </section>

    <section class="content container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card card-outline card-info">
                    <div class="card-header">
                        <h4>글등록</h4>
                    </div>
                    <div class="card-body">
                        <form role="form" method="post" action="regist.do" name="registForm">
                            <div class="form-group">
                                <label for="n_writer">작성자</label>
                                <input type="text" id="n_writer" readonly name="n_writer" class="form-control" value="55">
                            </div>
                            <div class="form-group">
                                <label for="n_title">제 목</label>
                                <input type="text" id="n_title" name='n_title' class="form-control" placeholder="제목을 쓰세요">
                            </div>
                            <div class="form-group">
                                <label for="n_content">내 용</label>
                                <textarea class="form-control" name="n_content" id="n_content" rows="15" placeholder="공지사항을 입력하세요"></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer">
                        <button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn" id="cancelBtn" onclick="CloseWindow();">취 소</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="/WEB-INF/views/module/common_js.jsp" %>
<script>
function regist_go(){
    if($("input[name='n_title']").val()==""){
        alert("제목은 필수입니다.");
        $("input[name='n_title']").focus();
        return;
    }
    $("form[role='form']").submit();
}
</script>

<%@ include file="/WEB-INF/views/module/footer.jsp" %>