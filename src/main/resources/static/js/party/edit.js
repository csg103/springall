$(function () {
    if($("#3").prop("checked")){
        $("#checkGroup").css("display", "");
        $("#departmentid") .attr('lay-verify',"required")
    }else{
        $("#checkGroup").css("display", "none");
        $("#departmentid") .attr('lay-verify',"")
    }
    var lengthArray = 0;
    layui.use(['transfer', 'form', 'layer', 'laydate', 'util'], function () {

        var $ = layui.jquery
            , transfer = layui.transfer
            , form = layui.form
            , laydate = layui.laydate
            , util = layui.util
            , layer = layui.layer;
        laydate.render({
            elem: '#partytime'
            , type: 'datetime'
        });
        var arry = JSON.parse($("#listMember").val());
        lengthArray = arry.length;
        // console.log(arry.length);
        // console.log(arry[0][0].partymembergroupname);
        //添加穿梭框
        for (var i = 0; i < arry.length; i++) {
            var div = document.createElement("div");
            div.setAttribute("class", "layui-form-item ");
            var fieldset = document.createElement("fieldset");
            fieldset.setAttribute("class", "layui-elem-field layui-field-title");
            fieldset.setAttribute("style", "margin-top: 30px;");
            div.appendChild(fieldset);
            var legend = document.createElement("legend");
            legend.textContent = "参会人员";
            var div1 = document.createElement("div");
            div1.setAttribute("class", "demo-transfer layui-input-inline");
            div1.setAttribute("id", "group" + i);
            fieldset.appendChild(legend);
            $("#partyPlays").append(div);
            $("#partyPlays").append(div1);
        }
        //为穿梭框赋值JSON.stringify(arry[i])
        var checkedList = $("#checkedList").val().replace("[", "").replace(/\"/g, "").replace("]", "");
        var arraygroup = new Array();

        splitArray(checkedList, 1);
        function splitArray(checkedList, i) {
            var checkedList1 = new Array();
            console.log(checkedList)
            checkedList1 = checkedList.split("_group" + i + ",");

            if (checkedList1.length > 1) {
                var str = checkedList1[0];
                arraygroup.push(str);
                if (i < arry.length)
                    splitArray(checkedList1[1], ++i);
            } else {
                arraygroup.push("");
                if (i < arry.length)
                    splitArray(checkedList1[0], ++i);
            }
        }

        console.log(arraygroup)
        for (var i = 0; i < arry.length; i++) {
            console.log(arraygroup[i].replace('"', "").split(","))
            transfer.render({
                elem: '#group' + i
                , data: arry[i]
                , title: ['第' + (i + 1) + '组', '参会人员']
                , showSearch: true
                , id: 'key' + (i + 1) //定义唯一索引
                , value: arraygroup[i].replace('"', "").split(",")
                , parseData: function (res) {
                    return {
                        "value": res.parytmemberid //数据值
                        , "title": res.name //数据标题
                        , "disabled": false //是否禁用
                        , "checked": false //是否选中
                        , "group": (i + 1) //
                    }
                }
            })

        }
        //监听checkBox
        form.on('checkbox(checkbox)', function (data) {
            // console.log(data.elem.id); //得到checkbox原始DOM对象
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
            var arryCheckef = new Array();

            // console.log(arryChecked)
            var arr = new Array();
            $("input:checkbox[name='type']:checked").each(function (i) {
                arr[i] = $(this).attr('id');

            });


            data.field.type = arr.join(",");//将数组合并成字符串

            for (var i = 0; i < 3; i++) {
                console.log("----------" + 'key' + (i + 1).toString());
                arryCheckef.push(JSON.stringify(transfer.getData('key' + (i + 1).toString())));
            }
            data.field.mes = arryCheckef;
            data.field.id = $('#id').val();
            $.ajax({
                url: ctx + "party/editPartyMes?type=",
                type: 'post',
                dataType: 'json',
                data: data.field,
                traditional: true,
                success: function (data) {
                    if (data.code == '0000') {
                        layer.alert("增加成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            // parent.addNode("#permissionTree", data.data)
                            parent.loadData(parent.opts.current_page, parent.opts.items_per_page)
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("增加失败 " + data.message, {icon: 5}, function (index) {
                            layer.close(index)
                        });
                    }
                }
            });
            return false;
        });


    });
})