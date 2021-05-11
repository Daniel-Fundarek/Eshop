package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    List<ItemInCart> shoppingList = new ArrayList<>();
    boolean payed;

    public Cart(ArrayList<ItemInCart> shoppingList, boolean payed) {
        this.shoppingList = shoppingList;
        this.payed = payed;
    }
}
