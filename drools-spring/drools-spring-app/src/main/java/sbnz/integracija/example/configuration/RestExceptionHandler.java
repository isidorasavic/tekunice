package sbnz.integracija.example.configuration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sbnz.integracija.example.exception.ErrorResponse;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.exception.UserNotFoundException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND);
        error.setMessage(e.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    protected ResponseEntity<Object> handleInvalidArgumentException(InvalidArgumentException e) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE);
        error.setMessage(e.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> runtimeException(RuntimeException e) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE);
        error.setMessage(e.getMessage());
        return buildResponseEntity(error);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

}
