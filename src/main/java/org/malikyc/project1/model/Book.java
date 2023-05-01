package org.malikyc.project1.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class Book {
    private int id;
    private Integer user_id;
    @NotEmpty(message = "Название не может быть пустым")
    @Length(min = 2,max = 30 , message = "Название книги должно быть в диопозоне от 2 до 30 символов")
    private String title;
    @NotEmpty(message = "Автор должен быть указан")
    @Length(min = 2,max = 30 , message = "Имя автора должно быть в диопозоне от 2 до 30 символов")
    private String author;
    @NotEmpty(message = "Год не может быть пустым")
    @Min(value = 0, message = "Год должен быть валидным")
    private int prodYear;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
}
