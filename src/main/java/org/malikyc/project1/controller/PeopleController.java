package org.malikyc.project1.controller;

import jakarta.validation.Valid;
import org.malikyc.project1.dao.LibraryDao;
import org.malikyc.project1.model.Person;
import org.malikyc.project1.services.PeopleService;
import org.malikyc.project1.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final LibraryDao libraryDao;
    private final PeopleService peopleService;
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(LibraryDao libraryDao, PeopleService peopleService, PersonValidator personValidator) {
        this.libraryDao = libraryDao;
        this.peopleService = peopleService;
        this.personValidator = personValidator;
    }


    @GetMapping()
    public String peopleList(Model model){
        model.addAttribute("people",
                peopleService.people());
        return "people/index";
    }
    @GetMapping("/new")
    public String addPersonPage(@ModelAttribute("person")Person person){
        return "people/new";
    }

    @PostMapping("/new")
    public String addPerson(@ModelAttribute("person") @Valid Person person, BindingResult result){
        personValidator.validate(person,result);
        if(result.hasErrors()){
            return "people/new";
        }
        peopleService.addNewPerson(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}")
    public String person(@PathVariable("id") int id,Model model){
        Person person = peopleService.findPerson(id);
        model.addAttribute("person",person);
        model.addAttribute("booksOfPerson",peopleService.findBookList(person));
        return "people/person";
    }
    @GetMapping("/{id}/edit")
    public String personEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("person",peopleService.findPerson(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid Person person, BindingResult result){
        personValidator.validate(person,result);
        if(result.hasErrors()){
            return "people/edit";
        }
        peopleService.updatePerson(person);
        return "redirect:/people";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        peopleService.deletePerson(id);
        return "redirect:/people";
    }
}
