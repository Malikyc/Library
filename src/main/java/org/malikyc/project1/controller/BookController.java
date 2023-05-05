package org.malikyc.project1.controller;

import org.malikyc.project1.dao.LibraryDao;
import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.malikyc.project1.services.BookService;
import org.malikyc.project1.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final LibraryDao libraryDao;
    private final BookService bookService;
    private final PeopleService peopleService;

    @Autowired
    public BookController(LibraryDao libraryDao, BookService bookService, PeopleService peopleService) {
        this.libraryDao = libraryDao;
        this.bookService = bookService;
        this.peopleService = peopleService;
    }


    @GetMapping()
    public String bookList(Model model,@RequestParam(value = "page",required = false) Integer page,
                           @RequestParam(value = "booksPerPage",required = false) Integer books,
                           @RequestParam(value = "sortedByYear",required = false)Boolean sorted){
        model.addAttribute("books",
                bookService.bookList(page,books,sorted));
        return "book/index";
    }
    @GetMapping("/new")
    public String addBookPage(@ModelAttribute("book") Book book){
        return "book/new";
    }

    @PostMapping("/new")
    public String addBook(@ModelAttribute("book")Book book){
        bookService.saveBook(book);
        return "redirect:/book";
    }
    @GetMapping("/{id}")
    public String book(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("personTo")Person person){
        Book book = bookService.book(id);
        model.addAttribute("book",book);
        if(book.getOwner()!=null){
        model.addAttribute("bookOwner",peopleService.findPerson(book.getOwner().getId()));}
        else {
        model.addAttribute("people",peopleService.people());}
        return "book/book";
    }
    @GetMapping("/{id}/edit")
    public String bookEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("book",bookService.book(id));
        return "book/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("book") Book book){
       bookService.updateBook(book);
        return "redirect:/book";
    }
    @PostMapping("/assign/{id}")
    public String userAdd(@ModelAttribute("person") Person person,@PathVariable("id") Integer id){
        bookService.updateUserOfBook(person,id);
        return "redirect:/book/"+ id;
    }
    @PostMapping("/release/{id}")
    public String userAdd(@PathVariable("id") Integer id){
        bookService.release(id);
        return "redirect:/book/"+ id;
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/people";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "title",required = false) String title,
                         Model model){
        if(title!=null){
            List<Book> books = bookService.search(title);
        model.addAttribute("books",bookService.search(title));
        }
        return "book/search";
    }



}
