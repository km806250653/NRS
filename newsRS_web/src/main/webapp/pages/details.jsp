<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2019/3/23
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <link href="../css/main.css" rel="stylesheet" type="text/css" />
    <!-- All JavaScript libraries -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/utils.js"></script>
    <script src="../plugins/angularjs/angular.min.js"></script>
    <script src="../js/base.js"></script>
    <script src="../js/controller/headerController.js"></script>
    <title></title>
</head>
<body ng-app="newsRS" ng-controller="header" ng-init="getSomeCategory()">
<!-- Header -->
<%@ include file="header.jsp"%>
<!-- END header -->
<!-- header slider -->
<div class="wrapper">
    <article class="container articles">
        <div class="row">
            <%--右边--%>
            <div class="col-sm-4 col-md-3 right_sidebar hidden-xs hidden-sm" data-spy="affix" data-offset-top="112" data-offset-bottom="80">
                <div class="news-tabs">
                    <p class="news-tabs__title h2">News feed</p>
                    <ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#home" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#profile" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#messages" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#settings" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#home" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#profile" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#messages" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#settings" role="tab" data-toggle="tab">
                                <span class="time">today, 12:30</span>
                                Volkswagen hit by multiple probes in US
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
                <%--正文--%>
            <div class="col-sm-12 col-md-9 article_text">
                <div class="current">
                    <h1 class="text-center yel_line current__title">${news.title}</h1>
                    ${news.content}
                    <p class="current__text"></p>
                    <p class="current__text"></p>
                    <blockquote class="quote current__quote">Lorem</blockquote>
                    <p class="current__text">Duis aute </p>
                </div>
            </div>
                <%--标签--%>
            <div class="col-sm-12 col-md-9 tags">
                <p>Tags:</p>
                <ul>
                    <li>
                        <a href="#" title="World" class="font">World</a>
                    </li>
                    <li>
                        <a class="yellow font" href="#" title="Sport">Sport</a>
                    </li>
                    <li>
                        <a href="#" title="Cats" class="font">Cats</a>
                    </li>
                </ul>
            </div>
                <%--评论--%>
            <div class="col-sm-9 col-md-8 col-lg-6 comments">
                <p class="comments__title">Comments</p>
                <div class="comments__media">
                    <div class="media-middle">
                        <i class="media-object" style="background-image: url('img/content/comment.png')"></i>
                        <div class="comm_info">
                            <h4 class="media-heading">Maria</h4>
                            <span class="time">today, 12:30</span>
                        </div>
                    </div>
                    <p class="media-body">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
                <div class="comments__media">
                    <div class="media-middle">
                        <i class="media-object" style="background-image: url('img/content/comment.png')"></i>
                        <div class="comm_info">
                            <h4 class="media-heading">Maria</h4>
                            <span class="time">today, 12:30</span>
                        </div>
                    </div>
                    <p class="media-body">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
                <div class="comments__media">
                    <div class="media-middle">
                        <i class="media-object" style="background-image: url('img/content/comment.png')"></i>
                        <div class="comm_info">
                            <h4 class="media-heading">Maria</h4>
                            <span class="time">today, 12:30</span>
                        </div>
                    </div>
                    <p class="media-body">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
                <div class="comments__form">
                    <form action="#" method="POST">
                        <div class="form-group">
                            <input type="text" style="width: 200px;" class="form-control" placeholder="Your name">
                        </div>
                        <div class="form-group">
                            <textarea name="text" id="input" class="form-control" rows="7" required="required"></textarea>
                        </div>
                        <button type="submit" class="btn btn-comment">send</button>
                    </form>
                </div>
            </div>
        </div>
    </article>
</div>
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


