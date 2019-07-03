package com.baidu;

import java.util.UUID;

/**
 * Created by yichen on 2017/4/21.
 */
public class UUIDUtils {

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
