package root.nidjat.notification.configuration;

import org.apache.el.stream.Stream;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfiguration {
    @Value("${spring.kafka.bootstrap-servers")
    String bootstrapService;
    public ConsumerFactory<String, String> consumerfactory () {
        Map<String, Object> Props = new HashMap<>();
        Props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        Props.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-group");
        Props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(Props);
    }
    public ConcurrentKafkaListenerContainerFactory <String, String> ConsumerKafkaTemplate () {
        ConcurrentKafkaListenerContainerFactory <String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerfactory());
        return factory;
    }


}
