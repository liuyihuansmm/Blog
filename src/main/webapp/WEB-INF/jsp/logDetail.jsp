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
                <div class="panel-footer">Panel footer</div>
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
