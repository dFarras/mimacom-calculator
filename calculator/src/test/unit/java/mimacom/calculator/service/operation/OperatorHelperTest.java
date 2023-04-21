package mimacom.calculator.service.operation;

import mimacom.calculator.service.operation.operators.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OperatorHelperTest {
    @Mock
    private Operator operator;
    private OperatorHelper operatorHelper;

    @BeforeEach
    public void init() {
        this.operatorHelper = new OperatorHelper(List.of(this.operator));
    }


    @Test
    public void findOperatorIndexReturnsTheOperatorThatMatched() {
        OperatorIndexTuple expectation = new OperatorIndexTuple(1, this.operator);
        Mockito.when(this.operator.getOperation()).thenReturn("+");
        String target = "5+4";

        OperatorIndexTuple result = this.operatorHelper.findOperatorIndex(target);

        Assertions.assertEquals(expectation, result);
    }

    @Test()
    @Disabled("Until custom exception is created")
    public void findOperatorIndexThrowsExceptionIfNoOperatorMatches() {}
}
