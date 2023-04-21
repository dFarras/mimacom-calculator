package mimacom.calculator.controller;

import mimacom.calculator.service.CalculatorSrv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @Mock
    private CalculatorSrv calculatorSrv;
    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    public void calculatorControllerDoesNothingApartFromDirectingRequestsToService() {
        BigDecimal expectation = new BigDecimal("1");
        String operation = "5+4";
        Mockito.when(this.calculatorSrv.doCalculate(operation)).thenReturn(expectation);

        String result = this.calculatorController.calculate(operation);

        Assertions.assertEquals(expectation.toPlainString(), result);
    }
}
