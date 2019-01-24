var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 1,
    func: 'loadData'
};

var loginCompanyId = "";
$(function(){
    loginCompanyId =$("#loginCompanyId").val();
    loadData(opts.current_page, opts.items_per_page)
})
function viewDetail(data){
    parent.window.open(ctx + 'vip/vipShow?vipId='+data);

}
function editDetail(data){
    var index = layer.open({
        type: 2,
        content: ctx + "vip/vipEdit?vipId="+data,
        area: ['100%', '100%'],
        maxmin: false,
    });
    layer.full(index);
}
function deleteDetail(data) {
    layer.confirm('确定删除?', function(index){
        $.ajax({
            data: {
                vipId:data
            },
            type: "POST",
            dataType: "JSON",
            url: ctx+"vip/deleteVip",
            success: function (result) {
                console.info(result);
                if(result.code=="0000"){
                    layer.msg('删除成功', {
                        offset: '6px'
                    });
                    loadData(opts.current_page, opts.items_per_page)

                }else{
                    layer.msg(result.message, {
                        offset: '6px'
                    });
                }
                layer.close(index)

            }
        });
        // obj.del()

    })
}

function loadData(index, size){
    layui.use(['table','layer', 'laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#vipTable'
            ,height: 450
            ,url: ctx + 'complain/list?index=' + index + '&size=' + size+ '&sendId=' + $('#nickName').val() //数据接口
            ,cols: [[
                {field: 'complainInfo', title: '投诉信息'}
                ,{field: 'userId', title: '投诉人id'}
                ,{field: 'dateStr', title: '投诉时间'}
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
                // alert(loginCompanyId)
                opts.current_page = res.currentPage - 1;
                generatePagination(res.total)
            }
        });

        table.on('tool(vip_table)', function(obj){
            var data = obj.data
            var layEvent = obj.event
            var tr = obj.tr
             if (layEvent == 'detail'){
                x_admin_show("详情查看",ctx + "complain/edit?id=" + data.id, 700, 800)
            }
        })

    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}

function addVip(data) {

    var index = layer.open({
        type: 2,
        content: ctx + "vip/vipAdd",
        area: ['100%', '100%'],
        maxmin: false,
    });
    layer.full(index);
    // x_admin_show("增加会员",ctx + "vip/vipAdd")
}

function matchVip(id) {
    location.href = ctx + 'vip/toMatch/' + id
}

