package br.com.sysmap.srcmssignportability.application.ports.in;

import br.com.sysmap.srcmssignportability.domain.Portability;

public interface PortabilityService {
    void callbackPortability(Portability portability);
    Portability savePortability(Portability portability);
}
