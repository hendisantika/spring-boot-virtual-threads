package com.hendisantika.springbootvirtualthreads.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-virtual-threads
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/25/23
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/thread")
public class VirtualThreadController {

    @GetMapping("/name")
    public String getThreadName() {
        return Thread.currentThread().toString();
    }

}
