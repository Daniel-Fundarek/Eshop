package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@Entity
public class ItemInCart {
    Integer productId;
    Integer amount;
    @Id
    private Long id;





}
