/**
 * Created by yangzy on 2018/6/10.
 */
var photoFile = [];
var videoFile = [];
var nPhotoFile = [];
var nVideoFile = [];

$(function () {
    layui.use(['form', 'layer', 'laydate'], function () {
        $ = layui.jquery;  //$表示layui中的jQuery对象
        var form = layui.form
            ,layer = layui.layer
            ,laydate = layui.laydate;

        laydate.render({
            elem: '#openingTime'
            ,type: 'time'
            ,range: true
            ,format: 'HH:mm:ss'
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

        form.on('submit(save)', function (data) {
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
            $.extend(formData, {nPhotoFile:nPhotoFile.toString()})
            $.extend(formData, {nVideoFile:nVideoFile.toString()})
            $.ajax({
                url:ctx+'company/save',
                type:'post',
                dataType:'json',
                data:formData,
                success:function (data) {
                    if(data.code == '0000'){
                        layer.alert("保存成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    }else{
                        layer.alert("保存失败 " + data.message, {icon: 5},function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
        });
    });

    uploadEdit($('#hiddenId').val());
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

var uploadEdit = function (id) {
    $.ajax({
        url:ctx+'company/uploadedPhoto',
        type:'post',
        dataType:'json',
        data:{
            id:id
        },
        success:function (data) {
            if (data.code == '0000'){
                var data = data.data
                var htmlStr = [];
                for (i in data){
                    htmlStr.push("<tr id='"+data[i].sourceId+"'>");
                    htmlStr.push("<td>"+data[i].sourceName+"</td>");
                    htmlStr.push("<td>");
                    htmlStr.push("<div class='layui-btn layui-btn-xs layui-btn-danger' onclick='notRealDeleteConfirm(\""+ data[i].sourceId +"\",\"" + data[i].sourceName + "\",\"photo\")'>删除</div>")
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
    });

    $.ajax({
        url:ctx+'company/uploadedVideo',
        type:'post',
        dataType:'json',
        data:{
            id:id
        },
        success:function (data) {
            if (data.code == '0000'){
                var data = data.data
                var htmlStr = [];
                for (i in data){
                    htmlStr.push("<tr id='"+data[i].sourceId+"'>");
                    htmlStr.push("<td>"+data[i].sourceName+"</td>");
                    htmlStr.push("<td>");
                    htmlStr.push("<div class='layui-btn layui-btn-xs layui-btn-danger' onclick='notRealDeleteConfirm(\""+ data[i].sourceId +"\",\"" + data[i].sourceName + "\",\"video\")'>删除</div>")
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
    });
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