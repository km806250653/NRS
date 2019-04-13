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
                            <a href="{{path}}" >主页</a>
                        </li>

                        <li class="active" ng-repeat="category in categories">
                            <span class="wsmenu-click"></span>
                            <a href="{{path}}news/findList?cid={{category.id}}&condition={{condition}}&currentPage=1&size=12">{{category.name}}</a>
                        </li>

                        <li id="more" ng-mouseenter="getAllCategory()">
                            <span class="wsmenu-click"></span>
                            <a href="">更多
                            </a>
                            <ul class="wsmenu-submenu" id="more_ul">
                                <li class="active" ng-repeat="category in allCategories">
                                    <span class="wsmenu-click"></span>
                                    <a href="{{path}}news/findList?cid={{category.id}}&condition={{condition}}&currentPage=1&size=12">{{category.name}}</a>
                                </li>
                            </ul>
                        </li>
                        <li class="navbar-right hidden-xs">
                            <form class="navbar-form" role="search">
                                <input type="text" class="form-control" placeholder="搜索" ng-model="condition" id="condition">
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

