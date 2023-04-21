package mimacom.calculator.service.operation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OperationValidator.class)
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationConstraint {
    String message() default "Invalid operation";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
