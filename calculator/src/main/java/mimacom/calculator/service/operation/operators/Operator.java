package mimacom.calculator.service.operation.operators;

import java.math.BigDecimal;

public interface Operator {
    String getOperation();
    BigDecimal resolve(BigDecimal firstOperand, BigDecimal secondOperand);
}
