package com.jeremias.dev.bussines.libros.validations;

import com.jeremias.dev.bussines.libros.models.Book;
import com.jeremias.dev.bussines.libros.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Slf4j
public class TitleExistValidator implements ConstraintValidator<TitleValidation, String> {
    private TitleValidation constraintAnnotation;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void initialize(TitleValidation constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Book> obj = bookRepository.findByTitle(value);
        if(!obj.isPresent()){
            return true;
        }
        return false;
    }
}
