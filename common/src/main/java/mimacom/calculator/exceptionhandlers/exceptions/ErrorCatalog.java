package mimacom.calculator.exceptionhandlers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
@AllArgsConstructor
public enum ErrorCatalog {
    NOT_A_NUMBER(HttpStatus.NOT_FOUND, "DATA-001", "Data provided does not correspond to a valid numerical representation"),
    UNKNOWN_OPERATOR(HttpStatus.BAD_REQUEST, "DATA-003", "Unrecognized operator");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public HttpException getException() {
        return new HttpException(this.httpStatus, this.code, this.message);
    }

    public HttpException getException(final String clarifiedMessage) {
        return new HttpException(this.httpStatus, this.code, this.message, clarifiedMessage);
    }

}
