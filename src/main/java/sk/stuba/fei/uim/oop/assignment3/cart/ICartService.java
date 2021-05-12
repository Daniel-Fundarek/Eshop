package sk.stuba.fei.uim.oop.assignment3.cart;



import java.util.List;


public interface ICartService {
    List<Cart> getAll();
    Cart create();
    Cart getCartById(Long request);

}
