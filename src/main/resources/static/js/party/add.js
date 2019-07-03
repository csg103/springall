$(function () {

    if($("#3").prop("checked")){
        $("#checkGroup").css("display", "");
        $("#departmentid") .attr('lay-verify',"required")
    }else{
        console.log("1111111111111111111111111--------------"+$("#3").prop("checked"))
        $("#checkGroup").css("display", "none");
        $("#departmentid") .attr('lay-verify',"")
    }

    layui.use(['transfer', 'form', 'layer', 'laydate','util'], function () {

        var $ = layui.jquery
            , transfer = layui.transfer
            , form = layui.form
            , laydate = layui.laydate
            , util = layui.util
            , layer = layui.layer;
        // var data1 = JSON.parse($("#data1").val());
        // var data2 = JSON.parse($("#data2").val());
        // var data3 =  JSON.parse($("#data3").val());
        laydate.render({
            elem: '#partytime'
            , type: 'datetime'
        });



        // //显示搜索框
        // transfer.render({
        //     elem: '#test1'
        //     , data: data1
        //     , title: ['一组', '参会人员']
        //     , showSearch: true
        //     , id: 'key1' //定义唯一索引
        //     , parseData: function (res) {
        //         return {
        //             "value": res.parytmemberid //数据值
        //             , "title": res.name //数据标题
        //             , "disabled": false //是否禁用
        //             , "checked": false //是否选中
        //         }
        //     }
        // })
        //
        // transfer.render({
        //     elem: '#test2'
        //     , data: data2
        //     , title: ['二组', '参会人员']
        //     , showSearch: true
        //     , id: 'key2' //定义唯一索引
        //     , parseData: function (res) {
        //         return {
        //             "value": res.parytmemberid //数据值
        //             , "title": res.name //数据标题
        //             , "disabled": false //是否禁用
        //             , "checked": false //是否选中
        //         }
        //     }
        // })
        //
        // transfer.render({
        //     elem: '#test3'
        //     , data: data3
        //     , title: ['三组', '参会人员']
        //     , showSearch: true
        //     , id: 'key3' //定义唯一索引
        //     , parseData: function (res) {
        //         return {
        //             "value": res.parytmemberid //数据值
        //             , "title": res.name //数据标题
        //             , "disabled": false //是否禁用
        //             , "checked": false //是否选中
        //         }
        //     }
        // })
        // var getData1; //获取右侧数据
        // var getData2 ; //获取右侧数据
        // var getData3; //获取右侧数据
        // util.event('lay-demoTransferActive', {
        //     getData: function(othis){
        //         getData1 = transfer.getData('key1'); //获取右侧数据
        //         getData2 = transfer.getData('key2'); //获取右侧数据
        //         getData3 = transfer.getData('key3'); //获取右侧数据
        //
        //
        //     }})
        //监听checkBox
        form.on('checkbox(checkbox)', function (data) {
            console.log(data.elem.id); //得到checkbox原始DOM对象
            // console.log(data.elem.checked); //是否被选中，true或者false
            var arr = new Array();
            $("input:checkbox[name='type']:checked").each(function (i) {
                arr[i] = $(this).attr('id');

            });


            var  m=0;
            for(var i=0;i<arr.length;i++){
                if(arr[i]==1||arr[i]==2||arr[i]==3||arr[i]==4){
                    ++m;
                }else{}
            }
            if(m>1){
                var aa =data.elem.id
                console.log( );
                $("#"+aa+"").prop('checked',false);
                form.render('checkbox');
                layer.alert("不能同时选择三会一课四个中的两个以上 " )
                return;
            }


            if (data.elem.id == 3 && data.elem.checked == true) {
                $("#checkGroup").css("display", "");
                $("#departmentid") .attr('lay-verify',"required")
            } else if (data.elem.id == 3 && data.elem.checked == false) {
                $("#checkGroup").css("display", "none");
                $("#departmentid") .attr('lay-verify',"")
            }


        });
        //监听提交
        form.on('submit(add)', function (data) {

            var arr = new Array();
            $("input:checkbox[name='type']:checked").each(function (i) {
                arr[i] = $(this).attr('id');
            });
            data.field.type = arr.join(",");//将数组合并成字符串
            // var arry = new Array();
            // arry.push(getData1)
            // arry.push(getData2)
            // arry.push(getData3)
            // data.field.mes=arry;
            console.log(JSON.stringify(data.field));


            // var ref = $('#permissionTree').jstree(true),
            //     checked = ref.get_selected(),
            //     undetermined = ref.get_undetermined()
            //
            // for (var i in undetermined){
            //     checked.push(undetermined[i])
            // }
            //
            // data.field.checked = checked;

            $.ajax({
                url:ctx + "party/saveAdd",
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