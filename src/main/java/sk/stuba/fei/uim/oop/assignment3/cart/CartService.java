package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sk.stuba.fei.uim.oop.assignment3.IProductService;
import sk.stuba.fei.uim.oop.assignment3.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.ProductRequestById;
import sk.stuba.fei.uim.oop.assignment3.exceptions.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.IItemService;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.Item;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ItemRepo;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    @Setter
    IProductService productService;
    @Autowired
    @Setter
    private IItemService itemService;
    private CartRepo repository;
    @Autowired
    @Setter
    private ItemRepo itemRepository;

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
         newCart.setPayed(false);
       //  newCart.getShoppingList().add(itemService.create());
        return repository.save(newCart);
    }

    @Override
    public Cart getById(long id) {
        return this.repository.findById(id).orElseThrow();
    }



    @Override
    public void delete(long id) {
        Cart cart = getById(id);
        for(int i =0;i < cart.getShoppingList().size();i++){
            productService.changeAmount(cart.getShoppingList().get(i).getProductId(),new ProductRequest(cart.getShoppingList().get(i).getProductId()));
            this.itemRepository.delete(cart.getShoppingList().get(i));
        }
        this.repository.delete(cart);
    }

    @Override
    public Cart addItem(Long id, BodyRequest body) {

        Cart cart = getById(id);
        if(cart.isPayed()){
            throw new BadRequestException();
            // vrat nejako 400 este neviem ako mozno nejaku exception
        }
        else{
            if(productService.doesProductExist(body.getProductId())) {
                int amount = productService.getAmount(body.getProductId());
                if(body.getAmount() <= amount) {
                    cart = createNewOrReuseItem(cart,body);
                    return repository.save(cart);
                }
                else{
                    throw new BadRequestException();
                    // not enough 400
                }
            }
            else{
                // produkt neexistuje 404 not found
                throw new NotFoundException();
            }
        }
    }

    @Override
    public Cart findItemInCartAndChangeAmount(Cart cart, Long productId,Item item) {
        for(int i =0 ; i< cart.getShoppingList().size(); i++)
            if(cart.getShoppingList().get(i).getProductId().equals(productId)){
                 cart.getShoppingList().remove(i);
                 cart.getShoppingList().add(item);
            }
        return cart;
    }

    @Override
    public Integer isProductInCart(Cart cart, Long productId) {
        for(int i =0 ; i< cart.getShoppingList().size(); i++)
            if(cart.getShoppingList().get(i).getProductId().equals(productId)){
               return i;
            }
        return null;
    }
    @Override
    public Cart createNewOrReuseItem(Cart cart , BodyRequest body){
        productService.changeAmount(body.getProductId(),new ProductRequest(- body.getAmount()));
        var index = isProductInCart(cart, body.getProductId());
        Item item;
        if(index == null){
            item = null;
        }
        else {
            item = cart.getShoppingList().get(index);
        }
        if (item == null) {
            Item newItem = new Item( body.getProductId(), body.getAmount());
            cart.getShoppingList().add(itemService.updateItem(newItem));
        } else {
            item.setAmount(item.getAmount() + body.getAmount());
            cart = findItemInCartAndChangeAmount(cart, body.getProductId(),  itemService.updateItem(item));
        }
        return cart;
    }

}
