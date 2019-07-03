/**
 * Created by yangzy on 2018/6/7.
 */
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 1,
    func: 'loadData'
};

$(function(){
    loadData(opts.current_page, opts.items_per_page);

    $('#search').on('click', function () {
        loadData(opts.current_page, opts.items_per_page);
    });

    $('#deleteAll').on('click', function () {
        layui.use(['table'], function () {
            var table = layui.table;
            var checkStatus = table.checkStatus('id');
            var data = checkStatus.data;
            var ids = [];
            if(data.length > 0){
                for(k in data){
                    ids.push(data[k].id);
                }
                layer.confirm('是否删除选中人员?', function (index) {
                    $.ajax({
                        url:ctx+'user/deleteAll',
                        type:'post',
                        dataType:'json',
                        contentType:'application/json',
                        data:JSON.stringify(ids),
                        success:function (data) {
                            if (data.code == '0000') {
                                layer.alert("删除成功", {icon: 6},function (i) {
                                    //关闭当前frame
                                    loadData(opts.current_page, opts.items_per_page);
                                    layer.close(i)
                                });
                            }else {
                                layer.alert("删除失败", {icon: 5},function (i) {
                                    //关闭当前frame
                                    layer.close(i)
                                });
                            }
                        }
                    });
                });
            }
        })
    });
});

function loadData(index, size){
    layui.use(['table','layer','laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            id:'id'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'user/data?page=' + index + '&size=' + size + '&searchName=' + $('#searchName').val()//数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'name', title: '人员姓名',width :'20%'}
                ,{field: 'username', title: '登录名',width :'20%'}
                // ,{field: 'companyName', title: '所属公司'}
                ,{field: 'role', title: '角色',width :'10%'}
                ,{field: 'phone', title: '联系方式',width :'20%'}
                ,{title:'操作' ,fixed: 'right', width :'20%', align:'center', toolbar: '#toolbar'}
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
                editCompany(data.id);
            } else if (layEvent == 'del'){
                layer.confirm('是否删除人员<span style="color: #FF5722; font-size: 16px;">'+ data.name +'</span>?', function(index){
                    $.ajax({
                        url : ctx + 'user/delete',
                        type:'post',
                        dataType:'json',
                        data:{
                            id:data.id
                        },
                        success:function(data){
                            if (data.code == '0000') {
                                layer.alert("删除成功", {icon: 6},function (i) {
                                    //关闭当前frame
                                    loadData(opts.current_page, opts.items_per_page);
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
        });
    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

var editCompany = function (id) {
    xadmin.open("编辑人员",ctx + "user/edit?id=" + id, 800, 600)
}