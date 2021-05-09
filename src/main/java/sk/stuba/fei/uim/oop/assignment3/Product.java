package sk.stuba.fei.uim.oop.assignment3;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;

}
