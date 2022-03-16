package br.com.sysmap.srcmssignportability.framework.adapters.out.dtos;

import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PortabilityFeignClientDTO {
    PortabilityStatus portabilityStatus;
}
