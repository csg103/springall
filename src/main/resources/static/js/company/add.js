/**
 * Created by yangzy on 2018/6/9.
 */
var photoFile = [];
var videoFile = [];

$(function () {

    layui.use(['form', 'layer', 'laydate'], function () {

        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer
            ,laydate = layui.laydate;

        laydate.render({
            elem: '#openingTime'
            ,type: 'time'
            ,range: true
            ,format: 'HH:mm:ss'
            ,value: '09:00:00 - 18:00:00'
        });

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

        form.on('submit(add)', function (data) {
            // 添加表单额外数据
            var formData = data.field;
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
                url:ctx+'company/add',
                type:'post',
                dataType:'json',
                data:formData,
                success:function (data) {
                    if(data.code == '0000'){
                        layer.alert("增加成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    }else{
                        layer.alert("增加失败 " + data.message, {icon: 5},function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
        });
    });
});

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