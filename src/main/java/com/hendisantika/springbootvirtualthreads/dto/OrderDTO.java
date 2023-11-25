package com.hendisantika.springbootvirtualthreads.dto;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-virtual-threads
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/25/23
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public record OrderDTO(Integer orderId, Integer quantity, Integer bookId, Integer userId) implements Serializable {
}
