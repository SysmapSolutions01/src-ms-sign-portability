package br.com.sysmap.srcmssignportability.application.ports.in;

import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.PortabilityDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {
    void listen(ConsumerRecord<String, String> payload);
}
