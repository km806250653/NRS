/*
    * Affix
    * Nav menu mobile
/*/
/* ***************** start document load **********************/

$(document).ready(function() {
	"use strict";
	/*
	|--------------------------------------------------------------------------
	| Affix
	|--------------------------------------------------------------------------
	|
	|
	|
	*/
    $('#myAffix').affix({
        offset: {
            top: 100,
            bottom: function() {
                return (this.bottom = $('.footer').outerHeight(true))
            }
        }
    });
    /* header select city */
    $('.weather__city__list ul li').on('click', function(e) {
        e.preventDefault();

        $(this).siblings("li").removeClass("active");
        $(this).removeClass('active').addClass('active');

        var text = $(this).find("a").html();
        $(".weather__city").find('em').html(text);
        return false;
    });
    /* end header select city */
});
/* ***************** end document load *********************/
/* ************** start document resize ********************/
$(window).resize(function() {
	"use strict";
    var height = 0;
    var autoHeight1 = $('.col-img_auto-height');
    var autoHeight2 = $('.col-border_auto-height');
    var autoHeight3 = $('.col-border_auto-height-small');
    $(autoHeight1).css('height', 'auto');
    autoHeight1.each(function() {
        if ($(this).height() > height) {
            height = $(this).height();
        }
    });
    autoHeight1.css('height', height);

    $(autoHeight2).css('height', 'auto');
    autoHeight2.each(function() {

        if ($(this).height() > height) {
            height = $(this).height();
        }
    });
    autoHeight2.css('height', height + 25);

    $(autoHeight3).css('height', 'auto');
    autoHeight3.each(function() {

        if ($(this).height() > height) {
            height = $(this).height();
        }
    });
    autoHeight3.css('height', height + 25);
}).resize();
/* **************** end document resize ********************/
$(function() {
	"use strict";
	/*
	|--------------------------------------------------------------------------
	| Nav menu mobile
	|--------------------------------------------------------------------------
	|
	|
	|
	*/
    var $menu = $(".overlapblackbg, .slideLeft");
    var $wsmenucontent = $(".wsmenucontent");
    var openMenu = function() {
        $($menu).removeClass("menuclose").addClass("menuopen")
    };
    var closeMenu = function() {
        $($menu).removeClass("menuopen").addClass("menuclose")
    };
    $("#navToggle").on('click', function() {
        if ($wsmenucontent.hasClass("menuopen")) {
            $(closeMenu)
        } else {
            $(openMenu)
        }
        return false;
    });
    $wsmenucontent.on('click', function() {
        if ($wsmenucontent.hasClass("menuopen")) {
            $(closeMenu)
        }
        return false;
    });
    $("#navToggle,.overlapblackbg").on('click', function() {
        $(".wsmenucontainer").toggleClass("mrginleft");
        return false;
    });
    $(".wsmenu-list li").has(".wsmenu-submenu, .wsmenu-submenu-sub, .wsmenu-submenu-sub-sub").prepend('<span class="wsmenu-click"><i class="wsmenu-arrow fa fa-angle-down"></i></span>');
    $(".wsmenu-list li").has(".megamenu").prepend('<span class="wsmenu-click"><i class="wsmenu-arrow fa fa-angle-down"></i></span>');
    $(".wsmenu-mobile").on('click', function() {
        $(".wsmenu-list").slideToggle("slow");
        return false;
    });
    $(".wsmenu-click").on('click', function() {
        $(this).siblings(".wsmenu-submenu").slideToggle("slow");
        $(this).children(".wsmenu-arrow").toggleClass("wsmenu-rotate");
        $(this).siblings(".wsmenu-submenu-sub").slideToggle("slow");
        $(this).siblings(".wsmenu-submenu-sub-sub").slideToggle("slow");
        $(this).siblings(".megamenu").slideToggle("slow");
        return false;
    });

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
        path = getAbsolutePath(); //全局变量  http://ip:port/newsRS_web/
        //设置主页按钮路径
        $("#home a").prop("href", path);
    });
    function getAbsolutePath() {
        var pathname = location.pathname; //newsRS_web/pages/news_list.jsp
        // alert(pathname);
        pathname = pathname.substring(1); // newsRS_web/pages/news_list.jsp
        // alert(pathname);
        pathname = pathname.substring(0, pathname.indexOf("/") + 1); //newsRS_web/
        // alert(pathname);
        var href = location.href; //http://localhost:8080/newsRS_web/pages/news_list.jsp
        // alert(href);
        href = href.substring(0, href.indexOf(pathname) + pathname.length); // http://localhost:8080/newsRS_web/
        // alert(href);
        return href;
    }
});