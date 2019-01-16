$(function(){

    $.ajax({
        url:ctx + 'role/allRoles',
        type:'post',
        dataType:'json',
        success:function(data){
            if (data.code == '0000'){
                var roleId = $('#roleId').val();
                data = data.data;
                var appender = '';
                for (i in data){
                    if (roleId == data[i].id){
                        appender += ('<option value="' + data[i].id + '" selected="selected">' + data[i].role + '</option>');
                    } else {
                        appender += ('<option value="' + data[i].id + '">' + data[i].role + '</option>');
                    }
                }
                $('#L_role').html(appender)

            }
            layui.use(['form','layer'], function(){
                var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                form.render()
            });

        }
    })

    $.ajax({
        url: ctx + 'company/findAll',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.code == '0000'){
                data = data.data;
                var html = [];
                for (i in data){
                    html.push("<option value='" + data[i].id + "'" + (($('#company').val() == data[i].id) ? "selected='selected'" : "") + ">" + data[i].companyName+ "</option>")
                }
                $('#L_companyId').append(html.join(''))
                layui.use(['form','layer'], function(){
                    var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                    form.render()
                });
            }
        }
    })

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;


        //监听提交
        form.on('submit(edit)', function(data){
            console.log(data.field);

            $.ajax({
                url:ctx + "user/saveEdit",
                type:'post',
                dataType:'json',
                data:data.field,
                traditional:true,
                success:function(data){
                    if (data.code == '0000'){
                        layer.alert("修改成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("修改成功 " + data.message, {icon: 5},function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
        });


    });

})