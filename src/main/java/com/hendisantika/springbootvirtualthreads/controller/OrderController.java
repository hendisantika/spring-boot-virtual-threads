package com.hendisantika.springbootvirtualthreads.controller;

import com.hendisantika.springbootvirtualthreads.repository.BookRepository;
import com.hendisantika.springbootvirtualthreads.repository.OrderRepository;
import com.hendisantika.springbootvirtualthreads.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-virtual-threads
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/25/23
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final OrderRepository orderRepository;
}
