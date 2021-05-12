package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

public interface IItemService {
    Item create();
    Item findItemById(Long productId);
    Item updateItem(Item item);
   // Item findItemByProductId(Long productId);
}
