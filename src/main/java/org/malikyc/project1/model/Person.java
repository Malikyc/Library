package org.malikyc.project1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "person1")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Имя не может быть пустым")
    @Length(min = 2,max = 30 , message = "Имя должно быть в диопозоне от 2 до 30 символов")
    @Column(name = "fullname")
    private String fullName;
    @NotNull(message = "Возрас должен быть указан")
    @Min(value = 0, message = "Год должен быть валидным")
    @Column(name = "birthdate")
    private int birthDate;

    @OneToMany(mappedBy = "owner")
    private List<Book> bookList;

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
}
