/**
 * Created by lyh on 17-3-15.
 */
var userJS={

    URL:{
      searchFriend:function (parm) {
          return "/Blog/users?nickname="+parm;
      }
    },

    createXMLHTTP:function () {
        var xmlHttp;
        if(window.XMLHttpRequest){
            xmlHttp = new XMLHttpRequest();
        }
        if(window.ActiveXObject){
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            if(!xmlHttp){
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            }
        }
        return xmlHttp;
    },

    getResult:function () {
        var nickname = document.getElementById("nickname");
        if(nickname.value == "" ){
            userJS.clearContent();
        }
        var xmlHttp = userJS.createXMLHTTP();
        var url = userJS.URL.searchFriend(nickname.value);
        url = encodeURI(url);
        url = encodeURI(url);
        xmlHttp.open('GET',url,true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState==4){
                if(xmlHttp.status == 200){
                    var result = xmlHttp.responseText;
                    var json = eval("("+result+")");
                    userJS.setContent(json);
                }
            }
        }
        xmlHttp.send();
    },

    setContent:function (content) {
        userJS.clearContent();
        userJS.setLocation();

        var size = content.length;
        for(var i=0; i<size; i++){
            var textNode = content[i];

            var tr = document.createElement("tr");
            var td = document.createElement("td");
            td.onclick=function () {
                document.getElementById("nickname").innerHTML = td.innerHTML;
            };
            var text = document.createTextNode(textNode);
            td.appendChild(text);
            tr.appendChild(td);
            document.getElementById("name_table_body").appendChild(tr);
        }
    },

    serch:function () {
        
    },

    setLocation:function () {
        var nickname = document.getElementById("nickname");
        var width = nickname.offsetWidth;
        var left = nickname["offsetLeft"];
        var top = nickname["offsetTop"];

        var popDiv = document.getElementById("popDiv");
        popDiv.style.boder="black 1px solid";
        popDiv.style.left=left+"px";
        popDiv.style.top=top+"px";
        popDiv.style.width=width+"px";

        document.getElementById("name_table").style.width=width+"px";
    },

    clearContent:function () {
        var tbody = document.getElementById("name_table_body");
        var size = tbody.childNodes.length;
        if(size>0){
            for(var i=size-1;i>=0;i--){
                tbody.removeChild(tbody.childNodes[i]);
            }
        }
    }
}