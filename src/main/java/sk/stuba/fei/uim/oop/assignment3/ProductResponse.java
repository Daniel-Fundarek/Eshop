package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;

import javax.persistence.GeneratedValue;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;

    public ProductResponse(Product a){
        this.id = a.getId();
        this.name = a.getName();
        this.description = a.getDescription();
        this.amount = a.getAmount();
        this.unit = a.getUnit();
        this.price  = a.getPrice();

    }

}
