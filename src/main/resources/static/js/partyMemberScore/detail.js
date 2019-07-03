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
;
    loadData(opts.current_page, opts.items_per_page);

    $('#addScore').on('click', function () {
     var id =$('#id').val();
        xadmin.open("编辑个人年度分数",ctx + "partyMemberScore/add?id=" + id,800, 600);
    });



    $('#search').on('click', function () {
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


    $('#deleteAll').on('click', function () {
console.log(11111111111)
        layui.use(['table'], function () {
            var table = layui.table;
            var checkStatus = table.checkStatus('scoreDetilId');
            var data = checkStatus.data;
            var ids = [];
            console.log(data);
            if(data.length > 0){

                for(k in data){
                    ids.push(data[k].scoreDetilId);
                }
                layer.confirm('是否删记录?', function (index) {
                    $.ajax({
                        url:ctx+'partyMemberScore/deleteScoreDetile',
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
            id:'scoreDetilId'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'partyMemberScore/dataDetail?page=' + index + '&size=' + size + '&year=' + $('#year').val() +'&id='+$('#id').val()//数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'name', title: '党员姓名',width :'10%'}
                ,{field: 'departmentName', title: '部门',width :'10%'}
                ,{field: 'pipName', title: '项目分类',width :'20%'}
                ,{field: 'pip', title: '标准',width :'10%'}
                ,{field: 'yearString', title: '年度',width :'5%'}
                ,{field: 'operatortime', title: '时间',width :'15%'}
                ,{field: 'remake1', title: '加/扣分1',width :'10%'}
                ,{field: 'scorePip', title: '分值',width :'5%'}


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
                viewCompany(data.partMemberscoreId);
            } else if (layEvent == 'edit'){
                // layer.msg(JSON.stringify(data))
               editCompany(data.partMemberscoreId);
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
    xadmin.open("编辑个人年度分数", ctx + "partyMemberScore/add?id=" + id, '', '')
}

