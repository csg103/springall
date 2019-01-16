// magic!don't touch!
// var opts = {
//     num_edge_entries: 2,
//     num_display_entries: 4,
//     items_per_page: 10,
//     current_page: 1,
//     func: 'loadData'
// };
var expect_value =[];
var self_value =[];
var photoFile = [];
var videoFile = [];
var nPhotoFile = [];
var matchmaker_value =[];
var hourseMyself=[];
var hourseHis=[];
var nVideoFile = [];
$(function(){
    $("#idCardNum").keyup(function () {
        var idCard = $("#idCardNum").val();
        if(idCard.length==15||idCard.length==18){
            var birthdayDate = getBirthDayFromIdCard(idCard);
            $("#birthday").val(birthdayDate);
        }
    })
    $("#mobilePhoneEdit").blur(function () {
        $.ajax({
            data: {

            },
            type: "POST",
            dataType: "JSON",
            url: ctx+"vip/phone/"+$("#mobilePhoneEdit").val(),
            success: function (data) {
                if(data.code=="0000"){
                    if(data.data=="1"){
                        alert("此手机号已存在！");
                    }
                }else{
                }

            }
        });
    })
    var expectStr = $("#expectedConditionsValue").val();
    var selfStr = $("#myselfIntroduceValue").val();
    var matchMakerStr = $("#matchmakerValue").val();
    var hourseMyselfStr = $("#owninghouseValue").val();
    var hourseHisStr = $("#otherOwninghouseValue").val();
    expect_value = expectStr.split(",")
    self_value = selfStr.split(",")
    hourseMyself=hourseMyselfStr.split(",");
    hourseHis=hourseHisStr.split(",");
    matchmaker_value = matchMakerStr.split(",");
    loadUploadedFile($('#num').val())
})
    layui.config({
        base:ctx + "third_party/layui/lay/modules/"
    }).use(['mupload'],function(){
        layui.mupload({
            url:ctx + 'upload'
            ,container:'#lifePhoto'
            ,complete:function(data){
                generateRows('uploadedPhoto', data)
            },
            valid:function(file){
                if(file.type.indexOf('image') >= 0){
                    return true
                }
                return false;
            }
        })

        layui.mupload({
            url:ctx + 'upload'
            ,container:'#lifeVideo'
            ,complete:function(data){
                generateRows('uploadedVideo', data)
            },
            valid:function(file){
                if(file.type.indexOf('video') >= 0){
                    return true
                }
                return false;
            }
        })
    });

    layui.use(['upload'],function(){
        var upload = layui.upload

        var uploadInst = upload.render({
            elem: '#head'
            ,url: ctx + 'upload'
            ,before: function(obj){
                obj.preview(function(index, file, result){
                    $('#fileView').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(data){
                if(data.code == '0000'){
                    $('#headFileId').val(data.data.id)
                }else {
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                var fileText = $('#fileText');
                fileText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                fileText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    })


    layui.use(['form','layer'], function(){
        var form = layui.form;

        //期待条件
        form.on('checkbox(changeExpect)', function(data){
            if(this.checked){
                expect_value.push($(this).val())
            }else{
                expect_value.pop($(this).val())
            }

        });
        //区域
        form.on('select(selectEditProvince)', function(data){
            if(data!=null){
                var citySelect=$('#cityEditSelect');
                var areaSelect=$('#areaEditSelect');
                $.ajax({
                    data: {

                    },
                    type: "POST",
                    dataType: "JSON",
                    url: ctx+"vip/province/"+data.value,
                    success: function (data) {
                        if(data.code=="0000"){
                            citySelect.empty();
                            areaSelect.empty();
                            var option=$("<option>").val("").text("请选择市");
                            citySelect.append(option);
                            for(var i=0;i<data.data.length;i++){
                                var option=$("<option>").val(data.data[i].areaid).text(data.data[i].areaname);
                                citySelect.append(option);
                            }
                            form.render();
                        }else{
                        }

                    }
                });
            }


        });

        //区域
        form.on('select(selectEditCity)', function(data){
            if(data!=null){
                var areaSelect=$('#areaEditSelect');
                $.ajax({
                    data: {

                    },
                    type: "POST",
                    dataType: "JSON",
                    url: ctx+"vip/city/"+data.value,
                    success: function (data) {
                        if(data.code=="0000"){
                            areaSelect.empty();
                            var option=$("<option>").val("").text("请选择区");
                            areaSelect.append(option);
                            for(var i=0;i<data.data.length;i++){
                                var option=$("<option>").val(data.data[i].areaid).text(data.data[i].areaname);
                                areaSelect.append(option);
                            }
                            form.render();
                        }else{
                        }

                    }
                });
            }


        });
        //购房自己
        form.on('checkbox(hourseMyself)', function(data){
            if(this.checked){
                hourseMyself.push($(this).val())
            }else{
                hourseMyself.pop($(this).val())
            }

        });
        //购房别人
        form.on('checkbox(hourseHis)', function(data){
            if(this.checked){
                hourseHis.push($(this).val())
            }else{
                hourseHis.pop($(this).val())
            }

        });
        //红娘
        form.on('checkbox(matchMaker)', function(data){
            if(this.checked){
                matchmaker_value.push($(this).val())
            }else{
                matchmaker_value.pop($(this).val())
            }

        });
        form.on('radio(marriedValue)', function (data) {
            // alert(data.elem);
            //console.log(data.elem);
            // alert(data.value);//判断单选框的选中值
            if (data.value == '01') {
                $("input[type=radio][name=childrenValue][value='03']").attr("checked",true);
                $("input[type=radio][name=childrenAgeValue][value='01']").attr("checked",true);
                form.render();
                // $("#childrenValue").val('03');
                // $("#childrenAgeValue").val('01');
            }
            else  {

                $("input[type=radio][name=childrenValue][value='03']").attr("checked",false);
                $("input[type=radio][name=childrenAgeValue][value='01']").attr("checked",false);
                form.render();
            }
            // form.render("#childrenValue");
            // form.render("#childrenAgeValue");
        });

        //自我介绍
        form.on('checkbox(changeMyself)', function(data){
            if(this.checked){
                self_value.push($(this).val())
            }else{
                self_value.pop($(this).val())
            }

        });

        //表单提交
        form.on('submit(*)', function(data){



            // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象15764506795
            // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回411421199608097210
           // 表单数据
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            // 添加表单额外数据
            var formData = data.field;
            if(matchmaker_value.length<1){
                layer.msg('请选择红娘', {
                    offset: '6px'
                });
                return false;
            }
            $.extend(formData, { myselfIntroduceValue: self_value.toString()});
            $.extend(formData, { expectedConditionsValue: expect_value.toString()});
            $.extend(formData, { owninghouseValue: hourseMyself.toString()});
            $.extend(formData, { otherOwninghouseValue: hourseHis.toString()});
            //红娘
            $.extend(formData, { matchmakerRemarks: matchmaker_value.toString()});

            var uploadedPhoto = $('#uploadedPhoto tr')
            if (uploadedPhoto){
                for (var i = 0; i < uploadedPhoto.length; i++){
                    photoFile.push($(uploadedPhoto[i]).attr('id'))
                }
                $.extend(formData, {photoFile: photoFile.toString()})
                photoFile = []
            }

            var uploadedVideo = $('#uploadedVideo tr')
            if (uploadedVideo){
                for (var i = 0; i < uploadedVideo.length; i++){
                    videoFile.push($(uploadedVideo[i]).attr('id'))
                }
                $.extend(formData, {videoFile: videoFile.toString()})
                videoFile = []
            }

            $.extend(formData, {nPhotoFile:nPhotoFile.toString()})
            $.extend(formData, {nVideoFile:nVideoFile.toString()})

            //ajax方法请求后台
            $.ajax({
                data: formData,
                type: "POST",
                dataType: "JSON",
                url: ctx+"vip/editVip",
                beforeSend: function () {
                    // 禁用
                    $("#btnSave").addClass('layui-btn-disabled');
                },
                complete: function () {
                    // 启用
                    $("#btnSave").removeClass('layui-btn-disabled');
                },
                success: function (result) {
                    console.info("保存数据成功，返回的数据为：↓ ");
                    console.info(result);
                    if(result.code=="0000"){
                        layer.msg('提交成功', {
                            offset: '6px'
                        });
                        parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);

                    }else{
                        layer.msg(result.message, {
                            offset: '6px'
                        });
                    }

                }
            });

            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });



    });


    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthday' //指定元素
        });
        // //执行一个laydate实例
        // laydate.render({
        //     elem: '#registerDate' //指定元素
        // });
    });


function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

function generateRows(id, list){
    var htmlStr = [];
    for (i in list){
        htmlStr.push("<tr id='"+list[i].data.id+"'>");
        htmlStr.push("<td>"+list[i].data.fileName+"</td>");
        htmlStr.push("<td>");
        htmlStr.push("<div class='layui-btn layui-btn-xs layui-btn-danger' onclick='deleteConfirm(\""+ list[i].data.id +"\",\"" + list[i].data.fileName + "\")'>删除</div>")
        htmlStr.push("</td>");
        htmlStr.push("</tr>")
    }
    $('#' + id).append(htmlStr.join(''))
}

function notRealDeleteConfirm(id, fileName, type){
    layer.confirm('是否删除文件'+ fileName +'?', function(){
        layer.alert("删除成功", {icon: 6},function (i) {
            $('#' + id).remove()
            if (type == 'photo'){
                nPhotoFile.push(id)
            } else {
                nVideoFile.push(id)
            }
            layer.close(i)
        });
    })
}

function deleteConfirm(id, fileName){
    layer.confirm('是否删除文件'+ fileName +'?', function(){
        $.ajax({
            url : ctx + 'deleteFile',
            type:'post',
            dataType:'json',
            data:{
                id:id
            },
            success:function(data){
                if (data.code == '0000') {
                    layer.alert("删除成功", {icon: 6},function (i) {
                        $('#' + id).remove()
                        layer.close(i)
                    });
                }else {
                    layer.alert("删除失败", {icon: 5},function (i) {
                        layer.close(i)
                    });
                }
            }
        })
    })
}

function loadUploadedFile(id) {
    $.ajax({
        url: ctx + 'vip/getVipPhotoFile',
        type: 'post',
        dataType: 'json',
        data: {
            id : id
        },
        success: function(data){
            if (data.code == '0000'){
                var data = data.data
                var htmlStr = [];
                for (i in data){
                    htmlStr.push("<tr id='"+data[i].id+"'>");
                    htmlStr.push("<td>"+data[i].fileName+"</td>");
                    htmlStr.push("<td>");
                    htmlStr.push("<div class='layui-btn layui-btn-xs layui-btn-danger' onclick='notRealDeleteConfirm(\""+ data[i].id +"\",\"" + data[i].fileName + "\",\"photo\")'>删除</div>")
                    htmlStr.push("</td>");
                    htmlStr.push("</tr>")
                }
                $('#uploadedPhoto').append(htmlStr.join(''))
            } else {
                layer.alert(data.message, {icon: 5},function (i) {
                    layer.close(i)
                });
            }
        }
    })

    $.ajax({
        url: ctx + 'vip/getVipVideoFile',
        type: 'post',
        dataType: 'json',
        data: {
            id : id
        },
        success: function(data){
            if (data.code == '0000'){
                var data = data.data
                var htmlStr = [];
                for (i in data){
                    htmlStr.push("<tr id='"+data[i].id+"'>");
                    htmlStr.push("<td>"+data[i].fileName+"</td>");
                    htmlStr.push("<td>");
                    htmlStr.push("<div class='layui-btn layui-btn-xs layui-btn-danger' onclick='notRealDeleteConfirm(\""+ data[i].id +"\",\"" + data[i].fileName + "\",\"video\")'>删除</div>")
                    htmlStr.push("</td>");
                    htmlStr.push("</tr>")
                }
                $('#uploadedVideo').append(htmlStr.join(''))
            } else {
                layer.alert(data.message, {icon: 5},function (i) {
                    layer.close(i)
                });
            }
        }
    })
}

