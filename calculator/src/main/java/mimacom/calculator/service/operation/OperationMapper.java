package mimacom.calculator.service.operation;

import lombok.AllArgsConstructor;
import mimacom.calculator.bigdecimal.BigDecimalConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class OperationMapper {
    private final OperatorHelper operatorHelper;
    private final BigDecimalConverter bigDecimalConverter;

    public Operation from(String operation) {
        OperatorIndexTuple operatorIndexTuple = this.operatorHelper.findOperatorIndex(operation);
        Operands operands = this.getOperand(operation, operatorIndexTuple.index());
        return new Operation(operands, operatorIndexTuple.operator());
    }

    private Operands getOperand(String operation, int operatorIndex) {
        BigDecimal left = this.bigDecimalConverter.from(operation.substring(0, operatorIndex));
        BigDecimal right = this.bigDecimalConverter.from(operation.substring(operatorIndex + 1));
        return new Operands(left, right);
    }
}
