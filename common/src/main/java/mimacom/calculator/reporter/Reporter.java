package mimacom.calculator.reporter;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Reporter {
    public <T> void trace(T value) throws JsonProcessingException;
}
