$(function(){

    $.ajax({
        url:ctx + 'role/allRoles',
        type:'post',
        dataType:'json',
        success:function(data){
            if (data.code == '0000'){
                data = data.data;
                var appender = '';
                for (i in data){
                    appender += ('<option value="' + data[i].id + '">' + data[i].role + '</option>');
                }
                $('#L_role').html(appender)

            }
            layui.use(['form','layer'], function(){
                var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                form.render()
            });

        }
    });

    $.ajax({
        url: ctx + 'company/findAll',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.code == '0000'){
                data = data.data;
                var html = [];
                for (i in data){
                    html.push("<option value='" + data[i].id + "'>" + data[i].companyName+ "</option>")
                }
                $('#L_companyId').append(html.join(''))
                layui.form.render();
            }
        }
    })

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;



        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_password').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            },
            company: function(){
                if ($('#L_companyId').val() == ''){
                    return '请选择所属公司!';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            var newpwd = hex_md5(data.field.password)
            data.field.password = newpwd

            $.ajax({
                url:ctx + "user/saveAdd",
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
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
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


    });

})