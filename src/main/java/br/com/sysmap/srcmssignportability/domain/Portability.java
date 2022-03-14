package br.com.sysmap.srcmssignportability.domain;

import br.com.sysmap.srcmssignportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmssignportability.domain.enums.TelephoneCompany;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Document(collection = "portability")
public class Portability implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Indexed(unique = true)
    private UUID portabilityId;
    private String number;
    private String documentNumber;
    private TelephoneCompany source;
    private TelephoneCompany target;
    private PortabilityStatus status;
}
