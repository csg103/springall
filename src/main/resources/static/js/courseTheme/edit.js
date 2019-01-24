/**
 * Created by yangzy on 2018/6/26.
 */

layui.use(['form','layer'], function () {
    var form = layui.form
        ,layer = layui.layer;

    form.verify({
        fileId:function (value, item) {
            if(value==null || $.trim(value)==''){
                return '焦点图不能为空';
            }
        },
        waitUpload:function (value, item) {
            if(value == 0){
                return '图片正在上传到服务器...';
            }
        }
    });

    form.on('submit(save)', function (data) {
        $.ajax({
            url:ctx+'courseTheme/save',
            type:'post',
            dataType:'json',
            data:data.field,
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

layui.use(['upload'],function(){
    var upload = layui.upload

    var uploadInst = upload.render({
        elem: '#head'
        ,url: ctx + 'upload'
        ,before: function(obj){
            $('#waitUpload').val(0);
            obj.preview(function(index, file, result){
                $('#fileView').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(data){
            if(data.code == '0000'){
                $('#fileId').val(data.data.id);
                $('#waitUpload').val(1);
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