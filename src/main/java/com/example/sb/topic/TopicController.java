package com.example.sb.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public String getAllTopic() {

        /* return Arrays.asList(
                new Topic("one","Hi","Hello"),
                new Topic("two","Hi","Hello"),
                new Topic("three","Hi","Hello")        
        ); */

        return "Hello";
    }
}