package org.malikyc.project1.services;

import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.malikyc.project1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;
   @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> bookList(Integer page,Integer bookPerPage,Boolean sorted){
      if(page != null && bookPerPage != null && sorted != null){
          if(sorted){
          return bookRepository.findAll(PageRequest.of(page,
                  bookPerPage,
                  Sort.by("prodyear"))).getContent();
      }}
      else if(page != null && bookPerPage != null){
          return bookRepository.findAll(PageRequest.of(page,
                  bookPerPage)).getContent();
      }
      else if(sorted != null){
          if (sorted){
          return bookRepository.findAll(Sort.by("prodYear"));
      }}
      return bookRepository.findAll();
    }
    public List<Book> search(String title){
       if(title == null){
           return new ArrayList<Book>();
       }
       List<Book> books = bookRepository.findBookByTitleIgnoreCaseStartingWith(title);
       return bookRepository.findBookByTitleIgnoreCaseStartingWith(title);
    }

    public Book book(int id){
       return bookRepository.findById(id).orElse(null);
    }
    @Transactional
    public void saveBook(Book book){
       bookRepository.save(book);
    }
    @Transactional
    public void updateBook(Book book){
       bookRepository.save(book);
    }
    @Transactional
    public void updateUserOfBook(Person person,Integer id){
      Book bookUp = book(id);
      bookUp.setOwner(person);
      bookUp.setDate(new Date());
       bookRepository.save(bookUp);
    }
    @Transactional
    public void release(Integer id){
        Book bookUp = book(id);
        bookUp.setOwner(null);
        bookUp.setDate(null);
        bookRepository.save(bookUp);
    }
    @Transactional
    public void deleteBook(int id){
       bookRepository.deleteById(id);
    }



}
