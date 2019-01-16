var loading;
var url="";
var dataUrl = "";
$(function(){



    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;



        // //自定义验证规则
        // form.verify({
        //     name: function(value){
        //         if(value.length < 0){
        //             return '请填写名称';
        //         }
        //     },
        //     totalFee: function(value){
        //         if (value.length < 0){
        //             return '请填写价格!';
        //         }
        //     }
        // });

        //监听提交
        form.on('submit(add)', function(data){

            $.ajax({
                url:ctx + "store/saveAdd",
                type:'post',
                dataType:'json',
                data:data.field,
                traditional:true,
                success:function(data){
                    if (data.code == '0000'){
                        layer.alert("增加成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("增加失败 " + data.message, {icon: 5},function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
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
                    $('#addPic').val(data.data.url)

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

        var uploadInst = upload.render({
            elem: '#videos'
            ,url: ctx + 'upload'
            ,accept:'file'
            ,before: function(obj){
                obj.preview(function(index, file, result){
                    loading = layer.load(1, {
                        shade: [0.5,'#000'] //0.1透明度的背景
                    });
                    $('#videos').attr("disabled",true);
                    $('#L_roles').attr("disabled",true);
                });
            }
            ,done: function(data){
                if(data.code == '0000'){
                    layer.close(loading);
                    layer.msg('上传成功');
                    $('#videos').attr("disabled",false);
                    $('#L_roles').attr("disabled",false);
                    $('#addUrl').val(data.data.url)
                    dataUrl= data.data.url;
                    if(url!=""){
                        $.ajax({
                            url : ctx + 'deleteFileByUrl',
                            type:'post',
                            dataType:'json',
                            data:{
                                url:url
                            },
                            success:function(data){
                                if (data.code == '0000') {
                                    console.log("删除成功")
                                    url = dataUrl;
                                }else {

                                }
                            }
                        })
                    }else{
                        url= data.data.url;
                    }
                }else {
                    layer.close(index);
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                var fileText = $('#fileText1');
                fileText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                fileText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    })




})