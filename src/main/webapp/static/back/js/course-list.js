var max = 5;
var pagelistc = 5;

var options;
$(function () {
    $("tbody").empty();
    $.ajaxSetup({
        cache:false
    });
    // 老师名字
    $.ajax({
        type: "GET",
        url: "/StuSystem/backTeacher/getTeacherName", //老师姓名的地址
        dataType: "json",
        success: function (data) {
            console.log(data.teacherName);
            var str = data.teacherName + '<i class="Hui-iconfont">&#xe6d5;</i>';
            $("#name").html(str);
        }
    });
    // 接收有哪些课程的数据
    $.ajax({
        type: "GET",
        url: "/StuSystem/backCourse/all", //老师查课程的地址
        dataType: "json",
        success: function (data, textStatus) {
            var datas = data.courseList;
            options = {
                "id": "page", //显示页码的元素
                "data": datas, //显示数据
                "maxshowpageitem": max, //最多显示的页码个数
                "pagelistcount": pagelistc, //每页显示数据个数authorMajor
                "callBack": function (result) {
                    console.log(result);
                    var cHtml = "";
                    for(var i in result) {
                        cHtml += '<tr><td>' + result[i].id + '</td><td>' + result[i].courseName + '</td><td><button  style="font-size: 12px; background: #337ab7; color: white;" class=\"btn radius delete\" id="' + result[i].id + '">删除</button><button  style="font-size: 12px; background: #33AECC;" class="btn btn-secondary  radius manage" "><a style="color: white;" href="/StuSystem/backElective/manage?id=' + result[i].id + '">管理</a></button></td></tr>>'
                    }
                    $(".grid-body").html(cHtml);

                    //删除
                    $(".delete").click(function () {
                        $(this).parents("tr").remove();
                        var id = $(this).attr("id");
                        console.log(id);
                        $.ajax({
                            type: "GET", //请求方式
                            url: "/StuSystem/backCourse/delete", //删除课程的地址
                            data: {
                                id: id
                            }
                        });
                    });
                    //    管理
                    $(".manage").click(function () {
                        var id = $(this).siblings(".delete").attr("id");
                        console.log(id);
                        $.ajax({
                            type: "GET", //请求方式
                            url: "/StuSystem/backElective/manage", //管理课程的地址
                            data: {
                                id: id
                            },
                            success: function (){
                                window.location.href=window.location.href;
                                window.location.reload;
                            }
                        });
                    });
                }
            }
            page.init(datas.length, 1, options);
        },
        complete: function(XMLHttpRequest, textStatus) {
        },
        error: function() {
            alert("请求网络失败！。。。。。。");
        }
    });

    $("#submit-add").click(function(){
        var tmp = $("#new-course").val()
        $.ajax({
            type: "POST", //请求方式
            url: "/StuSystem/backCourse/new", //删除课程的地址
            data: {
                courseName:tmp
            }
        });
        location.reload();
    });
});
