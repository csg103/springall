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
            ,url: ctx + 'gift/list?index=' + index + '&size=' + size+ '&sendId=' + $('#nickName').val()+ '&receiverId=' + $('#paymentType').val() //数据接口
            ,cols: [[
                {field: 'productName', title: '礼物名称'}
                ,{field: 'producePrice', title: '金额'}
                ,{field: 'tCreateTimeStr', title: '送礼时间'}
                ,{field: 'productType', title: '商品类型',templet:function (d) {
                    var dom = ''
                    if(d.productType=="1"){
                        dom += '充值'
                    } else if(d.productType=="2"){
                        dom += '礼物'
                    }else if(d.productType=="3"){
                        dom += '聊天'
                    }else{
                        dom+='其他'
                    }
                    return dom;
                }}
                ,{field: 'sendVipId', title: '发送者会员id'}
                ,{field: 'receiveVipId', title: '接收者会员id'}
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

        // var $ = layui.$, active = {
        //     reload: function(){
        //         var demoReload = $('#vipNumber');
        //         opts.current_page = 1;
        //         table.reload('id', {
        //             where: {
        //                 id: demoReload.val(),
        //                 vipName:$("#vipName").val(),
        //                 vipPhone:$("#vipPhone").val(),
        //             }
        //         });
        //     }
        // };
        // $('.demoTable .layui-btn').on('click', function(){
        //     var type = $(this).data('type');
        //     active[type] ? active[type].call(this) : '';
        // });

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

