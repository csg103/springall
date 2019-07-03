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
                        url:ctx+'partyMember/deleteAll',
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
            id:'partymemberid'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'partyMember/data?page=' + index + '&size=' + size + '&searchName=' + $('#searchName').val()//数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'name', title: '党员姓名',width :'20%'}
                ,{field: 'tel', title: '电话',width :'10%'}
                // ,{field: 'companyName', title: '所属公司'}
                ,{field: 'departmentname', title: '所属部门',width :'10%'}
                ,{field: 'partymembergroupname', title: '所属小组',width :'10%'}



                ,{field: 'isleader', title: '是否为组长',  width:'20%' ,templet: function (d) {
                    var dom = ''
                    if (d.isleader == 1){
                        dom += '<a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:;">党员'
                        dom += '<a class="layui-btn layui-btn-xs" href="javascript:;">组长'
                    } else if(d.isleader == 2) {
                        dom += '<a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:;">党员'
                        dom += '<a class="layui-btn layui-btn-xs" href="javascript:;">党委员'
                    }else{
                        dom += '<a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:;">党员'
                    }
                    dom += '</a>'
                    return dom;
                }}
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
                // layer.msg(JSON.stringify(data))
               editCompany(data.parytmemberid);
            } else if (layEvent == 'del'){
                layer.confirm('是否删除人员<span style="color: #FF5722; font-size: 16px;">'+ data.name +'</span>?', function(index){
                    $.ajax({
                        url : ctx + 'partyMember/delete',
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
    xadmin.open("编辑人员", ctx + "partyMember/edit?id=" + id, '', '')
}