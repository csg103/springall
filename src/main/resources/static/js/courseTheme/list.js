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
                layer.confirm('是否删除选中课程?（请谨慎，删除主题课程将会一并删除该主题下的视频）', function (index) {
                    $.ajax({
                        url:ctx+'courseTheme/deleteAll',
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
    layui.use(['table','layer','laytpl'], function(){
        var table = layui.table;

        table.render({
            id:'id'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'courseTheme/listAjax?index=' + index + '&size=' + size //数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'id', title: 'ID', }
                ,{field: 'courseThemeName', title: '课程主题名称', width:'60%'}
                ,{field: 'courseThemeOrder', title: '排序', width:'20%'}
                ,{title:'操作' ,fixed: 'right', width:200, align:'center', toolbar: '#toolbar'}
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
                detail(data.id);
            } else if (layEvent == 'edit'){
                editCourse(data.id);
            } else if (layEvent == 'del'){
                layer.confirm('是否删除主题课程'+data.courseThemeName+'?（请谨慎，删除主题课程将会一并删除该主题下的视频）', function(index){
                    $.ajax({
                        url : ctx + 'courseTheme/delete',
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

var addCourse = function () {
    var add = layer.open({
        type:2,
        title:['添加主题', 'font-size:12px'],
        content:ctx + 'courseTheme/toAdd',
        area:['100%', '100%']
    });
}

var editCourse = function (id) {
    var edit = layer.open({
        type:2,
        title:['编辑主题', 'font-size:12px'],
        content:ctx + 'courseTheme/edit?id=' + id,
        area:['100%', '100%']
    });
}

var detail = function (id) {
    var detail = layer.open({
        type:2,
        title:['视频列表', 'font-size:12px'],
        content:ctx + 'courseVideo/list?courseThemeId=' + id,
        area:['100%', '100%']
    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}