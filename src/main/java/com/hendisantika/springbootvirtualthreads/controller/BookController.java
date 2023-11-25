package com.hendisantika.springbootvirtualthreads.controller;

import com.hendisantika.springbootvirtualthreads.domain.Book;
import com.hendisantika.springbootvirtualthreads.dto.BookDTO;
import com.hendisantika.springbootvirtualthreads.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-virtual-threads
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/25/23
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAll() {
        UUID uuid = UUID.randomUUID();
        log.info("getAll() {} running", uuid);

        ResponseEntity<List<BookDTO>> list = ResponseEntity.ok(this.bookRepository.findAll().stream().
                map((e) -> new BookDTO(e.getBookId(), e.getAuthor(), e.getIsbn(), e.getTitle(), e.getYear())).collect(Collectors.toList()));

        log.info("getAll() {} executed", uuid);
        return list;
    }

    @GetMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllSimple() {
        return ResponseEntity.ok(this.bookRepository.findAll());
    }
}
