$(function () {
    layui.use(['form'], function () {
        var form = layui.form;

        $('#saveListAction').on('click', function () {
            var filename = $('.filename');
            var filesize = $('.filesize');
            var fileurl = $('.fileurl');
            var filetype = $('#filetype').val();
            if (filetype == '0') {
                layer.alert("请选择文件类型 ")
                return;
            }
            console.log($('.filename')[0].innerHTML)
            var params = [];

            for (var i = 0; i < $('.filename').length; i++) {
                var vo = [];
                vo.push('appendname' + '":"' + filename[i].innerHTML + '');
                vo.push('remake1' + '":"' + filesize[i].innerHTML + '');
                vo.push('appendixaddress' + '":"'+ fileurl[i].innerHTML + '');
                vo.push('appendtype' + '":"' + filetype + '');
                console.log(JSON.stringify(vo))
              var  vostr = JSON.stringify(vo)
                vostr= vostr.substr(1,vostr.length-2)
                console.log(vostr)
                params.push("{"+vostr+"}")

            }
            var json = JSON.stringify(params).replace(/\\/g, "").replace(/\[\"/g,"[").replace(/\"\]/g,"]").replace(/\}\"/g,"}").replace(/\"\{/g,"{");
            json=encodeURIComponent(json);
            if(fileurl[0].innerHTML=="undefined"){
                layer.alert("请先上传文件 ")
                return
            }

            console.log(json)
                var arr = new Array();
                $("input:checkbox[name='type']:checked").each(function (i) {
                    arr[i] = $(this).attr('id');
                });




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
                    url:ctx + "appendix/saveAdd?Mes="+json,
                    type:'post',
                    dataType:'json',
                    data:json,
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
    })

})