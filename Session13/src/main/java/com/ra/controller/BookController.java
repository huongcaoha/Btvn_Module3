package com.ra.controller;

import com.ra.model.dao.impl.BookDAOImpl;
import com.ra.model.entity.Book;
import com.ra.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController{
    @Autowired
    BookDAOImpl bookDAO ;

    @GetMapping
    public String display(Model model){
        model.addAttribute("books",bookDAO.getAll());
        return "book/display";
    }

    @GetMapping("/create")
    public String create(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "book/create";
    }
    @PostMapping("/create")
    public String add( @ModelAttribute("book") Book book){
        bookDAO.add(book);
        return "redirect:/book";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model , @PathVariable int id){
        Book book = bookDAO.findById(id);
        model.addAttribute("book" , book);
        return "/book/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id , @ModelAttribute("book") Book book){
        if(bookDAO.update(book)){
            return "redirect:/book" ;
        }else {
            return "redirect:/book/edit/"+ id ;
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        bookDAO.delete(id);
        return "redirect:/book" ;
    }
}
