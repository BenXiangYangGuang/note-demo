package com.wewe.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description: Properties文件获取工具类
 * User: eeve
 * Date: 2018-04-13
 * Time: 上午10:11
 */
@Slf4j
public class PropertyTool {

    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        log.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyTool.class.getResourceAsStream("/rule-engine.properties"); //getResourceAsStream ()返回的是inputstream
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("rule-engine.properties文件未找到");
        } catch (IOException e) {
            log.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("rule-engine.properties文件流关闭出现异常");
            }
        }
        log.info("加载properties文件内容完成...........");
        log.debug("properties文件内容：" + props);
    }

    public static String get(String key) {
        return get(key, null);
    }

    public static String get(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
}
