package br.com.sysmap.srcmssignportability.framework.adapters.out.openfeign;

import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
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

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PortabilityOpenfeignImplTests {
    @Mock
    PortabilityFeignClient portabilityFeignClient;

    @InjectMocks
    PortabilityOpenfeignImpl portabilityOpenfeign;


    @Test
    @DisplayName("PortabilityService - savePortability")
    void savePortability() {
        UUID portabilityId = UUID.randomUUID();
        PortabilityStatus portabilityStatus = PortabilityStatus.PORTADO;

        try {
            BDDMockito.given(portabilityFeignClient.update(any(),any())).willReturn("ok");

            portabilityOpenfeign.updatePortabilityStatus(portabilityId, portabilityStatus);

            BDDMockito.verify(
                portabilityFeignClient,
                BDDMockito.times(1)
            ).update(any(),any());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }
}
