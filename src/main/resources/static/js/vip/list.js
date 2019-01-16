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
    loadData(opts.current_page, opts.items_per_page);
    //语言下拉
    // $('#vipType').change(function(){
    //     if($(this).val()=='10'){
    //         $("#vipStatusDiv").show();
    //     }else{
    //         $("#vipStatusDiv").hide();
    //         $("#vipStatus").val('4');
    //     }
    // });


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
    layui.use(['form','layer'], function() {
        var form = layui.form;

        form.on('select(search_type)', function(data){
            if(data.value=='10'){
                $("#vipStatusDiv").show();
            }else{
                $("#vipStatusDiv").hide();
                $("#vipStatus").val('4');
            }

        });

    });

    layui.use(['table','layer', 'laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#vipTable'
            ,height: 450
            ,url: ctx + 'vip/listAjax?index=' + index + '&size=' + size+'&id=' + $("#vipNumber").val()+'&vipName=' + $("#vipName").val()+'&vipPhone=' + $("#vipPhone").val()+'&vipChannel=' + $("#vipType").val()+'&status=' + $("#vipStatus").val() //数据接口
            ,cols: [[
                {field: 'num', title: '会员卡号', width:120}
                ,{field: 'name', title: '用户名', width:80}
                ,{field: 'sex', title: '性别',width:40}
                ,{field: 'birthdayStr', title: '生日', width: 120}
                ,{field: 'tel', title: '手机号',width: 120,templet:function(d){
                    var dom = ''
                    if(d.companyId!=loginCompanyId){
                            dom += '无权限查看'
                        } else {
                            dom += d.tel
                        }
                        return dom;
                }}
                ,{field: 'webchat', title: '微信号', width: 150,templet:function(d){
                    var dom = ''
                    if(d.companyId!=loginCompanyId){
                        dom += '无权限查看'
                    } else {
                        dom += d.webchat
                    }
                    return dom;
                }}
                ,{field: 'nativePlace', title: '籍贯',width:80}
                ,{field: 'job', title: '职业', width: 80}
                ,{field: 'job',title:'操作' ,fixed: 'right', width:300, align:'center' ,templet:function(d){
                    var dom = ''
                    if(d.companyId!=loginCompanyId){
                        dom += '<a class="layui-btn layui-btn-xs" lay-event="detail" onclick=viewDetail("'+d.num+'")>查看</a>\n'
                    }else{
                        dom += '<a class="layui-btn layui-btn-xs" lay-event="detail" onclick=viewDetail("'+d.num+'")>查看</a>\n' +
                            '    <a class="layui-btn layui-btn-xs" lay-event="edit"  onclick=editDetail("'+d.num+'")>编辑</a>\n' +
                            '    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick=deleteDetail("'+d.num+'")>删除</a>' +
                            '    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick=matchVip("'+d.num+'")>匹配</a>'
                    }
                    return dom;
                }}
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

