package com.example.helloWorld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

//telling spring that it should run on any random port any port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckHTTPResponse {

    //get that port number and annotate it with localServerPort
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //expected value is the same as the actual value in the server
    @Test
    public void shouldPassIfStringMatched(){
        //compares the string we going to put in our controller and the string being served from the random port
        assertEquals("Hello World from Spring Boot",
                 testRestTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }
}

