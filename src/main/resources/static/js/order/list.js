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
            ,url: ctx + 'order/list?index=' + index + '&size=' + size+ '&userId=' + $('#nickName').val()+ '&paymentStatus=' + $('#paymentType').val() //数据接口
            ,cols: [[
                {field: 'mchId', title: '商户id', width:120}
                ,{field: 'body', title: '金额', width:80}
                ,{field: 'timeStartStr', title: '交易开始时间', width:160}
                ,{field: 'timeExpireStr', title: '交易结束时间', width:160}
                ,{field: 'paymentStatus', title: '付款状态',width:120,templet:function (d) {
                    var dom = ''
                        if(d.paymentStatus=="1"){
                                dom += '待付款'
                            } else if(d.paymentStatus=="2"){
                                dom += '逾期'
                            }else{
                            dom += '已付款'
                            }
                            return dom;
                }}
                ,{field: 'paymentStatus', title: '商品类型',width:80,templet:function (d) {
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
                ,{field: 'vipId', title: '会员id', width: 120}
                ,{field: 'nickName', title: '昵称', width: 120}
                // ,{field: 'tel', title: '手机号',width: 120,templet:function(d){
                //     var dom = ''
                //     if(d.companyId!=loginCompanyId){
                //             dom += '无权限查看'
                //         } else {
                //             dom += d.tel
                //         }
                //         return dom;
                // }}
                // ,{field: 'webchat', title: '微信号', width: 150,templet:function(d){
                //     var dom = ''
                //     if(d.companyId!=loginCompanyId){
                //         dom += '无权限查看'
                //     } else {
                //         dom += d.webchat
                //     }
                //     return dom;
                // }}
                ,{field: 'productName', title: '产品名称',width:80}
                // ,{field: 'productType',title:'操作' ,fixed: 'right', width:300, align:'center' ,templet:function(d){
                //     var dom = ''
                //     if(d.companyId!=loginCompanyId){
                //         dom += '<a class="layui-btn layui-btn-xs" lay-event="detail" onclick=viewDetail("'+d.num+'")>查看</a>\n'
                //     }else{
                //         dom += '<a class="layui-btn layui-btn-xs" lay-event="detail" onclick=viewDetail("'+d.num+'")>查看</a>\n' +
                //             '    <a class="layui-btn layui-btn-xs" lay-event="edit"  onclick=editDetail("'+d.num+'")>编辑</a>\n' +
                //             '    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick=deleteDetail("'+d.num+'")>删除</a>' +
                //             '    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick=matchVip("'+d.num+'")>匹配</a>'
                //     }
                //     return dom;
                // }}
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

