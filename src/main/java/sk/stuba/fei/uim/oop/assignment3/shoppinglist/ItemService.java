package sk.stuba.fei.uim.oop.assignment3.shoppinglist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.ICartService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {
    @Autowired
    ICartService cartService;
    @Autowired
    ItemRepo repository;
    @Override
    public Item create() {
        Item newItem = new Item();
        //newItem.setAmount(0);
        //newItem.setProductId(0);
        return this.repository.save(newItem);
    }


    @Override
    public Item findItemById(Long productId) {
       // Optional<Item> itemOptional = repository.findByProductId(productId);
        Optional<Item> itemOptional = repository.findById(productId);
        Item item = itemOptional.orElse(null);
        return item;
    }

    @Override
    public Item findItemByProductId(Long productId) {
        List<Item> items = repository.findAll();
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).getProductId().equals(productId) ){
                return items.get(i);
            }
        }
        return null;
    }

    @Override
    public Item updateItem(Item item) {

        return  repository.save(item);
    }

    //@Autowired
    /*public ItemService(ICartService cartService) {
        this.cartService = cartService;
    }*/
}
