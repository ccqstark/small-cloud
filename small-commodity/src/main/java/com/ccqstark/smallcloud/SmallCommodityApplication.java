package com.ccqstark.smallcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ccqstark.smallcloud.dao")
@EnableSwagger2
public class SmallCommodityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallCommodityApplication.class, args);
    }

}
