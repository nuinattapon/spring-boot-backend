```
mvn clean install -Dmaven.test.skip=true

java -XX:+UseZGC -XX:+ZGenerational -jar ./target/backend-0.0.1-SNAPSHOT.jar 
```
