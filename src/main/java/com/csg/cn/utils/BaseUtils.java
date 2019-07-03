package com.csg.cn.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.csg.cn.db.entity.PartyMemberScoreDetil;
import com.csg.cn.db.entity.PartyMemberScorePip;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.collections.map.HashedMap;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.thymeleaf.util.StringUtils;
import test.testa;
import test.testb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* 描述 ： 基本工具类 封装了常用的utils
* 作者 ： csg
* 时间 ： 2018-12-25
*/
public class BaseUtils {

    private static DozerBeanMapper dozer;

    private static ValueFilter filter;

    private static String formatString = "yyyy-MM-dd HH:mm:ss";

    private static String formatString2 = "yyyy-MM-dd";


    private static DozerBeanMapper getDozer() {
        if (dozer == null) {
            dozer = new DozerBeanMapper();
        }
        return dozer;
    }

    /**
     * vo值复制 ，a b为两个不同类型 两个VO，把a 中的相同字段值 复制到b中 返回b对象。
     *
     * @param object   a
     * @param targetVo b
     * @return b
     */
    public static <T> T VoToTargetVo(Object object, Class<T> targetVo) {
        return getDozer().map(object, targetVo);
    }


    /**
     * 相同bean对象克隆
     *
     * @param object
     * @return
     */
    public static Object BesnClone(Object object) {
        Object obj = null;
        try {
            obj = BeanUtils.cloneBean(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return obj;
    }


    /**
     * 转换日期格式yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String DateToStringYMDHMS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    /**
     * 转换日期格式yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String DataToStringYMD(Date date) {
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatString2);
        return sdf2.format(date);
    }


    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static String StampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 将时间转换为时间戳
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static String DateToStamp(String s) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * list转MAP
     *
     * @param valueList
     * @param keyName
     * @param clazz
     * @param isNeedFirstUpper
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> ListConverMap(List<V> valueList, String keyName, Class<V> clazz, boolean isNeedFirstUpper) {
        K key = null;
        int i = 1;
        if (i < valueList.size())
            i = i << 1;
        Map<K, V> map = new HashedMap(i, 1f);
        try {

            if (isNeedFirstUpper)
                if (keyName != null && !keyName.equals("")) {
                    keyName = UpperFirst(keyName);
                } else {
                    return map;
                }

            Method getKeyMethod = clazz.getMethod("get" + keyName);
            for (V entity : valueList) {
                key = (K) getKeyMethod.invoke(entity);
                map.put(key, entity);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }

        return map;
    }

    /**
     * Map转LIST
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T> List<T> MapConvertToList(Map<String, T> map) {
        List<T> list = new ArrayList<T>();
        for (T t : map.values())
            list.add(t);

        return list;
    }

    private static String UpperFirst(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }


    private static String generateUUID() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成固定格式UUID target  传入类型大写字母
     *
     * @param target
     * @return 返回实例 USER_a88636bf0fb84859ab3d2fc877cfb7c0
     */
    public static String TargetGenerateUUID(String target) {

        return target + "_" + generateUUID();
    }


    private static ValueFilter getFilter() {
        if (filter == null) {
            filter = new ValueFilter() {
                @Override
                public Object process(Object obj, String s, Object v) {
                    if (v == null) {
                        return "";
                    }

                    if (v instanceof Integer) {
                        return "" + v;
                    }


                    return v;
                }


            };
        }

        return filter;
    }

    /**
     * OBJECT 转JSONString  Map转string javabean转string
     *
     * @param obj
     * @return
     */
    public static String ObjectToJsonString(Object obj) {

        return JSON.toJSONString(obj, getFilter(), SerializerFeature.DisableCircularReferenceDetect);
    }


    /**
     * string 转JAVAbean
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T JsonStringToObject(String jsonStr, Class<T> clazz) {

        return JSON.toJavaObject(JSONObject.parseObject(jsonStr), clazz);
    }

    /**
     * JSONSTRING转 MAP
     *
     * @param jsonStr
     * @return
     */
    public static Map JsonStringToMap(String jsonStr) {
        JSONObject jasonObject = JSONObject.parseObject(jsonStr);

        return (Map) jasonObject;
    }


    /**
     * string MD5加密
     *
     * @param str
     * @return
     */
    public static String StringTOMd5(String str) {
        return DigestUtils.md5Hex(str);
    }


    /**
     * string MD5加密 加盐值 再加密
     *
     * @param str
     * @return
     */
    public static String StringToMd5UseSalt(String str, String salt) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(str) + salt);
    }


    /**
     * MAP转换成对应属性的JAVAbean
     *
     * @param obj
     * @param map
     */
    public static void MapToBean(Object obj, Map map) {

        try {
            BeanUtils.populate(obj, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * bean 抓换成MAP 不支持嵌套对象转换
     *
     * @param obj
     */
    public static Map BeanToMap(Object obj) {
        Map map = null;
        try {
            map = BeanUtils.describe(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return map;

    }

    public static int getScore(List<PartyMemberScoreDetil> partyMemberScoreDetilList, List<PartyMemberScorePip> partyMemberScorePipList) {
        int i = 100;
        for (PartyMemberScorePip partyMemberScorePip : partyMemberScorePipList) {
            int m= Integer.parseInt(partyMemberScorePip.getScore());// 总分
            int n= Integer.parseInt(partyMemberScorePip.getRemake1());//每次分数标准
            int j=0; //当前标准当前得分
            for (PartyMemberScoreDetil partyMemberScoreDetil : partyMemberScoreDetilList) {
                if(StringUtils.equals(partyMemberScorePip.getScoreid(),partyMemberScoreDetil.getPipid())){
                    j=j+n;
                    if(j>=m){
                        j=m;
                        break;
                    }
                }
            }
            if(StringUtils.equals(partyMemberScorePip.getIsadd(),"1")){
                i=i+j;
            }else{
                i=i-j;
            }
        }
        return i;
    }

    @Test
    public void test() {
        Map map = new FastHashMap();
//        map.put("a", "sd");
//        map.put("b", 666);
//        map.put("c", "3");
//        map.put("d", b);
        testa a = new testa();
//        testa c = new testa();
        a.setA("a");
        a.setB(2);
        a.setC(false);
        a.setE(DateToStringYMDHMS(new Date()));
        testb b = new testb();
        b.setA("a");
        b.setB(3);
        b.setC(true);
        a.setD(b);
//        MapToBean(a, map);
        Map map1 = BeanToMap(a);

        String mapJson = ObjectToJsonString(map);

        String json = ObjectToJsonString(a);

        String strjson = "{\"a\":\"a\",\"b\":\"2\",\"c\":false,\"d\":{\"a\":\"a\",\"b\":\"3\",\"c\":true},\"e\":\"2018-12-26 19:49:47\"}";

//        c = JsonStringToObject(strjson, a.getClass());

//        JsonStringToObject()
        Map mm = JsonStringToMap(mapJson);
        String s = TargetGenerateUUID("USER");
        Assert.assertFalse(s.equals("a"));
    }
}
