/**
 * Created by LYH on 2017/3/6.
 */
var logJS={

    URL:{
        publishUI:function () {
            return "/Blog/log/publish";
        }

    },

    publish:function () {
        $("#sbutton").click(function () {
            var title = $("#title").val();
            console.log(title);
            var content = UM.getEditor("myEditor").getContent();
            console.log(content);
            $("#content").val(content);
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
    }
};