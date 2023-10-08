FROM  eclipse-temurin:17
COPY target/vehiapp.jar vehiapp.jar
CMD ["java","-jar","vehiapp.jar"]
