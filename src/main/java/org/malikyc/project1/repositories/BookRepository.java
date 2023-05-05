package org.malikyc.project1.repositories;

import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByOwner(Person owner);

    List<Book> findBookByTitleIgnoreCaseStartingWith(String title);

}
