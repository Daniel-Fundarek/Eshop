package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            if(productService.doesProductExist(new ProductRequestById(body.getProductId()))) {
                int amount =productService.getAmount(new ProductRequestById(body.getProductId()));
                if(body.getAmount() <= amount) {

                    productService.changeAmount(new ProductRequestById(body.getProductId()),new ProductRequest(amount - body.getAmount()));
                    var item = itemService.findItemById((long) body.getProductId());
                    if (item.equals(null)) {
                        Item newItem = new Item((long) body.getProductId(), body.getAmount());
                        cart.getShoppingList().add(itemService.updateItem(newItem));
                    } else {
                        item.setAmount(item.getAmount() + body.getAmount());
                        cart.getShoppingList().add(itemService.updateItem(item));
                    }
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


       /* var shoppingList = cart.getShoppingList();
        for(int i =0;i < shoppingList.size();i++){
            if(shoppingList.get(i).getProductId() == body.getProductId()){
                shoppingList.get(i).setAmount(shoppingList.get(i).getAmount()+ body.getAmount());
            }
        }
        return null;*/
    }




}
