package mimacom.calculator.service.operation;

import mimacom.calculator.bigdecimal.BigDecimalConverter;
import mimacom.calculator.service.operation.operators.Add;
import mimacom.calculator.service.operation.operators.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class OperationMapperTest {
    @Mock
    private OperatorHelper operatorHelper;
    @Spy
    private BigDecimalConverter bigDecimalConverter;
    @InjectMocks
    private OperationMapper operationMapper;

    @Test
    public void fromBuildsAnOperationFromItsHelpersResults() {
        Operator operator = new Add();
        Operation expectation = new Operation(new BigDecimal("5"), new BigDecimal("4"), operator);
        String rawOperation = "5+4";
        OperatorIndexTuple index = new OperatorIndexTuple(1, operator);
        Mockito.when(this.operatorHelper.findOperatorIndex(rawOperation)).thenReturn(index);

        Operation result = this.operationMapper.from(rawOperation);

        Assertions.assertEquals(expectation, result);
    }
}
