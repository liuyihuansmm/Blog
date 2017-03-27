<%--
  Created by IntelliJ IDEA.
  User: LYH
  Date: 2017-3-27
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="tag.jsp" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/resources/js/uploadPreview.js" type="text/javascript"></script>
    <script>
        window.onload = function () {
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
</head>
<body>
<div class="container">
    <%@include file="head.jsp" %>
    <div class="row">
        <div id="imgdiv" class="col-xs-6 col-md-4 col-md-offset-4">
            <img id="imgShow" src="..." alt="... ">
        </div>

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form enctype="multipart/form-data" action="${ctx}/user/${user.innerId}/headPicture" method="post">
                <div class="form-inline form-group">
                    <label>请选择图片文件:</label>
                    <input id="up_img" type="file" name="picupload">
                </div>
                <br>
                <div class="form-group">
                    <input type="submit" value="上传" class="btn btn-default"/>
                    <input type="reset" value="取消" class="btn btn-default"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
