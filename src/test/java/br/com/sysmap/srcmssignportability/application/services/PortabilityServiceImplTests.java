package br.com.sysmap.srcmssignportability.application.services;

import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityOpenFeign;
import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmssignportability.domain.enums.TelephoneCompany;
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
public class PortabilityServiceImplTests {
    EasyRandom easy = new EasyRandom();

    @Mock
    PortabilityRepository portabilityRepository;

    @Mock
    PortabilityOpenFeign portabilityOpenFeign;

    @InjectMocks
    PortabilityServiceImpl portabilityService;

    @Test
    @DisplayName("PortabilityService - callbackPortability_PORTADO")
    void callbackPortability_PORTADO() {
        Portability portability = easy.nextObject(Portability.class);
        portability.setNumber("123456789");
        portability.setSource(TelephoneCompany.VIVO);
        portability.setTarget(TelephoneCompany.OI);

        try {
            BDDMockito.given(portabilityRepository.save(any())).willReturn(portability);

            portabilityService.savePortability(portability);

            BDDMockito.verify(
                    portabilityOpenFeign,
                    BDDMockito.times(1)
            ).updatePortabilityStatus(portability.getPortabilityId(), PortabilityStatus.PORTADO);
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Test
    @DisplayName("PortabilityService - callbackPortability_NAO_PORTADO")
    void callbackPortability_NAO_PORTADO() {
        Portability portability = easy.nextObject(Portability.class);
        portability.setNumber("123456789");
        portability.setSource(TelephoneCompany.VIVO);
        portability.setTarget(TelephoneCompany.OI);

        Portability portabilityNumberInvalid = portability;
        portabilityNumberInvalid.setNumber("12345678");

        Portability portabilitySourceInvalid = portability;
        portabilitySourceInvalid.setSource(TelephoneCompany.CLARO);

        Portability portabilityTargetInvalid = portability;
        portabilityTargetInvalid.setTarget(TelephoneCompany.VIVO);

        try {
            BDDMockito.given(portabilityRepository.save(any())).willReturn(portability);

            portabilityService.savePortability(portabilityNumberInvalid);
            BDDMockito.verify(
                portabilityOpenFeign,
                BDDMockito.times(1)
            ).updatePortabilityStatus(
                portabilityNumberInvalid.getPortabilityId(),
                PortabilityStatus.NAO_PORTADO
            );

            portabilityService.savePortability(portabilitySourceInvalid);
            BDDMockito.verify(
                portabilityOpenFeign,
                BDDMockito.times(2)
            ).updatePortabilityStatus(
                portabilitySourceInvalid.getPortabilityId(),
                PortabilityStatus.NAO_PORTADO
            );

            portabilityService.savePortability(portabilityTargetInvalid);
            BDDMockito.verify(
                portabilityOpenFeign,
                BDDMockito.times(3)
            ).updatePortabilityStatus(
                portabilityTargetInvalid.getPortabilityId(),
                PortabilityStatus.NAO_PORTADO
            );

        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Test
    @DisplayName("PortabilityService - savePortability")
    void savePortability() {
        Portability portability = easy.nextObject(Portability.class);

        try {
            BDDMockito.given(portabilityRepository.save(any())).willReturn(portability);

            Portability portabilitySaved = portabilityService.savePortability(portability);
            Assertions.assertNotNull(portabilitySaved);
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }
}
