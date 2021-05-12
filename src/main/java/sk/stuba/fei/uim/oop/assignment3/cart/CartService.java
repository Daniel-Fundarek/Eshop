package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.IItemService;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    @Setter
    private IItemService itemService;
    private CartRepo repository;


    @Autowired
    public CartService(CartRepo repository) {
        this.repository = repository;

        /* var cart = new Cart();
         cart.setPayed(false);
         this.repository.save(cart);*/


    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cart create() {
         Cart newCart = new Cart();
         newCart.setPayed(true);
         newCart.getShoppingList().add(itemService.create());
        return repository.save(newCart);
    }
}
