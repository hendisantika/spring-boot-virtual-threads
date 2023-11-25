package com.hendisantika.springbootvirtualthreads.controller;

import com.hendisantika.springbootvirtualthreads.domain.Book;
import com.hendisantika.springbootvirtualthreads.domain.Order;
import com.hendisantika.springbootvirtualthreads.domain.User;
import com.hendisantika.springbootvirtualthreads.dto.OrderDTO;
import com.hendisantika.springbootvirtualthreads.repository.BookRepository;
import com.hendisantika.springbootvirtualthreads.repository.OrderRepository;
import com.hendisantika.springbootvirtualthreads.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<OrderDTO> addOrder(@RequestParam("bookIsbn") String bookIsbn, @RequestParam("firstName") String firstName) {

        UUID uuid = UUID.randomUUID();
        log.info("addOrder() {} running", uuid);

        User user = userRepository.findByFirstName(firstName);
        Book book = bookRepository.findByIsbn(bookIsbn);
        log.info("addOrder() {} I've got user and book", uuid);

        Order order = new Order();
        order.setUser(user);
        order.setQuantity(1);
        order.setBook(book);
        order = orderRepository.save(order);

        OrderDTO orderDTO = new OrderDTO(order.getOrderId(), order.getQuantity(), book.getBookId(), user.getUserId());
        log.info("addOrder() {} executed", uuid);
        return ResponseEntity.ok(orderDTO);

    }
}
