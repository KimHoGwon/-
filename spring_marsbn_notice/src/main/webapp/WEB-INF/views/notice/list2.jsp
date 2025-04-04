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

    
    <section class="content">
        <div class="card">
            <div class="card-header with-border">
               
                <div id="keyword" class="card-tools" style="width:450px;">  
           
                    <div class="input-group row">

                        <select class="form-control col-md-3" name="searchType" id="searchType">
                            <option value="t" ${pageMaker.searchType eq 't' ? 'selected':'' }>제 목</option>
                            <option value="w" ${pageMaker.searchType eq 'w' ? 'selected':'' }>작성자</option>
                            <option value="c" ${pageMaker.searchType eq 'c' ? 'selected':'' }>내 용</option>
                        </select>    
                                        
                        <input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${pageMaker.keyword }"/>
                        <span class="input-group-append">
                            <button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="search_list(1);">
                                <i class="fa fa-fw fa-search"></i>
                            </button>
                        </span>
                    </div>                      
		      </div>              
            </div>
            <div class="card-body">
                <table class="table table-bordered text-center">
                    <tr style="font-size:0.95em;">
                        <th style="width:10%;">번 호</th>
                        <th style="width:40%;">제 목</th>
                        <th style="width:15%;">작성자</th>
                        <th style="width:15%;">등록일</th>
                        <th style="width:10%;">조회수</th>
                    </tr>   
                    <c:if test="${empty noticeList}">
                        <tr>
                            <td colspan="6">해당내용이 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${noticeList}" var="notice">
					    <tr style='font-size:0.85em;'>
					        <td>${notice.n_number}</td>
					        <td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden;
					                             white-space: nowrap; text-overflow: ellipsis;">
					            <a href="detail.do?n_number=${notice.n_number}">
					                <span class="col-sm-12 ">${notice.n_title}</span>
					            </a>
					        </td>
					        <td>${notice.n_writer}</td> 
					        <td>
					            <fmt:formatDate value="${notice.n_date}" pattern="yyyy-MM-dd"/>
					        </td>
					        <td><span class="badge bg-green">${notice.n_hit}</span></td>
					    </tr>
					</c:forEach> 
                </table>
    		   </div>
            <div class="card-footer">
                <div style="display:${!empty noticeList ? 'visible':'none' };">
                    <%@ include file="/WEB-INF/views/module/pagination.jsp" %>
                </div>
            </div>
        </div>
    </section>
</div>    

<%@ include file="/WEB-INF/views/module/common_js.jsp" %>

<script>

</script>
<%@ include file="/WEB-INF/views/module/footer.jsp" %>