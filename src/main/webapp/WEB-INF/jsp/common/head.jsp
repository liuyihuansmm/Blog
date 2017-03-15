<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017/3/2
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>博客系统</title>
    <script type="text/javascript" src="${ctx}/resources/js/userJS.js"></script>
    <style type="text/css">
        .mouseOver {
            background: #708090;
            color: #FFFAFA;
        }
        .mouseOut {
            background: #FFFAFA;
            color: #000000;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${ctx}/user/${currentUser.innerId}">Blog</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${ctx}/user/${user.innerId}"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页
                        <span class="sr-only">(current)</span></a></li>
                    <li><a href="${ctx}/user/${user.innerId}/logs"><span class="glyphicon glyphicon-th" aria-hidden="true"></span>日志</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>说说</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-picture " aria-hidden="true"></span>相册</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><span class="glyphicon glyphicon-cog"></span>设置 <span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>基础信息</a>
                            </li>
                            <li><a href="#"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>好友列表</a>
                            </li>
                            <li><a href="#"><span class="glyphicon glyphicon-earphone"
                                                  aria-hidden="true"></span>联系方式</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${ctx}/login"><span class="glyphicon glyphicon-off" aria-hidden="true"></span>安全退出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" name="nickname" id="nickname" placeholder="搜索好友" onkeyup="userJS.getResult()" onfocus="userJS.getResult()" onblur="userJS.clearContent()" />
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"
                                                                        aria-hidden="true"></span>搜索
                    </button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </div>
</nav>
<div id="popDiv" class="left-container">
    <table id="name_table" class="table table-hover">
        <tbody id="name_table_body">

        </tbody>
    </table>
</div>
<div class="blog-header">
    <h1 class="blog-title">${user.nickName}的博客</h1>
    <p class="lead blog-description">Stay hungry,Stay foolish</p>
    <hr>
</div>
</body>
</html>