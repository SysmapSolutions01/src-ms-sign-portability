package br.com.sysmap.srcmssignportability.application.ports.in;

import br.com.sysmap.srcmssignportability.domain.Portability;
import br.com.sysmap.srcmssignportability.framework.adapters.in.dtos.InputPortability;

public interface PortabilityService {
    void callbackPortability(InputPortability inputPortability);
    Portability savePortability(Portability portability);
}
