package mimacom.calculator.service;

import lombok.AllArgsConstructor;
import mimacom.calculator.service.operation.OperationMapper;
import mimacom.calculator.service.operation.Operation;
import mimacom.calculator.service.operation.operators.Operator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CalculatorSrv {

    private final OperationMapper mapper;

    public BigDecimal doCalculate(
            String rawOperation
    ) {
        Operation operation = this.mapper.from(rawOperation);
        Operator operator = operation.operator();
        BigDecimal left = operation.left();
        BigDecimal right = operation.right();
        return operator.resolve(left, right);
    }
}
