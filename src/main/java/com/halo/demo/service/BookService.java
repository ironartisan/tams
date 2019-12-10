package com.halo.demo.service;

import com.halo.demo.mapper.BookMapper;
import com.halo.demo.mapper.PaperMapper;
import com.halo.demo.model.Book;
import com.halo.demo.model.BookExample;
import com.halo.demo.model.Paper;
import com.halo.demo.model.PaperExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBook() {
        BookExample bookExample = new BookExample();
        List<Book> books = bookMapper.selectByExample(bookExample);
        return books;
    }
}
