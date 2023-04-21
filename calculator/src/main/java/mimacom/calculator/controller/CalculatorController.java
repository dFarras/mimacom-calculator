package mimacom.calculator.controller;

import lombok.AllArgsConstructor;
import mimacom.calculator.service.CalculatorSrv;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/calculate")
public class CalculatorController {

    private final CalculatorSrv calculatorSrv;

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String calculate(
            @RequestParam String operation
    ) {
        BigDecimal result = this.calculatorSrv.doCalculate(operation);
        return result.toPlainString();
    }
}
