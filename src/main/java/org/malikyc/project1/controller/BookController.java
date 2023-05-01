package org.malikyc.project1.controller;

import org.malikyc.project1.dao.LibraryDao;
import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    private final LibraryDao libraryDao;

    @Autowired
    public BookController(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }


    @GetMapping()
    public String bookList(Model model){
        model.addAttribute("books",
                libraryDao.bookList());
        return "book/index";
    }
    @GetMapping("/new")
    public String addBookPage(@ModelAttribute("book") Book book){
        return "book/new";
    }

    @PostMapping("/new")
    public String addBook(@ModelAttribute("book")Book book){
        libraryDao.addNewBook(book);
        return "redirect:/book";
    }
    @GetMapping("/{id}")
    public String book(@PathVariable("id") Integer id,Model model){
        Book book = libraryDao.particularBook(id);
        model.addAttribute("book",book);
        model.addAttribute("bookOwner",libraryDao.particularPerson(book.getUser_id()));
        model.addAttribute("people",libraryDao.peopleList());
        return "book/book";
    }
    @GetMapping("/{id}/edit")
    public String bookEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("book",libraryDao.particularBook(id));
        return "book/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("book") Book book){
        libraryDao.updateBook(book);
        return "redirect:/book";
    }
    @PostMapping("/newUser/{id}")
    public String userAdd(@ModelAttribute("book") Book book){
        libraryDao.updateBookUser(book);
        return "redirect:/book/"+ book.getId();
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        libraryDao.deleteBook(id);
        return "redirect:/people";
    }
}
