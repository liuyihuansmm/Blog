﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>博客系统</title>
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
                <a class="navbar-brand" href="#">Blog</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页
                        <span class="sr-only">(current)</span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-th" aria-hidden="true"></span>日志</a></li>
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
                            <li><a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span>安全退出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索好友">
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"
                                                                        aria-hidden="true"></span>搜索
                    </button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </div>
</nav>

<div class="container">
    <div class="blog-header">
        <h1 class="blog-title">刘一寰的博客</h1>
        <p class="lead blog-description">Stay hungry,Stay foolish</p>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">个人资料</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12 col-xs-12">
                            <a href="#" class="thumbnail">
                                <img src="http://c.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=6a9e2665d42a283443f33e0f6e85e5dc/b151f8198618367ad07349a52e738bd4b21ce5cb.jpg" alt="...">
                            </a>
                        </div>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="label label-default">昵称</span>&nbsp;&nbsp;孙孙小二梅
                        </li>
                        <li class="list-group-item">
                            <span class="label label-default">邮箱</span>&nbsp;&nbsp;smm@163.com
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

        </div>
        <div class="col-md-9">
            <div class="jumbotron">
                <h1>我的老丈银</h1>
                <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
                    featured content or information.</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Read more</a></p>
            </div>
            <div class="jumbotron">
                <h1>Hadoop集成策略</h1>
                <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
                    featured content or information.</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Read more</a></p>
            </div>
        </div>
    </div>

</div>
</body>