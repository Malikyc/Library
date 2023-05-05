package org.malikyc.project1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Название не может быть пустым")
    @Length(min = 2,max = 30 , message = "Название книги должно быть в диопозоне от 2 до 30 символов")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "Автор должен быть указан")
    @Length(min = 2,max = 30 , message = "Имя автора должно быть в диопозоне от 2 до 30 символов")
    @Column(name = "author")
    private String author;
    @NotNull(message = "Год не может быть пустым")
    @Min(value = 0, message = "Год должен быть валидным")
    @Column(name = "prodyear")
    private int prodYear;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private Person owner;

    @Column(name = "dateofassign")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public boolean isExpired(){
        long millis = System.currentTimeMillis()-this.date.getTime();
        return millis>=60000;
    }
}
