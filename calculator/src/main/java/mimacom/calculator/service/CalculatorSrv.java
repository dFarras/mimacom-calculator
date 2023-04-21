package mimacom.calculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import mimacom.calculator.reporter.Reporter;
import mimacom.calculator.service.operation.OperationMapper;
import mimacom.calculator.service.operation.Operation;
import mimacom.calculator.service.operation.operators.Operator;
import mimacom.calculator.service.report.CalculatorReport;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CalculatorSrv {

    private final OperationMapper mapper;
    private final Reporter reporter;

    public BigDecimal doCalculate(
            final String rawOperation
    ) {
        Operation operation = this.mapper.from(rawOperation);
        Operator operator = operation.operator();
        BigDecimal left = operation.left();
        BigDecimal right = operation.right();
        BigDecimal result = operator.resolve(left, right);
        CalculatorReport report = new CalculatorReport(rawOperation, operation, result.toPlainString());
        try {
            this.reporter.trace(report);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
