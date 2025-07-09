# Spring Boot Kafka test

Демо проект для знакомства с Kafka. Состоит из 2х частей:
- Producer - Сервис перенаправляет сообщения с https://stream.wikimedia.org/v2/stream/recentchange на локальный сервер Apache Kafka.
- Consumer - сервис читает сообщения с локального сервера Apache Kafka.

# Запуск
1. Запустить локальный сервис Apache Kafka на порту `9092`;
2. Запустить Consumer;
3. Запустить Producer;4. Отправить GET запрос на адрес `localhost:8080/api/v1/wikimedia`.
