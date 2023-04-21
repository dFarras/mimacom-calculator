package mimacom.calculator.service.operation;

import mimacom.calculator.service.operation.operators.Operator;

import java.math.BigDecimal;

public record Operation(BigDecimal left, BigDecimal right, Operator operator) {
}
