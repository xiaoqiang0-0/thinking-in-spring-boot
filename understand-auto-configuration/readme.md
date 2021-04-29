# 理解自动装配

激活使用自动装配:  
使用注解`@EnableAutoConfiguration`或者`@EnableAutoConfiguration`的'派生'注解.

例:
首先创建
```java
@Configuration
@Import(xxx.class)
public class WebAutoConfiguration {
    //...
}
```
然后再在resources下创建META-INF/spring.factories
增加
`
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
xx.xx.WebAutoConfiguration
`  

在`AutoConfiguration`中可以加入各种同类组件的选择性装载(`@ConditionOnMissingBean`,`@ConditionOnClass`等等)也可以通过`@Import`导入其他的配置类.


