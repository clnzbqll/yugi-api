package com.example.yugi.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 * （用于非spring管理环境中获取bean）
 *
 * @author jia
 * @since 2023-07-21 14:42:56
 */
@Component
public final class SpringUtils implements BeanFactoryPostProcessor {
    /**
     * Spring单例工厂
     */
    private static ConfigurableListableBeanFactory beanFactory;

    /**
     * 设置Spring单例工厂
     *
     * @param beanFactory 工厂
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 获取Bean
     *
     * @param clz 类
     * @return bean
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }
}
