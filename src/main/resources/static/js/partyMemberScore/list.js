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

    $('#searchMes').on('click', function () {
console.log('搜索·····')
        loadData(opts.current_page, opts.items_per_page);
    });

    $('#addBaseScore').on('click', function () {
       var year = $('#year').val();
        $.ajax({
            url:ctx+'partyMemberScore/addBaseScore?year='+year,
            type:'get',
            dataType:'json',
            contentType:'application/json',

            success:function (data) {
                if (data.code == '0000') {
                    layer.alert("生成数据成功", {icon: 6},function (i) {
                        //关闭当前frame
                        // loadData(opts.current_page, opts.items_per_page);
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
});

function loadData(index, size){
    console.log( ctx + 'partyMemberScore/data?page=' + index + '&size=' + size + '&searchTime=' + $('#searchTime').val()+ '&departmentid=' + $('#departmentid').val());
    layui.use(['table','layer','laytpl'], function(){
        var table = layui.table;
        //第一个实例
        table.render({
            id:'partMemberscoreId'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'partyMemberScore/data?page=' + index + '&size=' + size + '&searchTime=' + $('#searchTime').val()+ '&departmentid=' + $('#departmentid').val()//数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'name', title: '党员姓名',width :'10%'}
                ,{field: 'year', title: '年度',width :'10%'}
                ,{field: 'score', title: '分数',width :'10%'}
                ,{field: 'departmentName', title: '部门',width :'20%'}



                ,{field: 'isLeader', title: '是否为组长',  width:'20%' ,templet: function (d) {
                    var dom = ''
                    if (d.isLeader == '1'){
                        dom += '<a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:;">党员'
                        dom += '<a class="layui-btn layui-btn-xs" href="javascript:;">组长'
                    } else {
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
                editCompany(data);
            } else if (layEvent == 'look'){
                viewCompany(data.partMemberscoreId);
               // editCompany(data.partMemberscoreId);
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

var editCompany = function (data) {
    xadmin.open("编辑个人年度分数",ctx + "partyMemberScore/detail?id=" + data.partMemberscoreId+'&year='+data.year,'','');
}
var viewCompany = function (id) {
    xadmin.open("查看个人年度分数", ctx + "partyMemberScore/detail?view=1&id=" + id, '', '')
}
