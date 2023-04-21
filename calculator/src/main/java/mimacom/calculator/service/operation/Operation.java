package mimacom.calculator.service.operation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mimacom.calculator.service.operation.operators.Operator;

import java.math.BigDecimal;

public record Operation(Operands operands, Operator operator) {
    @JsonIgnore
    public BigDecimal getLeft() {
        return this.operands.left();
    }

    @JsonIgnore
    public BigDecimal getRight() {
        return this.operands.right();
    }
}
