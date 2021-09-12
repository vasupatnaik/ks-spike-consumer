package com.spike.consumer.config;

import com.spike.common.dto.Domain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfig {

    @Bean
    public Consumer<KStream<String, Domain>> streamConsumer(){
        return kstream -> kstream.foreach(((key, value) -> {
            //TODO do what you want in the consumer.
            log.info("Consumer : Domain -> {}",value.getDomain());
        }));
    }
}
