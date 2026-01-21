package root.nidjat.notification.configuration.handlers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventHandler {
    final String topic = "notification-topic";
    @KafkaListener (topics = topic, groupId = "notificationModule")
    public void handleUserEvent (String value) {
        System.out.println(value + " - успешно принято из продюсера!");
    }

}
