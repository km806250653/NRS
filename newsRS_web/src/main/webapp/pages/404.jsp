<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2019/3/22
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <link href="../css/main.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <!-- Custom JavaScript -->
    <script src="../js/main.js"></script>
    <script src="../plugins/angularjs/angular.min.js"></script>
    <script src="../js/base.js"></script>
    <title>404 Page</title>
</head>
<body ng-app="newsRS" ng-controller="baseController" ng-init="getSomeCategory()">
<div class="wrapper-sticky-footer">
    <div class="content-sticky">
        <!-- Header -->
        <%--<%@include file="header.jsp"%>--%>
        {{path}}
        <div ng-include="'../pages/header.jsp'"></div>
        <!-- END header -->
        <!-- Content-->
        <div class="wrap-error">
            <div class="error clearfix">
                <div class="error__left">
                    <p class="error__text">404</p>
                </div>
                <div class="error__right">
                    <div class="error__head">Page not found...</div>
                    <p class="error__text">We're sorry, but we can't find the page you were looking for. It's probably some thing we've done wrong but now we know about it we'll try to fix it. In the meantime, try one of this options:</p>
                    <ul class="error__list">
                        <li>
                            <a href="#" class="link">Go back to previous page</a>
                        </li>
                        <li>
                            <a href="../" class="link">Go to homepage</a>
                        </li>
                    </ul>
                </div>
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
<!-- END Footer -->
<!-- All JavaScript libraries -->
</body>
</html>

