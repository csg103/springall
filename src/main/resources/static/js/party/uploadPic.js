var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 1,
    func: 'loadData'
};


$(function () {
    loadData(opts.current_page, opts.items_per_page);

    $('#search').on('click', function () {
console.log($('#partyid').val())
        loadData(opts.current_page, opts.items_per_page);
    });
    layui.use(['table', 'upload','form'], function () {
        var $ = layui.jquery
            , upload = layui.upload
            , form = layui.form
            , table = layui.table;


        //多图片上传
        upload.render({
            elem: '#test2'
            , url: ctx + 'party/uploadPic'
            , multiple: true
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
                });
            }
            , done: function (res) {
                //上传完毕
                $('#picurl').val(res.url);
            }
        });

        //监听提交
        form.on('submit(add)', function (data) {

            var arr = new Array();
            $("input:checkbox[name='type']:checked").each(function (i) {
                arr[i] = $(this).attr('id');
            });
            data.field.type = arr.join(",");//将数组合并成字符串

            console.log(JSON.stringify(data.field));

            $.ajax({
                url:ctx + "party/saveRecord",
                type:'post',
                dataType:'json',
                data:data.field,
                traditional:true,
                success:function(data){
                    if (data.code == '0000'){
                        layer.alert("增加成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page,$('#partyid').val())
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("增加失败 " + data.message, {icon: 5},function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
        });

    })


})

function loadData(index, size) {
    layui.use(['table'], function() {

        var table = layui.table;
        //第一个实例
        table.render({
            id: 'recordid'
            , elem: '#demo'
            , height: 430
            , url: ctx + 'party/picList?page=' + index + '&size=' + size + '&partyname=' + $('#searchName').val()+"&partyId="+$('#partyid').val()//数据接口
            , method: 'post'
            , where: {index: index, size: size}
            , cols: [[
                {type: 'checkbox'}
                // ,{field: 'partyid', title: 'partyid', }
                , {field: 'recordname', title: '图片名称', width: '20%'}

                // ,{field: 'companyName', title: '所属公司'}
                , {field: 'AllUrl', title: '图片路径', width: '20%'

                    ,templet: function(d){
                        return  '<div> <a href="'+ d.picip+d.picurl+'" class="layui-table-link">'+d.picip+d.picurl+' </a></div>'

                    }
                }
                , {field: 'partymemberid', title: '添加人', width: '10%'}

                , {
                    field: 'uploadTime',
                    title: '上传时间',
                    width: '15%',
                    templet: "<div>{{layui.util.toDateString(d.partytime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>"
                }


                , {title: '操作', fixed: 'right', width: '20%', align: 'center', toolbar: '#toolbar'}
            ]],
            response: {
                statusName: 'code',
                status: '0000',
                msgName: 'message',
                countName: 'total',
                dataName: 'data'
            },
            done: function (res, curr, count) {

                opts.current_page = res.currentPage - 1
                generatePagination(res.total)
            }
        });
        table.on('tool(user_table)', function (obj) {
            var data = obj.data
            var layEvent = obj.event
            var tr = obj.tr
            if (layEvent == 'detail') {
                layer.msg(JSON.stringify(data))
            } else if (layEvent == 'edit') {
                // layer.msg(JSON.stringify(data))
                editCompany(data.partyid);
            } else if (layEvent == 'uploadPic') {
                // layer.msg(JSON.stringify(data))
                uploadPic(data.partyid);
            } else if (layEvent == 'del') {
                console.log(data.recordid)
                layer.confirm('是否删除图片<span style="color: #FF5722; font-size: 16px;"></span>?', function (index) {


                    $.ajax({
                        url : ctx + 'party/deletePic',
                        type:'post',
                        dataType:'json',
                        data:{
                            id:data.recordid
                        },
                        success:function(data){
                            if (data.code == '0000') {
                                layer.alert("删除成功", {icon: 6},function (i) {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);

                                });
                            }else {
                                layer.alert("删除失败", {icon: 5},function (i) {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);

                                });
                            }
                        }
                    })
                })
            }
        })
    })

}

function generatePagination(total){
    $('#listPage').pagination(total, opts)
}