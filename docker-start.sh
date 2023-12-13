docker-compose -f docker-app-compose.yml down
docker-compose down
docker-compose up -d

mvn clean install -DskipTests

cd ./booking-service
mvn spring-boot:build-image -DskipTests \
  -Dspring-boot.build-image.imageName=booking-service

cd ../gateway-service
mvn spring-boot:build-image -DskipTests \
  -Dspring-boot.build-image.imageName=gateway-service

cd ../

docker-compose -f docker-app-compose.yml up -d