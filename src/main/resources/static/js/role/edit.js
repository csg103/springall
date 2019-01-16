$(function(){
    $('#permissionTree').css({'margin-left':($('body').width() - $('#permissionTree').width())/2})
    $('#permissionTree').jstree({
        core:{
            check_callback: true,
            themes: {
                // "responsive": false,
                "icons": false,
                // "stripes" : true
            },
            data:{
                'url': function (node) {
                    return ctx + 'permission/getTreeWithState';
                },
                'data': function (node) {
                    return {'pid': node.id, 'roleId' : $('#id').val()};
                }
            },
        },
        types: {
            "default": {
                "icon": "fa fa-folder icon-state-warning icon-lg"
            },
            "file": {
                "icon": "fa fa-file icon-state-warning icon-lg"
            }
        },
        plugins: ["types","themes","checkbox"]
    });

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(add)', function(data){

            var ref = $('#permissionTree').jstree(true),
                checked = ref.get_selected(),
                undetermined = ref.get_undetermined()

            for (var i in undetermined){
                checked.push(undetermined[i])
            }

            data.field.checked = checked;

            $.ajax({
                url:ctx + "role/saveEdit",
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
})