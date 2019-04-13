<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2019/3/23
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta name="referrer" content="never">
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    <!-- All JavaScript libraries -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../plugins/angularjs/angular.min.js"></script>
    <script src="../js/base.js"></script>
    <script>

    </script>
    <title></title>
</head>
<body class="page" ng-app="newsRS" ng-controller="baseController" ng-init="getSomeCategory()" >

<div class="wrapper-sticky-footer" >

    <div class="content-sticky">
        <!-- Header -->
        <%@ include file="header.jsp" %>
        <!-- END header -->
        <!-- content-->
        <div class="wrap wrap_gray pt20">
            <div class="container">

                <div class="row" >
                    <c:forEach items="${result.rows}" var="news" varStatus="s">
                        <div class="col-sm-3" style="height: 300px">
                            <div class="thumbnail thumbnail_small">
                                <a href=${pageContext.request.contextPath}/news/findOne?id=${news.id} class="thumbnail__link">
                                    <img src="../img/content/news2.jpg" height="153" width="270" alt="News">
                                </a>
                                <div class="caption thumbnail__caption">
                                    <div class="news caption__news">
                                        <p class="news__category yellow-line">Economy</p>
                                        <a href=${pageContext.request.contextPath}/news/findOne?id=${news.id} class="news__link">
                                            <p class="news__text">${news.title}</p>
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
                    </c:forEach>
                </div>
                    <ul class="pagination pagination-lg" id="page">
                        <nav class="paging">
                            <ul class="pagination pagination-lg" id="pagination">
                                <li><a href="#" aria-label="Previous"><span aria-hidden="true"><<</span></a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#" aria-label="Next"><span aria-hidden="true">>></span></a></li>
                            </ul>
                        </nav>
                    </ul>
                <%--<a href="#">首页</a>--%>
                <%--<a href="#">上一页</a>--%>
                <%--<c:forEach begin="1" end="${result.total}" varStatus="s">--%>

                    <%--<a href="#">${s.index}</a>--%>
                <%--</c:forEach>--%>
                <%--<a href="#">下一页</a>--%>
                <%--<a href="#">末页</a>--%>
                <div class="row">
                    <div class="ajax_load">
                        <i class="icon-arrows-cw"></i>Load more
                        <svg width="128" height="40" viewBox="0 0 128 40" xmlns="http://www.w3.org/2000/svg">
                            <rect x='0' y='0' fill='none' width='128' height='40'></rect>
                        </svg>
                    </div>
                </div>
                <!-- END content-->
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
        </div>
</body>
</html>


