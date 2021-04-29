package org.xq.thinkinginspringboot.chapt5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class WebConfiguration {
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello-world"), request -> ok().body(Mono.just("Hello world!"), String.class));
    }

    @Bean
    public ApplicationRunner runner(BeanFactory factory){
        return args -> {
            System.out.println("hello world bean 实现类"+factory.getBean("helloWorld").getClass().getName());
            System.out.println("web configuration bean 实现类"+factory.getBean(WebConfiguration.class).getClass().getName());

        };
    }
}
