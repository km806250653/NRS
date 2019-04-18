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
<style>
    .comment-avatar {
        float: left;
        margin-right: 20px;
        display: block;
        border-radius: 50%;
        overflow: hidden; }
</style>
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
                            <div class="exchange__name">
                                <em>{{weather.city}}</em>
                            </div>
                            <div class="weather__temperature">
                                <div class="weather__city__list">
                                    <ul>
                                        <%--class="active"--%>
                                        <li ng-repeat="date in weather.data">
                                            <a href="javascript:void(0)" ng-click="chooseDate($index)">{{date.day}}</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="weather__city">
                                <em>{{selectDate.day}}</em>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-7">
                        <div class="exchange">
                            <p class="exchange__name">{{time}}</p>
                            <p class="exchange__course">
                                <img src="{{path}}img/icon/{{selectDate.wea_img}}.png" style="width: 20px;height: 20px">
                                <em class="active">{{selectDate.tem}}</em>
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
                <%--<iframe scrolling="no" src="https://tianqiapi.com/api.php?style=tx&skin=orange" frameborder="0" width="100%" height="30" allowtransparency="true"></iframe>--%>
                <nav class="wsmenu slideLeft clearfix" >
                    <ul id="" class="mobile-sub wsmenu-list">
                        <li id="home" class="active">
                            <span class="wsmenu-click"></span>
                            <a href="{{path}}" >主页</a>
                        </li>

                        <li class="active" ng-repeat="category in categories">
                            <span class="wsmenu-click"></span>
                            <a href="{{path}}pages/news_list.jsp?{{random}}#?cid={{category.id}}">{{category.text}}</a>
                        </li>

                        <li  ng-mouseenter="getAllCategory()">
                            <span class="wsmenu-click"></span>
                            <a href="">更多
                            </a>
                            <ul class="wsmenu-submenu" >
                                <li class="active" ng-repeat="category in allCategories">
                                    <span class="wsmenu-click"></span>
                                    <a href="{{path}}pages/news_list.jsp?{{random}}#?cid={{category.id}}" >{{category.text}}</a>
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
                            <span class="wsmenu-click"></span>
                            <div class="comment-avatar">
                                <img alt="" src="img/comment_2.jpg">
                            </div>
                            <ul class="wsmenu-submenu" >
                                <li class="active" >
                                    <span class="wsmenu-click"></span>
                                    <a href="{{path}}pages/register.html">注册</a>
                                </li>
                                <li class="active" >
                                    <span class="wsmenu-click"></span>
                                    <a href="{{path}}user/login.do">登录</a>
                                </li>
                            </ul>
                        </li>

                    </ul>

                </nav>
                <!--Menu HTML Code-->
            </div>
        </div>
    </div>
</header>

