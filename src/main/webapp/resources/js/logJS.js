/**
 * Created by LYH on 2017/3/6.
 */
var logJS={

    URL:{

        logs:function () {
            return "/Blog/logs";
        },

        publishUI:function () {
            return "/Blog/log/publish";
        },

        deleteUrl:function (lid) {
            return "/Blog/log/"+lid;
        }
    },

    publish:function () {
        $("#sbutton").click(function () {
            var title = $("#title").val();
            console.log(title);
            //带格式的内容,即含html格式
            var contentWithFormat = UM.getEditor("myEditor").getContent();
            //纯文本,这里应该调用函数的,但是应该调用getContentTxt()方法，不过找不到这个函数
            var contentText = UM.getEditor("myEditor");
            console.log(contentWithFormat);
            $("#content").val(contentWithFormat);
            $("#lgp").submit();
            //异步提交不会刷新页面
            //$.post(logJS.URL.publishURL(),{title:title,content:content});
            /*
            $.ajax({
                type:"POST",
                async:false,
                url:logJS.URL.publishURL(),
                data:{
                    title:title,
                    content:content
                }
            });
            */
        });
    },

    publishUI:function () {
        $("#pubLog").click(function () {
            location.href=logJS.URL.publishUI();
        });
    },
    
    del:function (lid) {
        $("#delLgBtn").click(function () {
            //console.log(lid);
            $.ajax({
                type:'DELETE',
                url:logJS.URL.deleteUrl(lid),
                data:{"lid":lid},
                success:function () {
                    location.href = logJS.URL.logs();
                }
            });

        });
    }
};