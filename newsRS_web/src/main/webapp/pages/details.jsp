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
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../css/comment.css" rel="stylesheet" type="text/css"/>
    <!-- All JavaScript libraries -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../plugins/angularjs/angular.min.js"></script>
    <script src="../js/base.js"></script>
    <script src="../js/service/detailService.js"></script>
    <script src="../js/controller/detailController.js"></script>

    <title></title>
</head>
<body ng-app="newsRS" ng-controller="detailController" ng-init="findComment(${news.id});childTexts = []">

<!-- Header -->
<%--<%@ include file="header.jsp"%>--%>
<div ng-include="'../pages/header.jsp'"></div>
<!-- END header -->
<!-- header slider -->
<div class="wrapper">
    <article class="container articles">
        <div class="row">
            <%--右边--%>
            <%--<div class="col-sm-4 col-md-3 right_sidebar hidden-xs hidden-sm" data-spy="affix" data-offset-top="112"--%>
                 <%--data-offset-bottom="80">--%>
                <%--<div class="news-tabs">--%>
                    <%--<p class="news-tabs__title h2">News feed</p>--%>
                    <%--<ul class="news-tabs__nav nav nav-tabs shadow_text" role="tablist">--%>
                        <%--<li role="presentation" class="active">--%>
                            <%--<a href="#home" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#profile" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#messages" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#settings" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#home" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#profile" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#messages" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li role="presentation">--%>
                            <%--<a href="#settings" role="tab" data-toggle="tab">--%>
                                <%--<span class="time">today, 12:30</span>--%>
                                <%--Volkswagen hit by multiple probes in US--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
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
                <p>标签:</p>
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

            <div class="col-sm-9 col-md-8 col-lg-6">
                <p class="comments__title">笔削褒贬</p>
                <ul class="comment-list">
                    <li class="comment" ng-repeat="entity in list">
                        <div class="comment-body">
                            <div class="comment-avatar">
                                <img alt=""
                                     src="{{entity.user.image==null?pathJson.projectPath+'pages/img/photo.png':entity.user.image}}"
                                     style="width: 45px;height: 45px;border-radius: 50%">
                            </div>
                            <div class="comment-text">
                                <h6 class="comment-author">{{entity.user.name}}</h6>
                                <div class="comment-metadata">
                                    <a href="#" class="comment-date">{{entity.comment.releaseTime}}</a>
                                </div>
                                <p>{{entity.comment.text}}</p>
                            </div>
                            <%-- 以pid来绑定每个文本框 --%>
                            <textarea name="text" class="form-control" rows="3" required="required"
                                      ng-model="childTexts[entity.comment.id]"></textarea>

                            <input class="btn-comments__form btn btn-comment"
                                   ng-click="releaseComment(${news.id},entity.comment.id)" value="评论">
                        </div>

                        <ul class="children" ng-repeat="child in entity.children">
                            <li class="comment">
                                <div class="comment-body">
                                    <div class="comment-avatar">
                                        <img style="width: 45px;height: 45px;border-radius: 50%"
                                             src="{{child.user.image==null?pathJson.projectPath+'pages/img/photo.png':child.user.image}}">
                                    </div>
                                    <div class="comment-text">
                                        <h6 class="comment-author">{{child.user.name}}</h6>
                                        <div class="comment-metadata">
                                            <a href="#" class="comment-date">{{child.comment.releaseTime}}</a>
                                        </div>
                                        <p class="comment-date">{{child.comment.text}}</p>
                                    </div>
                                </div>
                            </li> <!-- end reply comment -->
                        </ul>
                    </li>
                </ul>

                <div class="comments__form>form-group">
                    <textarea name="text" id="input" class="form-control" rows="7"
                              required="required"
                              ng-model="text"></textarea>
                </div>
                <button class="btn-comments__form btn btn-comment" ng-click="releaseComment(${news.id})">指点江山</button>
            </div>
        </div>
    </article>

</div>
<!-- Footer -->
<div ng-include="'../pages/footer.html'"></div>
</body>
</html>


