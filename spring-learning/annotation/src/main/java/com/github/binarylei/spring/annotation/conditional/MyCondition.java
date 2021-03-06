package com.github.binarylei.spring.annotation.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1. IOC 容器
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 环境变量
        Environment environment = context.getEnvironment();
        // 4. 可以向容器中注册 BeanDefinition
        BeanDefinitionRegistry registry = context.getRegistry();
        return environment.getProperty("os.name").contains("Windows");
    }
}
