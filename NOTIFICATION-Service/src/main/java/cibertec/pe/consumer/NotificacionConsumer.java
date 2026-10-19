package cibertec.pe.consumer;

import cibertec.pe.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void recibirMensaje(String mensaje) {
        System.out.println("==================================================");
        System.out.println("📧 SIMULANDO ENVÍO DE CORREO ELECTRÓNICO:");
        System.out.println(mensaje);
        System.out.println("==================================================");
    }
}