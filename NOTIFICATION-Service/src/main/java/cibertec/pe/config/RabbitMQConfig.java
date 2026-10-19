package cibertec.pe.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "citas.queue";

    @Bean
    public Queue citaQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}