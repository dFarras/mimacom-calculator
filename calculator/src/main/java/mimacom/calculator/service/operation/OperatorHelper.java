package mimacom.calculator.service.operation;

import lombok.AllArgsConstructor;
import mimacom.calculator.service.operation.operators.Operator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OperatorHelper {
    private final List<Operator> operators;

    public OperatorIndexTuple findOperatorIndex(String target) {
        Optional<OperatorIndexTuple> result = this.operators
                .stream()
                .filter(operator -> target.contains(operator.getOperation()))
                .map(operator -> {
                    int index = target.indexOf(operator.getOperation());
                    return new OperatorIndexTuple(index, operator);
                })
                .findAny();
        if (result.isEmpty()) {
            throw new RuntimeException();
        }
        return result.get();
    }
}
