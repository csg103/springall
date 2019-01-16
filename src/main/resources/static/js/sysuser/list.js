// magic!don't touch!
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 1,
    func: 'loadData'
};


$(function(){
    loadData(opts.current_page, opts.items_per_page)
})



function loadData(index, size){
    layui.use(['table','layer', 'laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            id:'id'
            ,elem: '#demo'
            ,height: 315
            ,url: ctx + 'user/listAjax?index=' + index + '&size=' + size //数据接口
            ,cols: [[
                {type:'checkbox'}
                ,{field: 'username', title: '用户名'}
                ,{field: 'name', title: '姓名'}
                ,{title:'操作' ,fixed: 'right', width:150, align:'center', toolbar: '#toolbar'}
            ]],
            response:{
                statusName: 'code',
                status: '0000',
                msgName: 'message',
                countName:'total',
                dataName:'data'
            },
            id:'id',
            done:function(res, curr, count){
                opts.current_page = res.currentPage - 1
                generatePagination(res.total)
            }
        });

        table.on('tool(user_table)', function(obj){
            var data = obj.data
            var layEvent = obj.event
            var tr = obj.tr
            if (layEvent == 'detail'){
                layer.msg(JSON.stringify(data))
            } else if (layEvent == 'edit'){
                x_admin_show("用户修改",ctx + "user/edit?id=" + data.id, 600, 400)
            } else if (layEvent == 'del'){
                layer.confirm('删除用户' + data.name + '?', function(index){
                    $.ajax({
                        url: ctx + 'user/delete',
                        type:'post',
                        dataType:'json',
                        data:{
                            id:data.id
                        },
                        success:function(data){
                            if (data.code == '0000') {
                                layer.alert("删除成功", {icon: 6},function (i) {
                                    //关闭当前frame
                                    loadData(opts.current_page, opts.items_per_page)
                                    layer.close(i)
                                });
                            }else {
                                layer.alert("删除失败", {icon: 5},function (i) {
                                    //关闭当前frame
                                    layer.close(i)
                                });
                            }
                        }
                    })
                    layer.close(index)
                })
            }
        })

    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

