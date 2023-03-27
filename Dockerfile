FROM openjdk:19

COPY target/student-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","student-0.0.1-SNAPSHOT.jar"]