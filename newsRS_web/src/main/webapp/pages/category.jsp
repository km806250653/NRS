<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2019/3/23
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta name="referrer" content="never">
    <link href="../css/main.css" rel="stylesheet" type="text/css" />
    <!-- All JavaScript libraries -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../plugins/angularjs/angular.min.js"></script>
    <script src="../js/base.js"></script>
    <title></title>
</head>
<body ng-app="newsRS" ng-controller="baseController" ng-init="getSomeCategory()">
<!-- Header -->
<%@ include file="header.jsp"%>
<!-- END header -->
<!-- header slider -->
<section>
    <!-- top news -->
    <div class="wrap wrap_white">
        <div class="container title">
            <h2 class="title__h1 underscore">Economy</h2>
        </div>
    </div>
    <div class="wrap wrap_gray pt20">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="thumbnail thumbnail_big">
                        <img src="img/content/news1.jpg" height="349" width="560" alt="News">
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
                            <img src="img/content/news3.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news4.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news5.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news6.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news7.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news8.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                            <img src="img/content/news9.jpg" height="153" width="270" alt="News">
                        </a>
                        <div class="caption thumbnail__caption">
                            <div class="news caption__news">
                                <p class="news__category yellow-line">Economy</p>
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
                                                <i class="icon-eye"></i>2.3k
                                            </span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 p0">
                    <div class="col-sm-6">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news10.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Economy</p>
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
                                                    <i class="icon-eye"></i>2.3k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news11.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Economy</p>
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
                                                    <i class="icon-eye"></i>2.3k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news12.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Economy</p>
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
                                                    <i class="icon-eye"></i>2.3k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="thumbnail thumbnail_small">
                            <a href="news.html" class="thumbnail__link">
                                <img src="img/content/news13.jpg" height="153" width="270" alt="News">
                            </a>
                            <div class="caption thumbnail__caption">
                                <div class="news caption__news">
                                    <p class="news__category yellow-line">Economy</p>
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
                                                    <i class="icon-eye"></i>2.3k
                                                </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="thumbnail thumbnail_big">
                        <img src="img/content/news1.jpg" height="349" width="560" alt="News">
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
            </div>
        </div>
        <div class="ajax_load">
            <i class="icon-arrows-cw"></i>Load more
            <svg width="128" height="40" viewBox="0 0 128 40" xmlns="http://www.w3.org/2000/svg">
                <rect x='0' y='0' fill='none' width='128' height='40'></rect>
            </svg>
        </div>
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
</body>
</html>


