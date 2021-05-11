package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService service;


    @PostMapping()
    public ResponseEntity<CartResponse> createCart(){

        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<CartResponse> getAllCarts(){
        return this.service.getAll().stream().map(cart -> new CartResponse(cart)).collect(Collectors.toList());
    }
}
