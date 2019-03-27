//根据传递过来的参数name获取对应的值
function utils(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = location.search.substr(1).match(reg);
    if (r!=null) return (r[2]); return null;
}

function judgeParameter(parameter) {
    if(parameter)
        return parameter;
    return null;
}
