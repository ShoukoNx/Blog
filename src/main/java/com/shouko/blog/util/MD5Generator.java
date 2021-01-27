package com.shouko.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author ShoukoNx
 * @Date Created in 2021/1/18 13:01
 * @Description MD5工具类, 返回32位加密结果
 * @Version 1.0.0
 */
public class MD5Generator {

    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
