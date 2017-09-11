package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neowiztomato on 2017-09-06.
 */

@Slf4j
@RestController
public class TestController {


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        log.info("test1");

        return "test1";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() throws Exception {
        log.info("test2");

        return "test2";
    }
}


