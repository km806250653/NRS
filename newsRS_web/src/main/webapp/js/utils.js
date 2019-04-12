$(function () {
    $(".header").css("z-index", "999");
    $(".header").css("width", "100%");
    $(window).scroll(function () {
        if ($(window).scrollTop() > 74) {
            $(".header").css("position", "fixed");
            $(".header__top").css("display", "none");
        } else {
            $(".header").css("position", "relative");
            $(".header__top").css("display", "");
        }
    });
    path = getAbsolutePath(); //全局变量  http://ip:port/newsRS_web/
});
function getAbsolutePath() {
    var pathname = location.pathname; //newsRS_web/pages/news_list.jsp
    // alert("pathname:"+pathname);
    pathname = pathname.substring(1); // newsRS_web/pages/news_list.jsp
    // alert("pathname截掉第一个/:"+pathname);
    pathname = pathname.substring(0, pathname.indexOf("/") + 1); // newsRS_web/
    // alert("pathname项目名:"+pathname);
    var href = location.href; //http://localhost:8080/newsRS_web/pages/news_list.jsp
    // alert(href);
    href = href.substring(0, href.indexOf(pathname) + pathname.length); // http://localhost:8080/newsRS_web/
    // alert(href);
    return href;
}