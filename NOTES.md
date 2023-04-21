All the information contained in this document usually would live in a ticket system like Jira, but since I do not have one to attach that information I will post it here for the sake of completeness.

# TODOs
## CALCULATOR
Create integration tests to check contract with tracer
Decorate response, support multiple outputs? (exponents vs plain)
Make it an abstract tree where left and right might ot might not be strict operands
Document decimal configuration, document in general the API (also the need to escape operators + -> %2b)
Create a validator for the rawOperation
Find a way to fail "gracefully" on reporter call

## COMMON
Improve exception handler for: jakarta.validation.ConstraintViolationException
