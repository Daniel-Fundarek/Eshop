package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Integer amount;
    private String unit;
    private Double price;

    public ProductRequest(Integer amount) {
        this.amount = amount;
    }
}

