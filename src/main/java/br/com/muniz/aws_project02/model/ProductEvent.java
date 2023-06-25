package br.com.muniz.aws_project02.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEvent {

    private long productId;
    private String code;
    private String username;

}
