package com.power.controller;

import com.power.handler.BookNotFoundException;
import com.power.pojo.Book;
import com.power.pojo.BookContainer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Optional;

@Controller
public class BookController {

        @Autowired
        private BookContainer bookContainer;

        @ResponseBody
        @RequestMapping("/book")
        Book getBook(String isbn){
            Optional<Book> book = bookContainer.getBooks().stream().filter(el -> el.isbn().equals(isbn)).findFirst();
            if(book.isEmpty()){
                    throw new BookNotFoundException("isbn:" + isbn  + "查无此书");
            }
            return book.get();
        }

}

/*
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 *
 * Optional 类的引入很好的解决空指针异常
 */