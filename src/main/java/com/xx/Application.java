package com.xx;/*
 * Copyright (C), 2017, 上海云首信息科技有限公司
 *
 * Author: 邓哲航
 * Date: 2018/5/17 下午4:10
 * History:
 * <author>    <time>    <version>    <desc>
 *
 */



import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

/**
 * @author
 */
public class Application extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public Application() {

        // register application resources
        packages("com.xx.resource");
        // register filters
        register(RequestContextFilter.class);

    }
}
