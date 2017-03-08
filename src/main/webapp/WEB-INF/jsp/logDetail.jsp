<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/7
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>日志详细</title>
</head>
<body>
    <div class="container">
        <%@include file="head.jsp"%>
        <div class="row">
            <div class="col-md-3">
                <%@include file="navigate.jsp"%>
            </div>
            <div class="col-md-9">
               <div class="panel panel-default">
                   <div class="panel-heading">
                       <h1 class="panel-title">${log.title}</h1>
                       <div class="btn-group-sm" role="group" aria-label="...">
                           <button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove-sign">删除</span></button>
                       </div>
                   </div>
                   <div class="panel-body">
                        <my:ByteToString content="${log.content}"></my:ByteToString>
                   </div>
               </div>
            </div>
        </div>
    </div>

</body>
</html>
