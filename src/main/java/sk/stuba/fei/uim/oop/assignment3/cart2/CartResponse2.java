package sk.stuba.fei.uim.oop.assignment3.cart2;

import java.util.ArrayList;
import java.util.List;

public class CartResponse2 {
    long id;
    List<ShoppingList> shoppingList = new ArrayList<>();
    Boolean payed;

    public CartResponse2(Cart cart) {
      /*  this.id = cart.getId();

        ShoppingList newShoppingList = new ShoppingList();
        var list = cart.getShoppingList();
        if(!list.isEmpty()){
            for(int i=0; i< list.size();i++){
                if(i == 0){
                    newShoppingList.productId = list.get(0).getProductId();
                }
            }






        }
       // this.shoppingList;
*/
    }
}