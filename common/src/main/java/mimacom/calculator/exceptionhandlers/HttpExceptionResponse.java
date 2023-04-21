package mimacom.calculator.exceptionhandlers;

public record HttpExceptionResponse(String code, String genericMessage, String clarifiedMessage) {
}
