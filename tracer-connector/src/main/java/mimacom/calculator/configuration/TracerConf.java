package mimacom.calculator.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mimacom.calculator.connector.TraceWrapper;
import mimacom.calculator.reporter.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracerConf {
    @Bean
    @Autowired
    @ConditionalOnProperty(
            name = "mimacom.reporter.impl",
            havingValue = "tracer"
    )
    public Reporter reporter(
            final ObjectMapper objectMapper
    ) {
        return new TraceWrapper(objectMapper);
    }
}
