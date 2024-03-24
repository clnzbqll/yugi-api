package com.yugi.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring工具类
 *
 * @author clnzbqll
 * @since 2024-03-09 08:50:51
 */
@Component
public final class SpringUtils implements BeanFactoryPostProcessor, ApplicationContextAware {
    /**
     * Spring上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;

    /**
     * Spring上下文容器
     */
    private static ApplicationContext applicationContext;

    /**
     * 设置Spring上下文环境
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    /**
     * 设置Spring上下文容器
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 根据名称获取bean
     *
     * @param name bean名称
     * @return bean实例
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 根据类型获取bean
     *
     * @param clz bean类型
     * @return bean实例
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

    /**
     * 根据名称判断容器是否存在bean
     *
     * @param name bean名称
     * @return 存在：true 不存在：false
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }


    /**
     * 根据名称判断bean作用域
     *
     * @param name
     * @return singleton：true 其他：false
     * @throws NoSuchBeanDefinitionException （没找到bean）
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }

    /**
     * 根据名称获取bean的类型
     *
     * @param name bean名称
     * @return Class bena类型
     * @throws NoSuchBeanDefinitionException（没找到bean）
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }

    /**
     * 根据名称获取bean的别名
     *
     *
     * @param name  bean名称
     * @return 别名
     * @throws NoSuchBeanDefinitionException（没找到bean）
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    /**
     * 获取环境配置
     *
     * @return 当前环境配置
     */
    public static String getActiveProfile() {
        final String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        return StringUtils.isNoneBlank(activeProfiles) ? activeProfiles[0] : null;
    }
}
