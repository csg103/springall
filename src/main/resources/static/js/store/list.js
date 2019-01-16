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


function loadData(index, size){
    layui.use(['table','layer', 'laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#vipTable'
            ,height: 450
            ,url: ctx + 'store/list?index=' + index + '&size=' + size //数据接口
            ,cols: [[
                {field: 'name', title: '门店名称'}
                ,{field: 'introduce', title: '门店介绍'}
                ,{field: 'dateStr', title: '创建时间'}
                ,{field: 'url', title: '门店视频展示'}
                ,{field: 'pic',title:'图片' ,templet:function(d){
                    var dom = ''
                    if(d.pic!=null&&d.pic!=''){
                        dom += '<img src="'+d.pic+'"   onclick="javascript:window.open(this.src)" style="cursor: pointer; width: 30px;height: 30px;"  />'
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
            if (layEvent == 'detail'){
                layer.msg(JSON.stringify(data))
            } else if (layEvent == 'edit'){
                x_admin_show("门店修改",ctx + "store/edit?id=" + data.id, 500, 600)
            } else if (layEvent == 'del'){
                layer.confirm('删除此数据?', function(index){
                    $.ajax({
                        url: ctx + 'store/delete',
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
                    layer.close(index)
                })
            }
        })

    });
}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}
function viewImg(url){

}


