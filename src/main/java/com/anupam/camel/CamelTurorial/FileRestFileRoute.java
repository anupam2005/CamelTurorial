package com.anupam.camel.CamelTurorial;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRestFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:///tmp/request")
                .log("Request Body In File: ${body}")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setHeader("Accept",constant("application/json"))
                .setHeader("Authorization",constant("Bearer 603e8d6f9c4c073f8b94f6444ff76967ab22a25d0e8ea0a149477052f3da5366"))
                .log("Body after transformation is ${body} with headers: ${headers}")
                .to("https://gorest.co.in/public/v2/users?bridgeEndpoint=true&throwExceptionOnFailure=false")
                .log("RESPONSE BODY: ${body}")
                .log("RESPONSE HEADER: ${headers}");

    }
}
