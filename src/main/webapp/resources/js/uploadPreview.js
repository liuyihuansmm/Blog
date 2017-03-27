/**
 * 模仿的网上的方法
 * @param setting
 */

var uploadPreview = function (setting) {

    var _self = this;

    //判断是否为空的函数
    isNull = function(value){
        if(typeof(value) == "function")
            return false;
        if(value == undefined || value == null || value ==""||value.length == 0)
            return true;
        return false;
    }

    //默认配置
    _self.DefaultSetting = {
        UpBtn:"",
        DivShow:"",
        ImgShow:"",
        Width:100,
        Height:100,
        ImgType:["gif", "jpeg", "jpg", "bmp", "png"],
        ErrMsg:"选择文件错误,图片类型必须是(gif,jpeg,jpg,bmp,png)中的一种",
        callback:function () {
            
        }
    }

    _self.Setting={
        UpBtn : isNull(setting.UpBtn)?_self.DefaultSetting.UpBtn:setting.UpBtn,
        DivShow:isNull(setting.DivShow)?_self.DefaultSetting.DivShow:setting.DivShow,
        ImgShow:isNull(setting.ImgShow)?_self.DefaultSetting.ImgShow:setting.ImgShow,
        Width:isNull(setting.Width)?_self.DefaultSetting.Width:setting.Width,
        Height:isNull(setting.Height)?_self.DefaultSetting.Height:setting.Height,
        ImgType:isNull(setting.ImgType)?_self.DefaultSetting.ImgType:setting.ImgType,
        ErrMsg:isNull(setting.ErrMsg)?_self.DefaultSetting.ErrMsg:setting.ErrMsg,
        callback:isNull(setting.callback)?_self.DefaultSetting.callback:setting.callback
    }
    
    //关键的一步，获取本地图片的URL
    getObjectURL = function (file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    
    bind = function () {
        document.getElementById(_self.Setting.UpBtn).onchange = function () {
            if(this.value){
                //判断选中文件是否满足 ImgType:["gif", "jpeg", "jpg", "bmp", "png"],
                if(!RegExp("\.("+_self.Setting.ImgType.join("|")+")$","i").test(this.value.toLowerCase())){
                    alert(_self.Setting.ErrMsg);
                    document.getElementById(_self.Setting.ImgShow).src="";
                    this.value="";
                    return false;
                }
                //IE浏览器怎么做
                if(navigator.userAgent.indexOf("MSIE") > -1){
                    try {
                        document.getElementById(_self.Setting.ImgShow).src = getObjectURL(this.files[0]);
                    } catch (e) {
                        var div = document.getElementById(_self.Setting.DivShow);
                        this.select();
                        top.parent.document.body.focus();
                        var src = document.selection.createRange().text;
                        document.selection.empty();
                        document.getElementById(_self.Setting.ImgShow).style.display = "none";
                        div.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        div.style.width = _self.Setting.Width + "px";
                        div.style.height = _self.Setting.Height + "px";
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                }
                else {
                    document.getElementById(_self.Setting.ImgShow).src = getObjectURL(this.files[0]);
                }
                _self.Setting.callback();//不明白
            }
        }
    }

    bind();
}