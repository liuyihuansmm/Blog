/**
 * Created by LYH on 2017-3-20.
 */

var pageBeanJS ={

    changeCurrentPage:function (currentPage) {
        /**
         * 神坑，赋值要用这个函数啊！！之前写的.value=currentPage花了一下午去查原因
         */
        $("#currentPage").val(currentPage);
        $("#pageForm").submit();
    }
}