package mimacom.calculator;

import mimacom.calculator.configuration.TracerConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(TracerConf.class)
@SpringBootApplication
public class CalculatorApp {
    public static void main( String[] args )
    {
        SpringApplication.run(CalculatorApp.class, args);
    }
}
