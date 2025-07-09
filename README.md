# Spring Boot Kafka test

Демо проект для знакомства с Kafka. Состоит из 2х частей:
- Producer - Сервис перенаправляет сообщения с https://stream.wikimedia.org/v2/stream/recentchange на локальный сервер Apache Kafka.
- Consumer - сервис читает сообщения с локального сервера Apache Kafka.
# Сборка и запуск
Перед стартом сервисов убедитесь, что локально запущен Apache Kafka и он доступен по адресу `localhost:9092`.

## Consumer
```bash
cd consumer
./mvnw spring-boot:run
```

или собрать JAR:
```bash
./mvnw package
```

## Producer
```bash
cd producer
./mvnw spring-boot:run
```

или собрать JAR:
```bash
./mvnw package
```

После запуска обоих сервисов отправьте GET запрос на адрес `localhost:8080/api/v1/wikimedia`.