package br.com.sysmap.srcmssignportability.framework.adapters.in.consumer;

import br.com.sysmap.srcmssignportability.application.services.PortabilityServiceImpl;
import br.com.sysmap.srcmssignportability.domain.Portability;
import com.google.gson.Gson;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class KafkaServiceImplTests {
    EasyRandom easy = new EasyRandom();

    @Mock
    PortabilityServiceImpl portabilityService;

    @InjectMocks
    KafkaConsumerImpl kafkaConsumer;

    @Test
    @DisplayName("PortabilityService - Listen")
    void listen() {
        Gson gson = new Gson();
        Portability portability = easy.nextObject(Portability.class);
        InputPortability inputPortability = easy.nextObject(InputPortability.class);
        ConsumerRecord<String, String> payload = new ConsumerRecord<>(
            "Teste",
            1,
            1L,
            "Teste",
            gson.toJson(inputPortability)
        );

        try {
            BDDMockito.given(portabilityService.savePortability(any())).willReturn(portability);

            kafkaConsumer.listen(payload);

            BDDMockito.verify(
                    portabilityService,
                    BDDMockito.times(1)
            ).savePortability(any());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }
}
