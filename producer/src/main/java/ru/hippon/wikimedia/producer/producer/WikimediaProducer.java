package ru.hippon.wikimedia.producer.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${hippon.topic.name}")
    private String topic;

    public void sendMessage(@NonNull String msg) {
        kafkaTemplate.send(topic, msg);
    }
}
