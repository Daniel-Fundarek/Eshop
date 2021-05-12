package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse createCart(){
        return new CartResponse(service.create());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> findCartById(@PathVariable("id") Long  request){
        return new ResponseEntity<>(new CartResponse(service.getById(request)), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public

    @Autowired
    public void setService(ICartService service) {
        this.service = service;
    }
}
