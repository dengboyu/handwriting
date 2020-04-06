package org.spring.by.bean.factory.impl;

import org.spring.by.bean.factory.ApplicationContext;

import java.util.Map;

/**
 * @author by@Deng
 * @create 2020-04-04 17:02
 */
public class ApplicationContextBase implements ApplicationContext {

    private Map<String,Object> beanMap;

    @Override
    public Object getBean(String name) {
        return beanMap.get(name);
    }

}
