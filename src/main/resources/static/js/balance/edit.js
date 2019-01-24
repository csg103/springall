$(function(){



    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;


        //监听提交
        form.on('submit(edit)', function(data){
            console.log(data.field);

            $.ajax({
                url:ctx + "balance/update",
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


})