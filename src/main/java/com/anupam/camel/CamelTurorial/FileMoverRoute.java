package com.anupam.camel.CamelTurorial;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:///tmp/input")
                .log("${headers}")
                .log("${body}")
                .to("file:///tmp/processed");
    }
}
