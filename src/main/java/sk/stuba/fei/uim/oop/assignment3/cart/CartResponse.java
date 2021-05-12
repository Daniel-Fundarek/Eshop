package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CartResponse {
    private long id;
    private List<ItemResponse> shoppingList = new ArrayList<>();
    private boolean payed;

    public void setShoppingList(Cart cart){
        for (int i =0; i<cart.getShoppingList().size();i++) {
            this.shoppingList.add(new ItemResponse(cart.getShoppingList().get(i).getProductId(), cart.getShoppingList().get(i).getAmount()));
        }
    }

    public CartResponse(Cart cart) {
        setShoppingList(cart);
        this.id = cart.getId();
        this.payed = cart.isPayed();
    }
}

