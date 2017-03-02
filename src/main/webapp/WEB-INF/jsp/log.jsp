<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/2
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp" %>
<%@ taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="log" items="${logList}">
    <c:choose>
        <c:when test="${empty log.lid}">
            <h1>你还未发表任何文章哟~</h1>
        </c:when>
        <c:otherwise>
            <div class="jumbotron">
                <h1>${log.title}</h1>
                <p>${log.content}</p>
                <!--<p><my:ByteToString content="${log.content}"/></p>-->
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Read more</a></p>
            </div>
        </c:otherwise>
    </c:choose>
</c:forEach>
</body>
</html>
