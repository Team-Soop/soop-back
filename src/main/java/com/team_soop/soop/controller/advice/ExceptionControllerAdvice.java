package com.team_soop.soop.controller.advice;

import com.team_soop.soop.exception.DeleteException;
import com.team_soop.soop.exception.MenuCategoryException;
import com.team_soop.soop.exception.SaveException;
import com.team_soop.soop.exception.ValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(SaveException.class)
    public ResponseEntity<?> saveException(SaveException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(ValidException.class)
    public ResponseEntity<?> validException(ValidException e) {
        return ResponseEntity.badRequest().body(e.getErrorMap());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFoundException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentialsException(BadCredentialsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MenuCategoryException.class)
    public ResponseEntity<?> menuCategoryException(MenuCategoryException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<?> DeleteException(DeleteException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
