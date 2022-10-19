package org.example.kotime.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Configuration
@MapperScan("org.example.kotime.mapper")
public class MybatisPlusConfig {

}
