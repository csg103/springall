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
            ,url: ctx + 'balance/list?index=' + index + '&size=' + size+'&sendId=' + $('#nickName').val() //数据接口
            ,cols: [[
                {field: 'nickName', title: '用户昵称'}
                ,{field: 'bindVipId', title: '绑定会员Id'}
                ,{field: 'balance', title: '余额'}
                ,{field: 'withdrawBalance', title: '可提现余额'}
                ,{field: 'avatarUrl',title:'头像' ,templet:function(d){
                    var dom = ''
                    if(d.avatarUrl!=null&&d.avatarUrl!=''){
                        dom += '<img src="'+d.avatarUrl+'"   onclick="javascript:window.open(this.src)" style="cursor: pointer; width: 30px;height: 30px;"  />'
                    }else{
                        var dom = '<span>--</span>'
                    }
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
           if (layEvent == 'edit'){
                x_admin_show("余额修改",ctx + "balance/edit?id=" + data.id, 500, 300)
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

