<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/7
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>日志详细</title>
</head>
<body>
<div class="container">
    <%@include file="head.jsp" %>
    <div class="row">
        <div class="col-md-3">
            <%@include file="navigate.jsp" %>
        </div>
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 style="display: inline;">${log.title}</h3>
                    <p class="text-right" style="margin-bottom:1px;">
                        <fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
                        <button id="delLgBtn" class="btn btn-default btn-sm"><span
                                class="glyphicon glyphicon-remove-sign">删除</span></button>
                        <button id="comLgBtn" class="btn btn-default btn-sm"><span
                                class="glyphicon glyphicon-comment">评论</span>
                        </button>
                    </p>
                </div>
                <div class="panel-body">
                    <my:ByteToString content="${log.content}"></my:ByteToString>
                </div>
                <div class="panel-footer">
                    <p class="panel-heading">查看评论</p>
                    <c:forEach var="comment" items="${commentList}">
                        <c:if test="${not empty comment.fromWho}">
                            <div class="panel panel-default">
                                <p class="panel-heading">
                                        ${comment.fromWho.nickName}&nbsp;
                                    <fmt:formatDate value="${comment.createTime}"
                                                    pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>&nbsp;发表
                                </p>
                                <p class="panel-body">${comment.content}</p>
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="panel panel-default">
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;发表评论</p>
                        <div class="panel-body">
                            <form action="${ctx}/log/${log.lid}/comments" method="post">
                                <input type="hidden" name="fromid" value="${currentUser.uid}">
                                <input type="hidden" name="toid" value="${log.owner.uid}">
                                <input type="hidden" name="lid" value="${log.lid}">
                                <textarea name="content" class="col-md-12">

                                </textarea>
                                <button id="subComment" type="submit" class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-arrow-up">提交</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/resources/js/logJS.js"></script>
<script>
    $(function () {
        logJS.del(${log.lid});
    });
</script>
</body>
</html>
