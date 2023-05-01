package org.malikyc.project1.controller;

import jakarta.validation.Valid;
import org.malikyc.project1.dao.LibraryDao;
import org.malikyc.project1.model.Person;
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
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(LibraryDao libraryDao, PersonValidator personValidator) {
        this.libraryDao = libraryDao;
        this.personValidator = personValidator;
    }


    @GetMapping()
    public String peopleList(Model model){
        model.addAttribute("people",
                libraryDao.peopleList());
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
        libraryDao.addNewPerson(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}")
    public String person(@PathVariable("id") int id,Model model){
        model.addAttribute("person",libraryDao.particularPerson(id));
        model.addAttribute("booksOfPerson",libraryDao.particularBookOfUser(id));
        model.addAttribute("people",libraryDao.peopleList());
        return "people/person";
    }
    @GetMapping("/{id}/edit")
    public String personEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("person",libraryDao.particularPerson(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid Person person, BindingResult result){
        personValidator.validate(person,result);
        if(result.hasErrors()){
            return "people/edit";
        }
        libraryDao.updatePerson(person);
        return "redirect:/people";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        libraryDao.deletePerson(id);
        return "redirect:/people";
    }
}
