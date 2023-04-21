package mimacom.calculator.service.report;

import mimacom.calculator.service.operation.Operation;

public record CalculatorReport(String rawOperation, Operation operation, String result) {
}
