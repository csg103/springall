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
    layui.use(['table','layer','laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            id:'id'
            ,elem: '#demo'
            ,height: 315
            ,url: ctx + 'role/data?index=' + index + '&size=' + size //数据接口
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'roleName', title: '角色名'}
                ,{field: 'roleDescription', title: '描述', width:'50%'}
                ,{field: 'roleStatus', title: '状态', templet: function (d) {
                        var dom = ''
                        if (d.roleStatus == 1){
                            dom += '<a class="layui-btn layui-btn-xs" href="javascript:;">启用'
                        } else {
                            dom += '<a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:;">停用'
                        }
                        dom += '</a>'
                        return dom;
                    }}
                ,{title:'操作' ,fixed: 'right', width:150, align:'center', toolbar: '#toolbar'}
            ]],
            response:{
                statusName: 'code',
                status: '0000',
                msgName: 'message',
                countName:'total',
                dataName:'data'
            },
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
                x_admin_show("角色编辑", ctx + 'role/edit?id=' + data.id, 600, 400);
            } else if (layEvent == 'del'){
                layer.confirm('是否删除角色<span style="color: #FF5722; font-size: 16px;">'+ data.roleName +'</span>?', function(index){
                    $.ajax({
                        url : ctx + 'role/delete',
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
                })
            }
        })

    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

