package sk.stuba.fei.uim.oop.assignment3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
  //  @GeneratedValue(strategy = default)
    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;
}
