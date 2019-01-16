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
var matchmaker_value =[];
var photoFile = [];
var videoFile = [];
var hourseMyself=[];
var hourseHis=[];
var nPhotoFile = [];
var nVideoFile = [];
$(function(){
    //$("#isLiveChildren").prop('checked')  多选框选中
    $("#idCardNum").keyup(function () {
        var idCard = $("#idCardNum").val();
        if(idCard.length==15||idCard.length==18){
            var birthdayDate = getBirthDayFromIdCard(idCard);
            $("#birthday").val(birthdayDate);
        }
    })
    $("#mobilePhone").blur(function () {
        $.ajax({
            data: {

            },
            type: "POST",
            dataType: "JSON",
            url: ctx+"vip/phone/"+$("#mobilePhone").val(),
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

    // $("#marriedValue").click(function () {
    //     if($(this).val()=='01'){
    //         $("#childrenValue").val('03');
    //         $("#childrenAgeValue").val('01');
    //     }
    // })
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
        form.on('select(selectProvince)', function(data){
            if(data!=null){
                var citySelect=$('#citySelect');
                var areaSelect=$('#areaSelect');
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
        form.on('select(selectCity)', function(data){
            if(data!=null){
                var areaSelect=$('#areaSelect');
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
                            citySelect.append(option);
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

            // 添加表单额外数据
            var formData = data.field;
            if(self_value.length<3){
                layer.msg('请选择至少三项自我介绍', {
                    offset: '6px'
                });
                return false;
            }
            if(matchmaker_value.length<1){
                layer.msg('请选择红娘', {
                    offset: '6px'
                });
                return false;
            }
            if(expect_value.length<3){
                layer.msg('请选择至少三项期待条件', {
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


            //ajax方法请求后台
            $.ajax({
                data: formData,
                type: "POST",
                dataType: "JSON",
                url: ctx+"vip/addVip",
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
                    console.info(result.data);
                    if(result.code=="0000"){
                        parent.layer.msg('提交成功,您的会员卡号为：'+result.data, {
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


        //保存表单提交
        form.on('submit(saveBtn)', function(data){

            // 添加表单额外数据
            var formData = data.field;
            //红娘
            $.extend(formData, { matchmakerRemarks: matchmaker_value.toString()});
            $.extend(formData, { otherOwninghouseValue: hourseHis.toString()});
            $.extend(formData, { owninghouseValue: hourseMyself.toString()});
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

            $.ajax({
                data: formData,
                type: "POST",
                dataType: "JSON",
                url: ctx+"vip/addVip",
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

                    console.info(result.data);
                    if(result.code=="0000"){

                        $("#idNumber").val(result.data);
                        parent.layer.msg('保存成功,您的会员卡号为：'+result.data, {
                            offset: '6px'
                        });
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
        //执行一个laydate实例
        laydate.render({
            elem: '#registerDate' //指定元素
        });
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

function getBirthDayFromIdCard(idCard) {

    var birthday = "";
    if(idCard != null && idCard != ""){
        if(idCard.length == 15){
            birthday = "19"+idCard.substr(6,6);
        } else if(idCard.length == 18){
            birthday = idCard.substr(6,8);
        }

        birthday = birthday.replace(/(.{4})(.{2})/,"$1-$2-");
    }

    return birthday;

}
