
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="utf-8">

    <!-- All JavaScript libraries -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <title>新闻发布系统</title>
    <%--<%!--%>
        <%--String contextPath = request.getContextPath();--%>
    <%--%>--%>
    <%--<script>--%>
        <%--contextPath=<%=contextPath%>--%>
    <%--</script>--%>
</head>
<body>
<!-- Header -->
<%@include file="pages/header.jsp"%>
<!-- END header -->
<!-- header slider -->

<div class="slate_gray">
    <div class="container">
        <div class="row header_news_panel">
            <!-- Tab panes -->
            <div class="col-sm-8 tab-content tab-content_mob-p0">
                <div role="tabpanel" class="tab-pane fade in active" id="home">
                    <img src="img/content/slide1.jpg" alt="main img" class="tab-pane__img">
                    <div class="header_news_text tab-pane__block">
                        <p class="tab-pane__category yel_line">People</p>
                        <a class="tab-pane__title">The Visions's Rainbow</a>
                        <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile">
                    <img src="img/content/slide2.jpg" alt="main img" class="tab-pane__img">
                    <div class="header_news_text tab-pane__block">
                        <p class="tab-pane__category yel_line">People</p>
                        <a class="tab-pane__title">The Visions's Rainbow</a>
                        <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="messages">
                    <img src="img/content/slide1.jpg" alt="main img" class="tab-pane__img">
                    <div class="header_news_text tab-pane__block">
                        <p class="tab-pane__category yel_line">People</p>
                        <a class="tab-pane__title">The Visions's Rainbow</a>
                        <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="settings">
                    <img src="img/content/slide2.jpg" alt="main img" class="tab-pane__img">
                    <div class="header_news_text tab-pane__block">
                        <p class="tab-pane__category yel_line">People</p>
                        <a class="tab-pane__title">The Visions's Rainbow</a>
                        <p class="tab-pane__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
            </div>
            <!-- END Tab panes -->
            <!-- Nav tabs -->
            <div class="col-sm-4 news-tabs">
                <p class="news-tabs__title h2">Last news</p>
                <ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">
                    <li role="presentation" class="active">
                        <a href="#home" role="tab" data-toggle="tab">
                            <span class="time">today, 10:11</span>
                            Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="#profile" role="tab" data-toggle="tab">
                            <span class="time">today, 11:22</span>
                            Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="#messages" role="tab" data-toggle="tab">
                            <span class="time">today, 12:33</span>
                            Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="#settings" role="tab" data-toggle="tab">
                            <span class="time">today, 14:44</span>
                            Volkswagen hit by multiple probes in US Volkswagen hit by multiple probes in US
                        </a>
                    </li>
                </ul>
            </div>
            <!-- END Nav tabs -->
        </div>
    </div>
</div>
<!-- END header slider -->
<!-- top news-->
<section>
    <!-- top news -->
    <!-- title -->
    <div class="wrap wrap_white">
        <div class="container title">
            <h1 class="title__h1 underscore">Popular content</h1>
        </div>
    </div>
    <!-- END title -->
    <div class="wrap wrap_gray pt20">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="thumbnail thumbnail_big">
                        <img src="img/content/news1.jpg" height="350" width="560" alt="News">
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
                                <a href="#" class="news__head">The dollar has broken all records of positive change in the world and in the galaxy</a>
                                <p class="news__desc">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 16:37</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>29
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>2.3k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news2.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">Еhe world's economy is improving and good times</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 12:11</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>11
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>1.1k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news3.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">The euro needs to everyone in a large amount</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 19:30</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>294
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>2.9k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news4.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <i class="icon-play"></i>
                                <p class="news__category yellow-line">People</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">NEWS: People began to love each other in large numbers online (Video)</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 2:39</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>9
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>1.3k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news5.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Sport</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">Athletes are confident of victory in all competitions</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 14:34</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>58
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>8.8k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news6.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <i class="icon-play"></i>
                                <p class="news__category yellow-line">People</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">All the people of the world love each other and say hello</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 12:37</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>20
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>1.2k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news7.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">Attention: The poor become rich, rich richer</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 11:30</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>21
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>1.9k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news8.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <i class="icon-play"></i>
                                <p class="news__category yellow-line">Sport</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">The winners of sports games already online (Video)</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 10:36</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>17
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>2.0k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="thumbnail thumbnail_small">
                        <a href="news.html" class="thumbnail__link">
                            <img src="img/content/news9.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Business</p>
                                <a href="news.html" class="news__link">
                                    <p class="news__text">The best exchange rates and motivation for you</p>
                                </a>
                            </div>
                            <div class="posted">
                                <span class="posted__date">today, 12:30</span>
                                <ul class="posted__icon">
                                    <li>
                                                <span>
                                                <i class="icon-comment-empty"></i>29
                                            </span>
                                    </li>
                                    <li>
                                                <span>
                                                <i class="icon-eye"></i>2.3k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- btn load-->
        <div class="ajax_load">
            <i class="icon-arrows-cw"></i>Load more
            <svg width="128" height="40" viewBox="0 0 128 40" xmlns="http://www.w3.org/2000/svg">
                <rect x='0' y='0' fill='none' width='128' height='40'></rect>
            </svg>
        </div>
        <!-- END btn load-->
    </div>
    <!-- /container-->
</section>
<!-- /top news -->
<section class="wrap wrap_gray">
    <div class="container">
        <div class="row">
            <div class="col-sm-9 projects">
                <div class="projects__title">
                    <h2 class="block-title__h2">Special project</h2>
                </div>
                <div class="projects__row">
                    <div class="special special_big">
                        <img src="img/content/spec1.jpg" height="311" width="551" alt="image" class="special__img">
                        <div class="special__box">
                            <h5 class="special__category yel_line">Special project</h5>
                            <a href="#" class="special__link">Lorem ipsum dolor sit amet</a>
                            <p class="special__desc">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                        </div>
                    </div>
                    <div class="special special_small">
                        <img src="img/content/spec2.jpg" height="311" width="285" alt="image" class="special__img">
                        <div class="special__box">
                            <h5 class="special__category yel_line">Special project</h5>
                            <a href="#" class="special__link">Lorem ipsum dolor</a>
                            <p class="special__desc">Duis aute irure dolor in reprehenderit in voluptate velit.</p>
                        </div>
                    </div>
                </div>
                <div class="projects__row">
                    <div class="special special_small">
                        <img src="img/content/spec3.jpg" height="311" width="285" alt="image" class="special__img">
                        <div class="special__box">
                            <h5 class="special__category yel_line">Special project</h5>
                            <a href="#" class="special__link">Lorem ipsum dolor</a>
                            <p class="special__desc">Duis aute irure dolor in reprehenderit in voluptate velit.</p>
                        </div>
                    </div>
                    <div class="special special_big">
                        <img src="img/content/spec4.jpg" height="311" width="551" alt="image" class="special__img">
                        <div class="special__box">
                            <h5 class="special__category yel_line">Special project</h5>
                            <a href="#" class="special__link">Lorem ipsum dolor sit amet</a>
                            <p class="special__desc">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                        </div>
                    </div>
                </div>
                <!-- banner -->
                <div class="banner">
                    <img src="img/content/banner.jpg" height="221" width="850" alt="image" class="banner__img">
                    <div class="banner__box">
                        <p class="banner__text first-text">Advertising</p>
                        <p class="banner__text second-text">Here</p>
                        <a href="#" class="banner__link">Get Now</a>
                    </div>
                </div>
                <!-- END banner -->
            </div>
            <div class="col-sm-3">
                <div class="block-title">
                    <h2 class="block-title__h2">Twitter</h2>
                </div>
                <div class="twitter">
                    <div class="twitter__header">
                        <p class="twitter__header__name">@barclee</p>
                        <p class="twitter__header__text">Hello, world</p>
                    </div>
                    <div class="twitter__body">
                        <div class="message">
                            <p class="message__time">about 5 hours ago</p>
                            <p class="message__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a href="#" class="message__link">
                                <i class="icon-reply"></i>Reply
                            </a>
                        </div>
                        <div class="message">
                            <p class="message__time">about 5 hours ago</p>
                            <p class="message__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a href="#" class="message__link">
                                <i class="icon-reply"></i>Reply
                            </a>
                        </div>
                        <div class="message">
                            <p class="message__time">about 5 hours ago</p>
                            <p class="message__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a href="#" class="message__link">
                                <i class="icon-reply"></i>Reply
                            </a>
                        </div>
                        <div class="message">
                            <p class="message__time">about 5 hours ago</p>
                            <p class="message__text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a href="#" class="message__link">
                                <i class="icon-reply"></i>Reply
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="wrap wrap_gray">
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <div class="row">
                    <div class="block-title col-sm-12">
                        <h2 class="block-title__h2">Policy
                            <a class="block-title__view-all" href="#" data-hover="See all">See all</a>
                        </h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news10.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Policy</p>
                                    <a href="news.html" class="news__link">
                                        <p class="news__text">CEO who jacked up price of AIDS pill to $750 faces major backlash</p>
                                    </a>
                                </div>
                                <div class="posted">
                                    <span class="posted__date">today, 12:30</span>
                                    <ul class="posted__icon">
                                        <li>
                                                    <span>
                                                    <i class="icon-comment-empty"></i>29
                                                </span>
                                        </li>
                                        <li>
                                                    <span>
                                                    <i class="icon-eye"></i>4.4k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news11.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Policy</p>
                                    <a href="news.html" class="news__link">
                                        <p class="news__text">CEO who jacked up price of AIDS pill to $750 faces major backlash</p>
                                    </a>
                                </div>
                                <div class="posted">
                                    <span class="posted__date">today, 11:30</span>
                                    <ul class="posted__icon">
                                        <li>
                                                    <span>
                                                    <i class="icon-comment-empty"></i>22
                                                </span>
                                        </li>
                                        <li>
                                                    <span>
                                                    <i class="icon-eye"></i>5.3k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="wrap-article">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="article">
                                        <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                        <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                        <p class="article__time">today, 16:04</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="wrap-article">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="article">
                                        <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                        <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                        <p class="article__time">today, 16:04</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="wrap-article">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="article">
                                        <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                        <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                        <p class="article__time">today, 16:04</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="wrap-article">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="article">
                                        <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                        <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                        <p class="article__time">today, 16:04</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="block-title col-sm-12">
                        <h2 class="block-title__h2">Economy
                            <a class="block-title__view-all" href="#" data-hover="See all">See all</a>
                        </h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news12.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">People</p>
                                    <a href="news.html" class="news__link">
                                        <p class="news__text">CEO who jacked up price of AIDS pill to $750 faces major backlash</p>
                                    </a>
                                </div>
                                <div class="posted">
                                    <span class="posted__date">today, 11:31</span>
                                    <ul class="posted__icon">
                                        <li>
                                                    <span>
                                                    <i class="icon-comment-empty"></i>21
                                                </span>
                                        </li>
                                        <li>
                                                    <span>
                                                    <i class="icon-eye"></i>2.1k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news13.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Sport</p>
                                    <a href="news.html" class="news__link">
                                        <p class="news__text">CEO who jacked up price of AIDS pill to $750 faces major backlash</p>
                                    </a>
                                </div>
                                <div class="posted">
                                    <span class="posted__date">today, 10:30</span>
                                    <ul class="posted__icon">
                                        <li>
                                                    <span>
                                                    <i class="icon-comment-empty"></i>22
                                                </span>
                                        </li>
                                        <li>
                                                    <span>
                                                    <i class="icon-eye"></i>2.1k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4">
                        <div class="row wrap-article">
                            <div class="col-sm-12">
                                <div class="article">
                                    <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                    <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                    <p class="article__time">today, 13:11</p>
                                </div>
                            </div>
                        </div>
                        <div class="row wrap-article">
                            <div class="col-sm-12">
                                <div class="article">
                                    <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                    <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                    <p class="article__time">today, 13:11</p>
                                </div>
                            </div>
                        </div>
                        <div class="row wrap-article">
                            <div class="col-sm-12">
                                <div class="article">
                                    <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                    <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                    <p class="article__time">today, 12:03</p>
                                </div>
                            </div>
                        </div>
                        <div class="row wrap-article">
                            <div class="col-sm-12">
                                <div class="article">
                                    <i class="article__icon" style="background-image:url('img/content/circle.png');"></i>
                                    <a href="#" class="article__text">Lorem ipsum dolor sit amet, consectetur adipisc</a>
                                    <p class="article__time">today, 11:04</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="block-title">
                    <h2 class="block-title__h2">EDITOR'S CHOICE</h2>
                </div>
                <div class="wrap-redaction wrap-redaction_white">
                    <div class="redaction redaction_line">
                        <p class="redaction__category yel_line">Policy</p>
                        <a class="redaction__title">Lorem ipsum dolor sit amet, consectetur</a>
                        <p class="redaction__text">Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris, quis nostrud ullamco laboris</p>
                        <p class="redaction__time">today, 16:35</p>
                    </div>
                    <div class="redaction redaction_line">
                        <p class="redaction__category yel_line">Policy</p>
                        <a class="redaction__title">Lorem ipsum dolor sit amet, consectetur</a>
                        <p class="redaction__text">Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris, quis nostrud ullamco laboris</p>
                        <p class="redaction__time">today, 16:35</p>
                    </div>
                    <div class="redaction redaction_line">
                        <p class="redaction__category yel_line">Policy</p>
                        <a class="redaction__title">Lorem ipsum dolor sit amet, consectetur</a>
                        <p class="redaction__text">Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris, quis nostrud ullamco laboris</p>
                        <p class="redaction__time">today, 16:35</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer -->
<footer class="footer slate_gray">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.</p>
            </div>
            <div class="col-sm-6">
                <div class="social navbar-right">
                    <p class="social__text">We are in social networks</p>
                    <ul class="social__list">
                        <li class="social__item">
                            <a class="facebook" href="#">
                                <i class="icon-facebook"></i>
                            </a>
                        </li>
                        <li class="social__item">
                            <a class="twitter" href="#">
                                <i class="icon-twitter"></i>
                            </a>
                        </li>
                        <li class="social__item">
                            <a class="gplus" href="#">
                                <i class="icon-gplus"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- END Footer -->

</body>
</html>

