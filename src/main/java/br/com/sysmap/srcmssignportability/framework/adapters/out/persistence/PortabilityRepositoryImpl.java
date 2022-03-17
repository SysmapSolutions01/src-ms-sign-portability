package br.com.sysmap.srcmssignportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmssignportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmssignportability.domain.Portability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PortabilityRepositoryImpl implements PortabilityRepository {

    private final PortabilityRepositoryMongo portabilityRepository;

    @Override
    public Portability save(Portability portability) {
        return this.portabilityRepository.save(portability);
    }
}
