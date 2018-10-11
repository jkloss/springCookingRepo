package com.cooking.cook.model;

import com.cooking.cook.converters.SecretCodeConverter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(max = 20)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @Convert(converter = SecretCodeConverter.class)
    @NotBlank
    private String secretCode;

}
