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
            var checkStatus = table.checkStatus('partyid');
            var data = checkStatus.data;
            var ids = [];
            console.log(data);
            if(data.length > 0){

                for(k in data){
                    ids.push(data[k].partyid);
                }
                layer.confirm('是否删除选中人员?', function (index) {
                    $.ajax({
                        url:ctx+'party/deleteAll',
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

    layui.use(['table'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            id:'partyid'
            ,elem: '#demo'
            ,height: 430
            ,url: ctx + 'party/data?page=' + index + '&size=' + size + '&partyname=' + $('#searchName').val()//数据接口
            ,method: 'post'
            ,where:{index: index, size: size}
            ,cols: [[
                {type:'checkbox'}
                // ,{field: 'partyid', title: 'partyid', }
                ,{field: 'partyname', title: '会议名称',width :'20%'}
                ,{field: 'typeName', title: '类型',width :'10%'}
                // ,{field: 'companyName', title: '所属公司'}
                ,{field: 'partyadress', title: '会议地点',width :'20%'}
                ,{field: 'partytime', title: '会议时间',width :'15%', templet : "<div>{{layui.util.toDateString(d.partytime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>"}
                ,{field: 'oper', title: '添加人',width :'10%'}
                ,{field: 'opertime', title: '添加时间',width :'15%', templet : "<div>{{layui.util.toDateString(d.opertime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>"}


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
                editCompany(data.partyid);
            } else if (layEvent == 'uploadPic'){
                // console.log(JSON.stringify(data))
                uploadPic(data.partyid);
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

    xadmin.open("编辑人员", ctx + "party/edit?id=" + id, '', '')
}

var uploadPic = function (id) {
    console.log(ctx + "party/uploadPicTab?id=" + id)
    xadmin.open("上传会议记录", ctx + "party/uploadPicTab?id=" + id, '', '')
}
