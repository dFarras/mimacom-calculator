package mimacom.calculator.bigdecimal;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class BigDecimalConverter {
    private final MathContext context = new MathContext(10, RoundingMode.HALF_UP);

    public BigDecimal from(String value) {
        try {
            return new BigDecimal(value, context);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public String from(BigDecimal result) {
        return result.toPlainString();
    }
}
