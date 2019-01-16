var loading;
var url="";
var dataUrl = "";
$(function(){


    url = $('#editUrl').val();
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;


        //监听提交
        form.on('submit(edit)', function(data){
            console.log(data.field);

            $.ajax({
                url:ctx + "store/update",
                type:'post',
                dataType:'json',
                data:data.field,
                traditional:true,
                success:function(data){
                    if (data.code == '0000'){
                        layer.alert("修改成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("修改成功 " + data.message, {icon: 5},function (index) {
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
            elem: '#headEdit'
            ,url: ctx + 'upload'
            ,before: function(obj){
                obj.preview(function(index, file, result){
                    $('#editFileView').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(data){
                if(data.code == '0000'){
                    $('#editPic').val(data.data.url)

                }else {
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                var fileText = $('#editFileText');
                fileText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                fileText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        var uploadInst = upload.render({
            elem: '#videosEdit'
            ,url: ctx + 'upload'
            ,accept:'file'
            ,before: function(obj){
                obj.preview(function(index, file, result){
                    loading = layer.load(1, {
                        shade: [0.5,'#000'] //0.1透明度的背景
                    });
                    $('#videosEdit').attr("disabled",true);
                    $('#L_roles').attr("disabled",true);
                });
            }
            ,done: function(data){
                if(data.code == '0000'){
                    layer.close(loading);
                    layer.msg('上传成功');
                    $('#videosEdit').attr("disabled",false);
                    $('#L_roles').attr("disabled",false);
                    $('#editUrl').val(data.data.url)
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
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                var fileText = $('#editFileText1');
                fileText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                fileText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    })

})