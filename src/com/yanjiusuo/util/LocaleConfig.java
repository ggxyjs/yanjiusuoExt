package com.yanjiusuo.util;

import java.util.ResourceBundle;

/**
 * 
 * @ClassName: LocaleConfig
 * @Description: 获取国际化文件内容
 * @author HXF
 * @date 2014-10-21 下午3:48:51
 * 
 */
public class LocaleConfig
{

    /**
     * 
     * @Title: getLocale
     * @Description: 获取指定配置文件指定key值的内容
     * @author HXF
     * @param filePath
     * @param key
     * @return
     * @throws
     */
    public static String getLocale(String filePath, String key)
    {
        ResourceBundle rb = ResourceBundle.getBundle(filePath);
        return rb.getString(key);
    }

    /**
     * 
     * @Title: getLocaleUS
     * @Description: 获取国家化文件指定key值的内容 中文
     * @author HXF
     * @param key
     * @return
     * @throws
     */
    public static String getLocaleCN(String key)
    {
        ResourceBundle rb = ResourceBundle.getBundle("messages_zh_CN");
        return rb.getString(key);
    }

    /**
     * 
     * @Title: getLocaleUS
     * @Description: 获取国家化文件指定key值的内容 英文
     * @author HXF
     * @param key
     * @return
     * @throws
     */
    public static String getLocaleUS(String key)
    {
        ResourceBundle rb = ResourceBundle.getBundle("messages_en_US");
        return rb.getString(key);
    }
    
}
