package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService{
    private CartRepository repository;
    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart create() {
        var newCart = new Cart();
        newCart.setShoppingListItem(new ItemInCart());
        newCart.setPayed(true);
        return this.repository.save(newCart);
    }
}
