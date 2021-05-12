package sk.stuba.fei.uim.oop.assignment3.cart2;

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

        ItemInCart newItem = new ItemInCart();
        newItem.setAmount(0);
        newItem.setProductId(0);
        this.itemRepository.save(newItem);

        Cart newCart = new Cart();

        newCart.setPayed(true);
        newCart.setItemInList(newItem);



        return this.repository.save(newCart);
    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }


}
