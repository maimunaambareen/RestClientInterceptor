package com.example.RestClientInterceptors;

import am.ik.spring.http.client.RetryableClientHttpRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.backoff.FixedBackOff;
import org.springframework.web.client.RestClient;


@Component
public class SimpleInterceptorClient {
    private final RestClient restClient;
    //RestClient restClient = RestClient.create();
    //String url = "https://jsonplaceholder.typicode.com/";
    //String response = restClient.get()
    //.uri(url)
    //.retrieve()
    // .body(String.class);
   //System.out.println(response);
    private static Logger log= LoggerFactory.getLogger(SimpleInterceptorClient.class);

    public SimpleInterceptorClient(RestClient.Builder builder, ClientHttpRequestInterceptor myInterceptor) {
        //In Spring’s RestClient (Spring Framework 6+), interceptors can only be added through a RestClient.Builder
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .requestFactory(new JdkClientHttpRequestFactory())
                //.requestInterceptor(new RetryableClientHttpRequestInterceptor(new FixedBackOff(100, 2))
                .requestInterceptor(myInterceptor)
                //If it is something simple write inline interceptor like below
                //.requestInterceptor(((request, body, execution) -> {
                //log.info("Intercepting request: " + request.getURI());
                //request.getHeaders().add("x-request-id", "12345");
                //return execution.execute(request, body);
                //}))
                .build();
    }

    public String findAllTodos() {
        return restClient.get().uri("todos").retrieve().body(String.class);

    }
}
