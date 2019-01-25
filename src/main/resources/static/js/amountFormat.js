/**
 * Created by yangzy on 2018/12/13.
 */

function amountFormat(s, type) {
    if (/[^0-9\.]/.test(s))
        return "0.00";
    if (s == null || s == "null" || s == "")
        return "0.00";
    s = s.toString().replace(/^(\d*)$/, "$1.");
    s = (s + "00").replace(/(\d*\.\d\d)\d*/, "$1");
    s = s.replace(".", ",");
    var re = /(\d)(\d{3},)/;
    while (re.test(s))
        s = s.replace(re, "$1,$2");
    s = s.replace(/,(\d\d)$/, ".$1");
    if (type === 0) {
        var a = s.split(".");
        if (a[1] == "00") {
            s = a[0];
        }
    }
    return s;
}

function removeFormatMoney(s) {
    return parseFloat(s.replace(/[^\d\.-]/g, ""));
}

function focusAmountFormat(event) {
    var obj = event.srcElement || event.target;
    if(obj.value!='' && obj.value!=null){
        obj.value = removeFormatMoney(obj.value, '');
    }
    return obj;
}

function blurAmountFormat(event) {
    var obj = event.srcElement || event.target;
    obj.value = amountFormat(obj.value, '');
    return obj;
}

