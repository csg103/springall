/**
 * Created by yangzy on 2018/6/26.
 */
var videoFile = [];

layui.use(['form','layer'], function () {
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer;

    form.verify({
        video:function (value, item) {
            var uploadedVideo = $('#uploadedVideo tr');
            if(uploadedVideo.length < 1){
                return '请上传一个视频';
            }
            if(uploadedVideo.length > 1){
                return '此处只能上传一个视频';
            }
        }
    })

    form.on('submit(add)', function (data) {
        // 添加表单额外数据
        var formData = data.field;
        var uploadedVideo = $('#uploadedVideo tr')
        if (uploadedVideo){
            for (var i = 0; i < uploadedVideo.length; i++){
                videoFile.push($(uploadedVideo[i]).attr('id'))
            }
            $.extend(formData, {videoFile: videoFile.toString()})
            videoFile = []
        }

        $.ajax({
            url:ctx+'courseVideo/add',
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

layui.config({
    base:ctx + "third_party/layui/lay/modules/"
}).use(['mupload'],function(){
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
    $('#' + id).append(htmlStr.join(''));
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
};