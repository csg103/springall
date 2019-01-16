
var loginCompanyId = '';

$(function(){
    loginCompanyId = $('#companyId').val();
    // loadData($('#id').val());

    var conditions = [];

    var conditionsEle = $('input[name="condition"]')
    var id = $('#id').val();

    for (i = 0; i < conditionsEle.length; i++){
        conditions.push(conditionsEle[i].value)
    }

    var data = {};
    $.extend(data, {matchConditions: conditions.toString()})
    $.extend(data, {age_less: $('#age_less').val()})
    $.extend(data, {age_more: $('#age_more').val()})

    loadData(id, $.param(data))


    layui.use(['form'], function() {
        var form = layui.form,
            layer = layui.layer

        form.on('submit(match)', function (data) {
            var formData = data.field;
            conditions = [];
            for (i = 0; i < conditionsEle.length; i++){
                if (conditionsEle[i].checked){
                    conditions.push(conditionsEle[i].value)
                }
            }
            formData['matchConditions'] = conditions.toString();
            loadData(id, $.param(formData));
            return false;
        })
    })
})

function loadData(id, params){
    layui.use(['table','layer', 'laytpl'], function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#vipTable'
            ,height: 450
            ,url: ctx + 'vip/match/' + id + '?' + params//数据接口
            ,cols: [[
                {field: 'num', title: '会员卡号', }
                ,{field: 'name', title: '用户名'}
                ,{field: 'sex', title: '性别',width:60}
                ,{field: 'birthdayStr', title: '生日'}
                ,{field: 'tel', title: '手机号',templet:function(d){
                        var dom = ''
                        if(d.companyId!=loginCompanyId){
                            dom += '无权限查看'
                        } else {
                            dom += d.tel
                        }
                        return dom;
                    }}
                ,{field: 'webchat', title: '微信号',templet:function(d){
                        var dom = ''
                        if(d.companyId!=loginCompanyId){
                            dom += '无权限查看'
                        } else {
                            dom += d.webchat
                        }
                        return dom;
                    }}
                ,{field: 'constellation', title: '星座',width:80}
                ,{field: 'job', title: '职业'}
                ,{field: 'percentage', title:'性格匹配值', width:80, templet:function(d){
                    return (parseInt(d.percentage * 100) + '%')
                    }}
                ,{field: 'job',title:'操作' ,fixed: 'right', align:'center' ,templet:function(d){
                        var dom = '';
                        dom += '<a class="layui-btn layui-btn-xs" lay-event="detail" onclick=viewDetail("'+d.num+'")>查看</a>\n'
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

            }
        });

    });
}

function viewDetail(data){
    parent.window.open(ctx + 'vip/vipShow?vipId='+data);

}