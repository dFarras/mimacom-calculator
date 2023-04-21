package mimacom.calculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mimacom.calculator.reporter.Reporter;
import mimacom.calculator.service.operation.Operation;
import mimacom.calculator.service.operation.OperationMapper;
import mimacom.calculator.service.operation.operators.Operator;
import mimacom.calculator.service.operation.validation.OperationConstraint;
import mimacom.calculator.service.report.CalculatorReport;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Service
@Validated
@AllArgsConstructor
public class CalculatorSrv {

    private final OperationMapper mapper;
    private final Reporter reporter;

    public BigDecimal doCalculate(
            @Valid @OperationConstraint() final String rawOperation
    ) {
        Operation operation = this.mapper.from(rawOperation);
        Operator operator = operation.operator();
        BigDecimal left = operation.getLeft();
        BigDecimal right = operation.getRight();
        BigDecimal result = operator.resolve(left, right);
        CalculatorReport report = new CalculatorReport(rawOperation, operation, result.toPlainString());
        try {
            this.reporter.trace(report);
        } catch (JsonProcessingException e) {
            System.out.println("Error while reporting an operation.");
        }
        return result;
    }
}
