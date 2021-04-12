# 嵌入式`Web`容器

## `Tomcat` 作为`Servlet`容器
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>
```
当然`spring-boot-starter-web`中默认的`web`容器也是`tomcat`，因此，默认引入`spring-boot-starter-web`即相当于引入了`spring-boot-starter-tomcat`
。
> `Tomcat Maven`插件并非嵌入式`Tomcat`，仍旧利用了传统的`Tomcat`容器部署方式，先打包为`ROOT.war`，然后再`Tomcat`启动过程中将`ROOT.war`文件解压至 `webapps`下(可通过编译chapter4执行生成的`chapter4-1.0-SNAPSHOT-war-exec.jar`查看`.extract`验证)。
> 然而`Tomcat`插件官方最高只支持到`Tomcat7`, `Tomcat8`插件的`GAV`如下
> ```xml
> <plugin>
>     <groupId>org.apache.tomcat.maven</groupId>
>     <artifactId>tomcat8-maven-plugin</artifactId>
>     <version>3.0-r1756463</version>
>     <executions>
>         <execution>
>             <id>tomcat-run</id>
>             <goals>
>                 <goal>exec-war-only</goal>
>             </goals>
>             <phase>package</phase>
>             <configuration>
>                 <path>/</path>
>             </configuration>
>         </execution>
>     </executions>
> </plugin>
> ```
> 当然此插件由社区提供，因此需要添加仓库 
> ```xml
> <pluginRepositories>
>     <pluginRepository>
>         <id>Alfresco</id>
>         <name>Alfresco Repository</name>
>         <url>https://artifacts.alfresco.com/nexus/content/repositories/public</url>
>         <snapshots>
>             <enabled>false</enabled>
>         </snapshots>
>     </pluginRepository>
> </pluginRepositories>
> ```

## `Jetty` 作为`Servlet`容器
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
```
> `Jetty` 对比 `Tomcat` 有着更为小巧灵活，以及可插拔和可扩展的特性。因此在很多场合下`Jetty`是一个很合适的选择。比如云环境，以及嵌入式设别等。


## `Undertow` 作为 `Servlet`容器
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>
```
