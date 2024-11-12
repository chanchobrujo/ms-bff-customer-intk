FROM openjdk:17
VOLUME /tmp
EXPOSE 8092
ADD ./target/ms-bff-customer-intk-0.1.jar ms-bff-customer-intk-0.1.jar
ENTRYPOINT ["java", "-jar", "/ms-bff-customer-intk-0.1.jar"]