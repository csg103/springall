/**
 * Created by yangzy on 2018/6/10.
 */
$(function () {
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;  //$表示layui中的jQuery对象
        var form = layui.form
            ,layer = layui.layer;

        form.on('submit(save)', function (data) {
            console.log(data.field);
            $.ajax({
                url:ctx+'matchMaker/save',
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
});