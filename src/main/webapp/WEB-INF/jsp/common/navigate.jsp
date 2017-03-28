<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/2
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="panel panel-default">
        <div class="panel-heading">个人资料</div>
        <div class="panel-body">
            <div class="row">
                <div class="col-xs-12 col-xs-12">
                    <a href="${ctx}/user/${user.innerId}/picture" class="thumbnail">
                    <c:choose>
                        <c:when test="${user.headPicture == null}">

                                点此上传头像

                        </c:when>
                        <c:otherwise>
                                <img src="${ctx}/${user.headPicture}">
                        </c:otherwise>
                    </c:choose>
                    </a>
                </div>
            </div>
            <ul class="list-group">
                <li class="list-group-item">
                    <span class="label label-default">昵称</span>&nbsp;&nbsp;${user.nickName}
                </li>
                <li class="list-group-item">
                    <span class="label label-default">邮箱</span>&nbsp;&nbsp;${user.email}
                </li>
            </ul>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">文章存档</div>
        <div class="panel-body">
            <div class="list-group">
                <a href="#" class="list-group-item">
                    <span class="badge">14篇</span>
                    2017年1月
                </a>
                <a href="#" class="list-group-item"><span class="badge">30篇</span>
                    2017年2月</a>
                <a href="#" class="list-group-item"><span class="badge">1篇</span>
                    2017年3月</a>
            </div>
        </div>
    </div>
</body>
</html>
