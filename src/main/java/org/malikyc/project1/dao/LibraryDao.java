package org.malikyc.project1.dao;

import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryDao {
//    private final JdbcTemplate jdbcTemplate;
//
//    public LibraryDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//   public List<Person> peopleList(){
//        return jdbcTemplate.query("SELECT * FROM Person1",
//                new BeanPropertyRowMapper<>(Person.class));
//   }
//
//   public void addNewPerson(Person person){
//        jdbcTemplate.update("INSERT INTO Person1 (fullname,birhdate) VALUES(?,?)",
//                person.getFullName(),person.getBirthDate());
//   }
//
//   public Person particularPerson(Integer id){
//        return jdbcTemplate.query("SELECT * FROM Person1 WHERE id=?",
//                        new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).
//                stream().findAny().orElse(null);
//   }
//    public Optional<Person> particularPersonByName(String fullName) {
//        return jdbcTemplate.query("SELECT * FROM Person1 WHERE fullname=?",
//                        new Object[]{fullName},new BeanPropertyRowMapper<>(Person.class)).
//                stream().findAny();
//    }
//
//    public void updatePerson(Person person){
//        jdbcTemplate.update("UPDATE Person1 SET fullname=?,birthdate=? WHERE id=?",
//                person.getFullName(),person.getBirthDate(),person.getId());
//    }
//    public void deletePerson(Integer id){
//        jdbcTemplate.update("DELETE from Person1 WHERE id=?",id);
//    }
//
//    //////Books
//
//    public List<Book> bookList(){
//        return jdbcTemplate.query("SELECT * FROM book",
//                new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public void addNewBook(Book book){
//        jdbcTemplate.update("INSERT INTO Book (title,author,prodyear,user_id) VALUES(?,?,?,?)",
//                book.getTitle(),book.getAuthor(),book.getProdYear(),null);
//    }
//
//    public Book particularBook(Integer id){
//        Book book = jdbcTemplate.query("SELECT * FROM book WHERE id=?",
//                        new Object[]{id},new BeanPropertyRowMapper<>(Book.class)).
//                stream().findAny().orElse(null);
//        return book;
//    }
//
//    public List<Book> particularBookOfUser(int id){
//        return jdbcTemplate.query("SELECT * FROM book WHERE user_id=?",
//                        new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
//
//    }
//
//    public void updateBook(Book book){
//        jdbcTemplate.update("UPDATE book SET title=?,author=?,prodYear=?,user_id=? WHERE id=?",
//                book.getTitle(),book.getAuthor(),book.getProdYear(),book.getUser_id(),book.getId());
//    }
//
//
//    public void updateBookUser(Book book) {
//        jdbcTemplate.update("UPDATE book SET user_id=? WHERE id=?",
//                book.getUser_id(),book.getId());
//    }
//    public void deleteBook(Integer id){
//        jdbcTemplate.update("DELETE from book WHERE id=?",id);
//    }
//

}
