package com.codegym.casestudy.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "test")
@Component
public class User implements Validator {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, Long age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;

    @Min(18)
    private Long age;

    @NotEmpty
    @Size(min = 10, max = 11)
    @Pattern(regexp = "^$|[0-9]{10}", message = "{Pattern.customer.phoneNumber}")
    private String phoneNumber;

    @NotEmpty
    @Pattern(regexp = "(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$)", message = "{Pattern.customer.email}")
    private String email;

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s', age='%d' ,email='%s']", id, firstName, lastName ,age,email);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }

    }
}

