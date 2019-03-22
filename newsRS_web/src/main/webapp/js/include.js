$(function () {
    $.get("pages/header.jsp",function (data) {
        $(".header").html(data);
    });
    $.get("pages/footer.jsp",function (data) {
        $("#footer").html(data);
    });
});

