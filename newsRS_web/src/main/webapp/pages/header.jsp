<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
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
    });
</script>
<header id="header" class="header"  >
    <div class="header__top" id="header-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="wrap-logo">
                        <h1><a href="{{path}}" >空名NEWS</a></h1>
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
                                <em>武汉</em>
                                <div class="weather__city__list">
                                    <ul>
                                        <li class="active">
                                            <a href="#">中华人民共和国</a>
                                        </li>
                                        <li>
                                            <a href="#">湖北</a>
                                        </li>
                                        <li>
                                            <a href="#">武汉</a>
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
        <%--style="width: 100%"--%>
        <div class="container" >
            <div class="wrapper clearfix bigmegamenu" >
                <!--Main Menu HTML Code-->
                <%--style="margin-left: 8%;margin-right: 8%"--%>
                <nav class="wsmenu slideLeft clearfix" >
                    <ul id="" class="mobile-sub wsmenu-list">
                        <li id="home" class="active">
                            <span class="wsmenu-click"></span>
                            <a href="{{path}}" >主页</a>
                        </li>

                        <li class="active" ng-repeat="category in categories">
                            <span class="wsmenu-click"></span>
                            <a href="{{path}}pages/news_list.jsp?{{random}}#?cid={{category.id}}">{{category.name}}</a>
                        </li>

                        <li id="more" ng-mouseenter="getAllCategory()">
                            <span class="wsmenu-click"></span>
                            <a href="">更多
                            </a>
                            <ul class="wsmenu-submenu" id="more_ul">
                                <li class="active" ng-repeat="category in allCategories">
                                    <span class="wsmenu-click"></span>
                                    <a href="{{path}}pages/news_list.jsp?{{random}}#?cid={{category.id}}" >{{category.name}}</a>
                                </li>
                            </ul>
                        </li>
                        <li class="hidden-xs">
                            <form class="navbar-form" role="search">
                                <input type="text" class="form-control" placeholder="搜索" ng-model="condition" id="condition">
                                <button type="submit" class="btn btn-search">
                                    <i class="icon-search"></i>
                                    <br/>搜索
                                </button>
                            </form>
                        </li>
                        <li class="right-arrow-button">
                            <div class="top-header-left">
                                <a href="{{path}}pages/register.html">注册</a>
                                <a href="#">登录</a>
                                <a href="javascript:void(0)">我是管理员</a>
                            </div> <!-- /.top-header-left -->
                        </li>
                    </ul>

                </nav>
                <!--Menu HTML Code-->
            </div>
        </div>
    </div>
</header>

