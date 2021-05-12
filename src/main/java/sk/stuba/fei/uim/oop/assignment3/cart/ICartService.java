package sk.stuba.fei.uim.oop.assignment3.cart;



import sk.stuba.fei.uim.oop.assignment3.shoppinglist.Item;

import java.util.List;


public interface ICartService {
    List<Cart> getAll();
    Cart create();
    Cart getById(long id);

    void delete(long id);
    Cart addItem(Long id, BodyRequest body );
    Cart findItemInCartAndChangeAmount(Cart cart, Long productId,Item item);
}
