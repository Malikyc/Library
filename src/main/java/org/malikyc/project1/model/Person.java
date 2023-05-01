package org.malikyc.project1.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Person {
    private int id;
    @NotEmpty(message = "Имя не может быть пустым")
    @Length(min = 2,max = 30 , message = "Имя должно быть в диопозоне от 2 до 30 символов")
    private String fullName;
    @NotNull(message = "Возрас должен быть указан")
    @Min(value = 0, message = "Год должен быть валидным")
    private int birthDate;

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
