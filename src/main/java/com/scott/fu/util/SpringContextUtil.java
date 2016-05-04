package com.scott.fu.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.Locale;

/**
 * Created by ScottFu on 2016/1/20.
 */
public class SpringContextUtil {
    private static ApplicationContext context = null;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }

    public static String getMessage(String key){
        return context.getMessage(key, null, Locale.getDefault());
    }
}
