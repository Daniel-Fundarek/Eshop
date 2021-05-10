package sk.stuba.fei.uim.oop.assignment3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;
}