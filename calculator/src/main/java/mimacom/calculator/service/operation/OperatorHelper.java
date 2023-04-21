package mimacom.calculator.service.operation;

import lombok.AllArgsConstructor;
import mimacom.calculator.exceptionhandlers.exceptions.ErrorCatalog;
import mimacom.calculator.service.operation.operators.Operator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OperatorHelper {
    private final List<Operator> operators;

    public OperatorIndexTuple findOperatorIndex(String target) {
        return this.operators
                .stream()
                .filter(operator -> target.contains(operator.getOperation()))
                .map(operator -> this.from(target, operator))
                .findAny()
                .orElseThrow(ErrorCatalog.UNKNOWN_OPERATOR::getException);
    }

    private OperatorIndexTuple from(String target, Operator operator) {
        int index = target.indexOf(operator.getOperation());
        return new OperatorIndexTuple(index, operator);
    }
}
