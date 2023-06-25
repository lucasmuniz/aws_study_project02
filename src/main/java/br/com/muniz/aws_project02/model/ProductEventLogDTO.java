package br.com.muniz.aws_project02.model;

import br.com.muniz.aws_project02.enums.EventTypeEnumm;
import lombok.Getter;

@Getter
public class ProductEventLogDTO {

    private final String code;
    private final EventTypeEnumm eventType;
    private final long productId;
    private final String username;
    private final long timestamp;

    public ProductEventLogDTO(ProductEventLog productEventLog) {
        this.code = productEventLog.getPk();
        this.eventType = productEventLog.getEventType();
        this.productId = productEventLog.getProductId();
        this.username = productEventLog.getUsername();
        this.timestamp = productEventLog.getTimestamp();
    }
}
