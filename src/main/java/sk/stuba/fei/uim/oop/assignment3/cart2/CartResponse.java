package sk.stuba.fei.uim.oop.assignment3.cart2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor

public class CartResponse {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private boolean payed;
    private List<ShoppingList> shoppingList = new ArrayList<>();

   /* public CartResponse(long id, boolean payed, List<ItemInCart> shoppingList) {
        this.id = id;
        this.payed = payed;
        for (int i = 0; i < shoppingList.size(); i++){
            this.shoppingList.add(new ShoppingList(shoppingList.get(i).getProductId(),shoppingList.get(i).getAmount()));
        }
    }*/
    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.payed = cart.isPayed();

        for (int i = 0; i < cart.getShoppingList().size(); i++){
            this.shoppingList.add(new ShoppingList(cart.getShoppingList().get(i).getProductId(),cart.getShoppingList().get(i).getAmount()));
        }

    }

}
