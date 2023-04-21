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
        String rawLeft = operation.substring(0, operatorIndexTuple.index());
        BigDecimal left = this.bigDecimalConverter.from(rawLeft);
        String rawRight = operation.substring(operatorIndexTuple.index() + 1);
        BigDecimal right = this.bigDecimalConverter.from(rawRight);
        return new Operation(left, right, operatorIndexTuple.operator());
    }
}
