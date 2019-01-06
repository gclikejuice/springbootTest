submit = function () {
    var data = $("#loginForm").serialize();
    $.ajax({
        dataType:"json",
        data:data,
        url:"login",
        success:function () {
            alert("登录成功");
        },
        error:function () {
            alert("登录失败")
        }
    })
}

$(function () {
    $("#submit").bind("click",submit());
});