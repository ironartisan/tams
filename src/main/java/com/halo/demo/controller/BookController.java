package com.halo.demo.controller;

import com.halo.demo.model.Book;
import com.halo.demo.model.Paper;
import com.halo.demo.service.BookService;
import com.halo.demo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:28.
 */

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有的项目信息
     */
    @RequestMapping("/ManageBook")
    public String teacherInfo(HttpServletRequest request, Model model) {
        List<Book> books = bookService.getAllBook();
        request.getSession().setAttribute("allBook", books);
        model.addAttribute("allBook", books);
        return "book_info";
    }
}