# SPRING BOOT 3.05
**Status:** Solved below since they are vulnerabilities from transient dependencies

| CVE            | Description                                                                                                                | Result                                      |
|----------------|----------------------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| CVE-2023-25194 | Possible security vulnerability has been identified in Apache Kafka Connect that requires access to a Kafka Connect worker | Not applicable since we are not using Kafka |
| CVE-2022-4492  | The undertow client is not checking the server identity presented by the server certificate in https connections           | Fixed using Tomcat instead                  |

# SNAKEYAML
**Origin:** Transitive from spring-boot-starter-web 3.05

**Status:** Solved by upgrading to latest version

| CVE            | Description                                                                                              | Result                                                  |
|----------------|----------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| CVE-2022-1471  | SnakeYaml's Constructor() class does not restrict types which can be instantiated during deserialization | Upgraded snakeyaml transitive dependency to 2.0 version |
| CVE-2022-41854 | Those using Snakeyaml to parse untrusted YAML files may be vulnerable to Denial of Service attacks (DOS) | Upgraded snakeyaml transitive dependency to 2.0 version |

# TOMCAT EMBEDDED
**Origin:** Transitive dependency from spring-boot-starter-web:3.0.5

**Status:** Nothing. It has no known vulnerabilities but there is a newer version. Fixes CVE-2022-4492