package br.com.sysmap.srcmssignportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputPortability implements Serializable {
    private static final long serialVersionUID = 1L;

    private String number;
    private String documentNumber;
    private PortabilityDTO portability;
}
