package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ItemInCart {
    private Integer productId;
    private Integer amount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
