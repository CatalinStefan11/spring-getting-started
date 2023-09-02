package ro.sda.product_app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.product_app.exception.model.ClientError;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ProductAppExceptionHandler {

  public static String GENERIC_ERROR_MESSAGE = "Something went wrong!";

  @ExceptionHandler(value = ProductAppException.class)
  
  public ResponseEntity<ClientError> exception(Exception exception) {

    log.warn("An exception has occurred: {}", exception.getMessage());
    return ResponseEntity.internalServerError().body(
        new ClientError(LocalDateTime.now(), GENERIC_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR.value()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }
  
}
