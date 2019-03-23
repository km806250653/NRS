<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<header id="header" class="header">
    <div class="header__top">
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
    <div class="wsmenucontent overlapblackbg"></div>
    <div class="wsmenuexpandermain slideRight">
        <a id="navToggle" class="animated-arrow slideLeft">
            <span></span>
        </a>
    </div>
    <div class="header_down">
        <div class="container">
            <div class="wrapper clearfix bigmegamenu">
                <!--Main Menu HTML Code-->
                <nav class="wsmenu slideLeft clearfix">
                    <ul class="mobile-sub wsmenu-list">
                        <li class="visible-xs">
                            <form class="navbar-form mob_search" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                </div>
                                <button type="submit" class="btn btn-search">
                                    <i class="icon-search"></i>
                                </button>
                            </form>
                        </li>

                        <li class="active">
                            <span class="wsmenu-click"></span>
                            <a href="index.jsp">Home</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">Policy</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">Sport</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">Holidays</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">Religion</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">People</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="category.html">Main</a>
                        </li>
                        <li>
                            <span class="wsmenu-click"></span>
                            <a href="">Other
                                <span class="arrow"></span>
                            </a>
                            <ul class="wsmenu-submenu">
                                <li>
                                    <a href="404.html">404 page</a>
                                </li>
                                <li>
                                    <a href="category.html">Category page</a>
                                </li>
                                <li>
                                    <a href="news.html">News page</a>
                                </li>
                                <li>
                                    <a href="search-result.html">Search result</a>
                                </li>
                                <li>
                                    <a href="full-width.html">Full width</a>
                                </li>
                            </ul>
                        </li>
                        <li class="navbar-right hidden-xs">
                            <form class="navbar-form" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                </div>
                                <button type="submit" class="btn btn-search">
                                    <i class="icon-search"></i>
                                    <br/>Search
                                </button>
                            </form>
                        </li>
                        <li>
                            <div class="visible-xs col-sm-offset-5 col-sm-4">
                                <div class="col-sm-5">
                                    <div class="weather">
                                        <div class="weather__temperature">
                                            <span class="icon-sun"></span>
                                            <em>+8 C</em>
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
                                <div class="col-sm-7">
                                    <div class="exchange">
                                        <p class="exchange__name">Central Bank Rate</p>
                                        <p class="exchange__course">
                                            $<span>32.32</span>&#8364;<span>28.23</span>
                                        </p>
                                    </div>
                                </div>
                            </div>
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

