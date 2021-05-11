package sk.stuba.fei.uim.oop.assignment3.cart;

import sk.stuba.fei.uim.oop.assignment3.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    long id;
    List<ShoppingList> shoppingList = new ArrayList<>();
    Boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();

        ShoppingList newShoppingList = new ShoppingList();
        var list = cart.getShoppingList();
        if(!list.isEmpty()){
            for(int i=0; i< list.size();i++){
                if(i == 0){
                    newShoppingList.produtId = list.get(0).getProductId();
                }
            }





            for (ItemInCart  a :  cart.shoppingList){
                a.productId.equals(newShoppingList.produtId);

            }
        }
        this.shoppingList;

    }
}
