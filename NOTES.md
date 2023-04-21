All the information contained in this document usually would live in a ticket system like Jira, but since I do not have one to attach that information I will post it here for the sake of completeness.

# TODOs
## CALCULATOR
Improve readability of operation
Create integration tests to check contract with tracer
Decorate response, support multiple outputs? (exponents vs plain)
Improve algorithm
Make it an abstract tree where left and right might ot might not be strict operands
Document decimal configuration, document in general the API (also the need to escape operators + -> %2b)
Create a validator for the rawOperation
Research if equals and hashcode are required for records

## COMMON
Create specific exception for BigDecimalConverter
Create specific exception for OperationMapper
Create a tracer interface common for all possible tracer integrations
Create exception handling system (I assume in the future there might be other modules with endpoints)


## TRACER-CONNECTOR
Usually I would not have created this module at this stage. But, since I can only deliver this task with it included, I will create it now.
