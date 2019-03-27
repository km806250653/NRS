$(function () {
    path = getAbsolutePath(); //全局变量  http://ip:port/newsRS_web/
    $.get(path + "category/findAll", "", function (list) {
        for (var i = 0; i < list.length; i++) {
            if (i > 6) {             //超过六个时，多余的放入下拉框中
                li = '<li style="width: 100px">\n' +
                    '                                    <a style="text-align: center" href="' + path + 'news/findByCid?cid=' + list[i].id + '">' + list[i].name + '</a>\n' +
                    '                                </li>';
                $("#more_ul").append($(li));
            } else {
                li = '<li id="home" class="active">\n' +
                    '                            <span class="wsmenu-click"></span>\n' +
                    '                            <a href="' + path + 'news/findByCid?cid=' + list[i].id + '">' + list[i].name + '</a>\n' +
                    '                        </li>';
                $("#more").before($(li));
            }
        }
    });
});