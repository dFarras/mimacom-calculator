package mimacom.calculator.service.operation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OperationValidator implements ConstraintValidator<OperationConstraint, String> {
    private static final char subtract = '-';
    private static final char add = '+';

    @Override
    public boolean isValid(
            String operation,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        int count = 0;
        for (char character : operation.toCharArray()) {
            if (isTargetCharacter(character)) {
                count++;
            }
        }
        return count == 1;
    }

    private boolean isTargetCharacter(char character) {
        return character == subtract || character == add;
    }
}
