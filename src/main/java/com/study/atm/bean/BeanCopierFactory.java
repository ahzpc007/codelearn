package com.study.atm.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import lombok.Data;

/**
 * @author wuliqing
 */
public class BeanCopierFactory {
    private static final Map<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<String, BeanCopier>();

    public static void copy(Object srcObj, Object targetObj) {
        copy(srcObj,targetObj,null);
    }

    private static void copy(Object srcObj, Object targetObj, Converter converter) {
        String key = getKey(srcObj.getClass(), targetObj.getClass());
        BeanCopier beanCopier = null;
        if (BEAN_COPIERS.containsKey(key)) {
            beanCopier = BEAN_COPIERS.get(key);
        } else {
            beanCopier = BeanCopier.create(srcObj.getClass(), targetObj.getClass(), converter != null);
            BEAN_COPIERS.put(key, beanCopier);
        }
        beanCopier.copy(srcObj, targetObj, converter);
    }

    private static String getKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

    public static void main(String[] args) {
        Bean1 bean1 = new Bean1();
        bean1.setA(1l);
        bean1.setB(2);
        Bean3 bean3 = new Bean3();
        bean3.setA3(3l);
        bean3.setB3(3);
        bean1.setC(bean3);
        Bean2 bean2 = new Bean2();
        BeanCopierFactory.copy(bean1,bean2);
        System.out.println(bean2.getA());
    }
}

@Data
class Bean1 {
    private Long a;
    private Integer b;
    private Bean3 c;
}

@Data
class Bean2 {
    private Long a;
    private Integer b;
    private Bean4 c;
}


@Data
class Bean3 {
    private Long a3;
    private Integer b3;
    private String c3;
}

@Data
class Bean4 {
    private Long a3;
    private Integer b3;
    private String c3;
}