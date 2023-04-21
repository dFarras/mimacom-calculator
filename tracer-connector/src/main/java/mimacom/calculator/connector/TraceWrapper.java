package mimacom.calculator.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import mimacom.calculator.reporter.Reporter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TraceWrapper implements Reporter {
    private final TracerImpl tracer = new TracerImpl();
    private final ObjectMapper objectMapper;

    @Override
    public <T> void trace(T value) throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(value);
        this.tracer.trace(result);
    }
}
