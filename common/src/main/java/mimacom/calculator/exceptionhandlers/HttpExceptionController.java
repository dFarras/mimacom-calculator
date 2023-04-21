package mimacom.calculator.exceptionhandlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import mimacom.calculator.exceptionhandlers.exceptions.HttpException;
import mimacom.calculator.reporter.Reporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class HttpExceptionController {
    private final Reporter reporter;

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<HttpExceptionResponse> handleHttpException(final HttpException httpException) {
        String code = httpException.getCode();
        String genericMessage = httpException.getGenericMessage();
        String clarifiedMessage = httpException.getClarifiedMessage();
        final HttpExceptionResponse response = new HttpExceptionResponse(code, genericMessage, clarifiedMessage);
        try {
            reporter.trace(httpException);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to report an error. Code: " + code);
        }
        return new ResponseEntity<>(response, httpException.getHttpStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HttpExceptionResponse> handleHttpException(final ConstraintViolationException constraintViolationException) {
        String code = "DATA-002";
        String genericMessage = "Invalid operation";
        String clarifiedMessage = "There is no particular clarification for this error";
        final HttpExceptionResponse response = new HttpExceptionResponse(code, genericMessage, clarifiedMessage);
        try {
            reporter.trace(constraintViolationException);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to report an error. Code: " + code);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
