/**
 * Created by yichen on 2018/3/12.
 */
var element ; //Tab的切换功能，切换事件监听等，需要依赖element模块
var layer ;

layui.use('element', function(){
    element = layui.element;
});

layui.use('layer', function () {
    layer = layui.layer
})

//刷存在感
var active = {
    tabAdd: function (url, id, innerHtml) {
        //新增一个Tab项
        element.tabAdd('demo', {
            title: innerHtml //用于演示
            , content: '<iframe data-frameid="'+id+'" frameborder="0" name="content" scrolling="no" width="100%" src="' + url + '"></iframe>'
            , id: id //实际使用一般是规定好的id，这里以时间戳模拟下
        })
        CustomRightClick(id);//绑定右键菜单
        FrameWH();//计算框架高度
    }
    , tabChange: function (id) {
        //切换到指定Tab项
        element.tabChange('demo', id); //切换到：用户管理
        $("iframe[data-frameid='"+id+"']").attr("src",$("iframe[data-frameid='"+id+"']").attr("src"))//切换后刷新框架
    }
    , tabDelete: function (id) {
        element.tabDelete("demo", id);//删除
    }
    , tabDeleteAll: function (ids) {//删除所有
        $.each(ids, function (i,item) {
            element.tabDelete("demo", item);
        })
    }
};

$(".layui-side-scroll a").click(function () {
    var dataid = $(this);
    if (dataid.attr('data-url') == null || dataid.attr('data-url') == ''){
        return;
    }
    if ($(".layui-tab-title li[lay-id]").length <= 0) {
        active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.text());
    } else {
        var isData = false;
        $.each($(".layui-tab-title li[lay-id]"), function () {
            if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                isData = true;
            }
        })
        if (isData == false) {
            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.text());
        }
    }
    active.tabChange(dataid.attr("data-id"));
})

function CustomRightClick(id) {
    //桌面点击右击
    $('.layui-tab-title li').contextmenu(function (e) {
        var popupmenu = $(".rightmenu");
        popupmenu.find("li").attr("lay-id",id);
        l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
        t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
        popupmenu.css({ left: l, top: t , index: 999}).show();
        //alert("右键菜单")
        return false;
    });
}

$('body').click(function () {
    $(".rightmenu").hide();
})

$(".rightmenu li").click(function () {
    if ($(this).attr("data-type") == "closethis") {
        active.tabDelete($(this).attr("lay-id"))
    } else if ($(this).attr("data-type") == "closeall") {
        var tabtitle = $(".layui-tab-title li");
        var ids = new Array();
        $.each(tabtitle, function (i) {
            ids[i] = $(this).attr("lay-id");
        })

        active.tabDeleteAll(ids);
    }

    $('.rightmenu').hide();
})

function FrameWH() {
    var h = $(window).height() -41- 10 - 60 -10-44 -10;
    $("iframe").css("height",h+"px");
}

$(window).resize(function () {
    FrameWH();
})

function addTab(url, id){
    active.tabAdd(url, id)
}
i = 0;
function menuAnimate(){
    if(i==0){
        $(".layui-side").animate({width:'toggle'});
        $(".layui-body").animate({left:'0px'});
        $(".layui-footer").animate({left:'0px'});
        i++;
    }else{
        $(".layui-side").animate({width:'toggle'});
        $(".layui-body").animate({left:'200px'});
        $(".layui-footer").animate({left:'200px'});
        i--;
    }
}