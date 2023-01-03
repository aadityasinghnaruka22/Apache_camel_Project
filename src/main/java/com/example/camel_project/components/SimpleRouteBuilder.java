package com.example.camel_project.components;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.ERROR;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Component
@ConditionalOnProperty(name = "jss.camel.hello.enabled", havingValue = "true")
public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:greeting").
		log(ERROR, "Hello ${body}")
		.end();
	}
}