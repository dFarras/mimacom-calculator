package mimacom.calculator.service.operation.operators;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Add implements Operator {
    @Override
    public String getOperation() {
        return "+";
    }

    @Override
    public BigDecimal resolve(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.add(secondOperand);
    }
}
