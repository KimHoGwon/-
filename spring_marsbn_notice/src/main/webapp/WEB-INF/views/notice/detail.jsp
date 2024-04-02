<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h3 class="card-title">상세보기</h3>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="n_title">제 목</label>
							<input type="text" class="form-control" id="n_title" 
								value="${notice.n_title }" readonly />							
						</div>	
						<div class="col-sm-12 row">
							<div class="form-group col-sm-4" >
								<label for="n_writer">작성자</label>
								<input type="text" class="form-control" id="n_writer" 
									 value="${notice.n_writer }" readonly />
							</div>		
							
							<div class="form-group col-sm-4" >
								<label for="n_date">작성일</label>
								<input type="text" class="form-control" id="n_date" 
									value="<fmt:formatDate value="${notice.n_date}" pattern="yyyy-MM-dd" />" readonly />
							</div>	
							<div class="form-group col-sm-4" >
								<label for="n_hit">조회수</label>
								<input type="text" class="form-control" id="n_hit" value="${notice.n_hit }" readonly />
							</div>	
						</div>	
							<div class="form-group col-sm-12">
							    <style>
							        .detail-content {
							            white-space: pre-wrap;
							        }
							    </style>
							    <label for="n_content">내 용</label>
							    <div class="detail-content">${notice.n_content }</div>	
							</div>
						
												
					</div>
					<div class="card-footer">
						
							<button type="button" id="modifyBtn" class="btn btn-warning" onclick="location.href='modifyForm?n_number=${notice.n_number}';">수정</button>						
					    	<button type="button" id="removeBtn" class="btn btn-danger" onclick="location.href='remove?n_number=${notice.n_number}';">삭제</button>
					   
					    <button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">취소 </button>
					</div>									
				</div>			
			</div>
		</div>	
		
    </section>
</div>





<%@ include file="/WEB-INF/views/module/common_js.jsp" %>

<script>

</script>


<%@ include file="/WEB-INF/views/module/footer.jsp" %>