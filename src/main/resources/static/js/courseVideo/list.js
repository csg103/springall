/**
 * Created by yangzy on 2018/6/26.
 */
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 1,
    func: 'loadData'
};

$(function () {
    loadData(opts.current_page, opts.items_per_page);

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
                layer.confirm('是否删除选中视频?', function (index) {
                    $.ajax({
                        url:ctx+'courseVideo/deleteAll',
                        type:'post',
                        dataType:'json',
                        contentType:'application/json',
                        data:JSON.stringify(ids),
                        success:function (data) {
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
                    });
                });
            }
        })
    });
});

function loadData(index, size){
    layui.use(['table','layer'], function () {
        var table = layui.table
            ,layer = layui.layer;

        var courseThemeId = $('#courseThemeId').val();
        table.render({
            id:'id'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'courseVideo/listAjax?index=' + index + '&size=' + size + '&courseThemeId=' + courseThemeId //数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'courseVideoName', title: '视频名称', width:'70%'}
                ,{field: 'courseVideoOrder', title: '排序'}
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
                editVideo(data.id);
            } else if (layEvent == 'del'){
                layer.confirm('是否删除课程视频'+data.courseVideoName+'?', function(index){
                    $.ajax({
                        url : ctx + 'courseVideo/delete',
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
        });
    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

var addVideo = function () {
    var courseThemeId = $('#courseThemeId').val();
    var add = layer.open({
        type:2,
        title:['添加视频', 'font-size:12px'],
        content:ctx + 'courseVideo/toAdd?courseThemeId='+courseThemeId,
        area:['100%', '100%']
    });
}

var editVideo = function (id) {
    var edit = layer.open({
        type:2,
        title:['编辑视频', 'font-size:12px'],
        content:ctx + 'courseVideo/edit?id='+id,
        area:['100%', '100%']
    })
}