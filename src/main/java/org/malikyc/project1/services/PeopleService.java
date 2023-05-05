package org.malikyc.project1.services;

import org.malikyc.project1.model.Book;
import org.malikyc.project1.model.Person;
import org.malikyc.project1.repositories.BookRepository;
import org.malikyc.project1.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
private final PeopleRepository peopleRepository;
private final BookRepository bookRepository;
   @Autowired
    public PeopleService(PeopleRepository peopleRepository, BookRepository bookRepository) {
        this.peopleRepository = peopleRepository;
       this.bookRepository = bookRepository;
   }

    public List<Person> people(){
       return peopleRepository.findAll();
    }

    public Person findPerson(Integer id){
       if(id == null){
           id = -1;
       }
       return peopleRepository.findById(id).orElse(null);
    }

    public Optional<Person> findPersonByName(String name){
       return peopleRepository.findByFullName(name);
    }
    @Transactional
    public void addNewPerson(Person person){
       peopleRepository.save(person);
    }
    @Transactional
    public void updatePerson(Person person){
       peopleRepository.save(person);
    }
    @Transactional
    public void deletePerson(int id){
       peopleRepository.deleteById(id);
    }

    public List<Book> findBookList(Person owner){
       return bookRepository.findByOwner(owner);
    }
}
