$(function () {
    path = getAbsolutePath(); //全局变量  http://localhost:8080/newsRS_web/
    //设置主页按钮路径
    $("#home a").prop("href",path+"index.jsp");
    $.get(path+"category/findAll","",function (list) {
        for (var i = 0; i <list.length ; i++) {
            if(i>6){             //超过六个时，放入下拉框架
                li = '<li style="width: 100px">\n' +
                    '                                    <a style="text-align: center" href="'+path+'news/findByCid?cid='+list[i].id+'">'+list[i].name+'</a>\n' +
                    '                                </li>';
                $("#more_ul").append($(li));
            }
            else {
                li = '<li id="home" class="active">\n' +
                    '                            <span class="wsmenu-click"></span>\n' +
                    '                            <a href="'+path+'news/findByCid?cid='+list[i].id+'">'+list[i].name+'</a>\n' +
                    '                        </li>';
                $("#more").before($(li));
            }
        }
    });
});

function getAbsolutePath() {
    var pathname = location.pathname; //newsRS_web/pages/news_list.jsp
    // alert(pathname);
    pathname=pathname.substring(1); // newsRS_web/pages/news_list.jsp
    // alert(pathname);
    pathname=pathname.substring(0,pathname.indexOf("/")+1); //newsRS_web/
    // alert(pathname);
    var href = location.href; //http://localhost:8080/newsRS_web/pages/news_list.jsp
    // alert(href);
    href=href.substring(0,href.indexOf(pathname)+pathname.length); // http://localhost:8080/newsRS_web/
    // alert(href);
    return href;
}