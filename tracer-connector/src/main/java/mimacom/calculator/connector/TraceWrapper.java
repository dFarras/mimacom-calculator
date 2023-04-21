package mimacom.calculator.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.corp.calculator.TracerImpl;
import mimacom.calculator.reporter.Reporter;

public class TraceWrapper implements Reporter {
    private final TracerImpl tracer = new TracerImpl();
    private final ObjectMapper objectMapper;

    public TraceWrapper(
            final ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> void trace(T value) throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(value);
        this.tracer.trace(result);
    }
}
