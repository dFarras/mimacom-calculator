To create a self contained jar any mvn command that triggers package phase is enough to create this kind of jar.
For instance mvn clean package or mvn clean install.

And to execute it just java -jar
java -jar calculator-1.0-SNAPSHOT-jar-with-dependencies.jar