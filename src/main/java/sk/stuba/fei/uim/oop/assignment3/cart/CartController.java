package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController{

    private ICartService service;
    @GetMapping
    public List<CartResponse> getAll(){
        return this.service.getAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }
    @PostMapping
    public CartResponse createCart(){
        return new CartResponse(service.create());
    }
    @Autowired
    public void setService(ICartService service) {
        this.service = service;
    }
}
