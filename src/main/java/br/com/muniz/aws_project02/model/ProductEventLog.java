package br.com.muniz.aws_project02.model;

import br.com.muniz.aws_project02.enums.EventTypeEnumm;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "product-events")
@NoArgsConstructor
public class ProductEventLog {

    @Id
    private ProductEventKey productEventKey;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "eventType")
    private EventTypeEnumm eventType;

    @DynamoDBAttribute(attributeName = "productId")
    private long productId;

    @DynamoDBAttribute(attributeName = "username")
    private String username;

    @DynamoDBAttribute(attributeName = "timestamp")
    private long timestamp;

    @DynamoDBAttribute(attributeName = "ttl")
    private long ttl;

    @DynamoDBHashKey(attributeName = "pk")
    public String getPk(){
        return this.productEventKey != null ? this.productEventKey.getPk() : null;
    }

    public void setPk(String pk){
        if(this.productEventKey == null){
            this.productEventKey = new ProductEventKey();
        }
        this.productEventKey.setPk(pk);
    }

    @DynamoDBHashKey(attributeName = "sk")
    public String getSk(){
        return this.productEventKey != null ? this.productEventKey.getSk() : null;
    }

    public void setSk(String sk){
        if(this.productEventKey == null){
            this.productEventKey = new ProductEventKey();
        }
        this.productEventKey.setSk(sk);
    }

    public EventTypeEnumm getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnumm eventType) {
        this.eventType = eventType;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
