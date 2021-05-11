package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    private CartRepository repository;
    private ItemInCartRepository itemRepository;
    @Autowired
    public CartService(CartRepository repository, ItemInCartRepository itemRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Cart create() {

        Cart newCart = new Cart();
        newCart.setPayed(true);




        return this.repository.save(newCart);
    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }


}
