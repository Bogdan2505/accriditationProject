package com.prod.accriditationproject.exceptionHandler;

import com.prod.accriditationproject.exception.SignInException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignInExceptionControllerAdvice {

    @ExceptionHandler(SignInException.class)
    public ResponseEntity<String> handleEntityNotFoundException(SignInException exception) {
        return ResponseEntity.badRequest().body("Ошибка при входе в систему");
    }
}
