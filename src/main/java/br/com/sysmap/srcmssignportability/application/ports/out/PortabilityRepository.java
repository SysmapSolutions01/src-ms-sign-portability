package br.com.sysmap.srcmssignportability.application.ports.out;

import br.com.sysmap.srcmssignportability.domain.Portability;

public interface PortabilityRepository {

    Portability save(Portability portability);

}
