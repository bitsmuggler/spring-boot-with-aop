package com.bitsmuggler.learning.springbootaspect;

import com.bitsmuggler.learning.springbootaspect.aspects.CheckSomething;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    @CheckSomething
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/throwException")
    @CheckSomething
    public String throwAnException() throws Exception {
        throw new Exception("Hello from exception!");
    }
}