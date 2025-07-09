package ru.hippon.wikimedia.producer.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.hippon.wikimedia.producer.producer.WikimediaProducer;

@Service
@Slf4j
public class WikimediaStreamConsumer {
    private static final String API_URL = "https://stream.wikimedia.org/v2";
    private static final String API_CONSUME_URL_POSTFIX = "/stream/recentchange";
    private final WebClient webClient;
    private final WikimediaProducer producer;


    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl(API_URL)
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri(API_CONSUME_URL_POSTFIX)
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }
}
