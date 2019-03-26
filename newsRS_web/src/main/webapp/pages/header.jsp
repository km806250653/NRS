<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="referrer" content="never">
    <script src="../js/jquery-3.3.1.min.js"/>
    <script></script>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script>
        $(function () {
            $(".header").css("z-index","999");
            $(".header").css("width","100%");
            $(window).scroll(function () {
                if($(window).scrollTop()>74){
                    $(".header").css("position","fixed");
                    $(".header__top").css("display","none");
                }else {
                    $(".header").css("position","relative");
                    $(".header__top").css("display","");
                }
            });
            path = getAbsolutePath(); //全局变量  http://ip:port/newsRS_web/
            //设置主页按钮路径
            $("#home a").prop("href",path+"index.jsp");
            $.get(path+"category/findAll","",function (list) {
                for (var i = 0; i <list.length ; i++) {
                    if(i>6){             //超过六个时，多余的放入下拉框中
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
    </script>
</head>
<body>
<header id="header" class="header">
    <div class="header__top" id="header-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="wrap-logo">
                        <a href="index.jsp" class="logo"></a>
                    </div>
                </div>
                <div class="col-sm-offset-2 col-md-offset-5 col-sm-6 col-md-4 hidden-xs">
                    <div class="col-xs-4 col-sm-5">
                        <div class="weather">
                            <div class="weather__temperature">
                                <span class="icon-sun"></span>
                                <em class="active">+8 C</em>
                                <em>+2 C</em>
                                <em>+3 C</em>
                            </div>
                            <div class="weather__city">
                                <em>London</em>
                                <div class="weather__city__list">
                                    <ul>
                                        <li class="active">
                                            <a href="#">London</a>
                                        </li>
                                        <li>
                                            <a href="#">Moscow</a>
                                        </li>
                                        <li>
                                            <a href="#">Kiev</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-7">
                        <div class="exchange">
                            <p class="exchange__name">Central Bank Rate</p>
                            <p class="exchange__course">
                                $<span>32.32</span>&#8364;<span>28.23</span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="header_down" id="header-down">
        <div class="container">
            <div class="wrapper clearfix bigmegamenu">
                <!--Main Menu HTML Code-->
                <nav class="wsmenu slideLeft clearfix">
                    <ul id="" class="mobile-sub wsmenu-list">
                        <li id="home" class="active">
                            <span class="wsmenu-click"></span>
                            <a href="index.jsp">主页</a>
                        </li>

                        <li id="more">
                            <span class="wsmenu-click"></span>
                            <a href="">更多
                                <span class="arrow"></span>
                            </a>
                            <ul class="wsmenu-submenu" id="more_ul">
                            </ul>
                        </li>
                        <li class="navbar-right hidden-xs">
                            <form class="navbar-form" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="搜索">
                                </div>
                                <button type="submit" class="btn btn-search">
                                    <i class="icon-search"></i>
                                    <br/>搜索
                                </button>
                            </form>
                        </li>
                    </ul>
                </nav>
                <!--Menu HTML Code-->
            </div>
        </div>
    </div>
</header>
</body>
</html>

