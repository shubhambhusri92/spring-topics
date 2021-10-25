package com.luv2.code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // used for pure java configuration
@EnableAspectJAutoProxy // used for Spring AOP proxy support
@ComponentScan("com.luv2.code.aopdemo") // component scan for components and aspects Recurse packages
public class DemoConfig {

}
