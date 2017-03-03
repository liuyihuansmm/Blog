<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 17-2-27
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登陆</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <!-- Bootstrap core CSS
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.js"></script>-->


</head>
<body>
<div class="inner-bg">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2 text">
                <h1><strong>Welcome to Blog</strong></h1>
                <div class="description">
                    <p>
                        This is a free blog system,hope you enjoy it!
                    </p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3 form-box">
                <div class="form-top">
                    <div class="form-top-left">
                        <h3>登录到博客</h3>
                        <p>Enter your username and password to log on:</p>
                    </div>
                    <div class="form-top-right">
                        <image src="${ctx}/resources/images/login.png" alt="Welcome"/>
                    </div>
                </div>
                <div class="form-bottom">
                    <form class="login-form" action="${ctx}/user" method="post">
                        <div class="form-group">
                            <label class="sr-only" for="form-username">Username</label>
                            <input type="text" name="username" class="form-username form-control" id="form-username"
                                   placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="form-password">Password</label>
                            <input type="password" name="password" placeholder="Password..."
                                   class="form-password form-control" id="form-password">
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" id="form-remember">记住我
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success">登陆</button>
                            <button type="button" class="btn btn-success " data-toggle="modal" data-target="#myModal">
                                注册
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <form class="login-form" action="${ctx}/regist" method="post">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">用户注册</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="form-username">Username</label>
                                <input type="text" name="regusername" class="form-username form-control" id="reg-username"
                                       placeholder="Username">
                            </div>
                            <div class="form-group">
                                <label for="form-password">Password</label>
                                <input type="password" name="regpassword" placeholder="Password..."
                                       class="form-password form-control" id="reg-password">
                            </div>
                            <div class="form-group">
                                <label for="form-username">NickName</label>
                                <input type="text" name="regnickname" placeholder="NickName..."
                                       class="form-email form-control" id="reg-nickname">
                            </div>
                            <div class="form-group">
                                <label for="form-username">Email</label>
                                <input type="email" name="regemail" placeholder="Email..."
                                       class="form-email form-control" id="reg-email">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">注册</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!--
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">用户注册</h4>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">注册</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
        -->
    </div>
</div>
</body>
</html>
