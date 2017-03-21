<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/2
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/resources/css/page.css">
    <script type="text/javascript" src="${ctx}/resources/js/logJS.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/pageBeanJS.js"></script>
    <script>
        $(function () {
            logJS.publishUI();
            $("#pageDiv").hide();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-2 col-md-offset-10">
        <c:choose>
            <c:when test="${currentUser.innerId == user.innerId}">
                <button id="pubLog" type="button" class="btn btn-primary">写新文章</button>
            </c:when>
        </c:choose>
    </div>
</div>
<c:forEach var="log" items="${logList}">
    <c:choose>
        <c:when test="${empty log.lid}">
            <c:if test="${currentUser.innerId == user.innerId}"><h1>你还未发表任何文章哟~</h1></c:if>
            <c:if test="${currentUser.innerId != user.innerId}"><h1>他(她)还未发表任何文章哟~</h1></c:if>
        </c:when>
        <c:otherwise>
            <div class="jumbotron">
                <h2>${log.title}</h2>
                <p><my:ByteToString summary="${log.content}"/>...</p>
                <p><a class="btn btn-primary btn-lg" href="${ctx}/log/${log.lid}" role="button">Read more</a></p>
            </div>
            <script>
                $(function () {
                    $("#pageDiv").show();
                })
            </script>
        </c:otherwise>
    </c:choose>
</c:forEach>
<div id="pageDiv" class="row">
    <form id="pageForm" method="get" action="${ctx}/user/${user.innerId}/logs">
        <input type="hidden" name="page" id="currentPage"/>
        <div class='page fix col-md-10 col-md-offset-1'>
            共 <b>${pageBean.totalCount}</b> 条
            <c:if test="${pageBean.currentPage != 1}">
                <a href="javascript:pageBeanJS.changeCurrentPage(1)" class='first'>首页</a>
                <a href="javascript:pageBeanJS.changeCurrentPage(${pageBean.currentPage-1})" class='pre'>上一页</a>
            </c:if>
            当前第<span>${pageBean.currentPage}/${pageBean.totalPage}</span>页
            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                <a href="javascript:pageBeanJS.changeCurrentPage(${pageBean.currentPage+1})" class='next'>下一页</a>
                <a href="javascript:pageBeanJS.changeCurrentPage(${pageBean.totalPage})" class='last'>末页</a>
            </c:if>
            跳至&nbsp;<input id="currentPageText" type='text' value='1' class='allInput w28'/>&nbsp;页&nbsp;
            <a href="javascript:pageBeanJS.changeCurrentPage($('#currentPageText').val())" class='go'>GO</a>
        </div>
    </form>
</div>
</body>
</html>
