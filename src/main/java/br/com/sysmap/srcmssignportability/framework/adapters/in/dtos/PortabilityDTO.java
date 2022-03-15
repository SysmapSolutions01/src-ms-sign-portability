package br.com.sysmap.srcmssignportability.framework.adapters.in.dtos;

import br.com.sysmap.srcmssignportability.domain.enums.TelephoneCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortabilityDTO implements Serializable {
     private static final long serialVersionUID = 1L;

     private UUID id;
     private TelephoneCompany source;
     private TelephoneCompany target;
}
