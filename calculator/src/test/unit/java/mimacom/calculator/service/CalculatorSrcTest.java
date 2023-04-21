package mimacom.calculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import mimacom.calculator.reporter.Reporter;
import mimacom.calculator.service.operation.Operation;
import mimacom.calculator.service.operation.OperationMapper;
import mimacom.calculator.service.operation.operators.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CalculatorSrcTest {
    @Mock
    private Operator operator;
    @Mock
    private Operation operation;
    @Mock
    private OperationMapper mapper;
    @Mock
    private Reporter reporter;

    @InjectMocks
    private CalculatorSrv calculatorSrv;

    @Test
    public void doCalculateReturnsOperatorResolveResult() throws JsonProcessingException {
        String rawOperation = "5+4";
        BigDecimal expectation = new BigDecimal("1");
        Mockito.when(this.mapper.from(rawOperation)).thenReturn(this.operation);
        Mockito.when(this.operation.operator()).thenReturn(this.operator);
        Mockito.when(this.operator.resolve(any(), any())).thenReturn(expectation);

        BigDecimal result = this.calculatorSrv.doCalculate(rawOperation);

        Mockito.verify(this.reporter, Mockito.times(1)).trace(any());
        Assertions.assertEquals(expectation, result);
    }
}
