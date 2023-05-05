package org.malikyc.project1.validator;

import org.malikyc.project1.dao.LibraryDao;
import org.malikyc.project1.model.Person;
import org.malikyc.project1.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;
    private final LibraryDao libraryDao;
    @Autowired
    public PersonValidator(PeopleService peopleService, LibraryDao libraryDao) {
        this.peopleService = peopleService;
        this.libraryDao = libraryDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(peopleService.findPersonByName(person.getFullName()).isPresent()){
               errors.rejectValue("fullName","","Такое ФИО уже существует");
        }
    }
}
