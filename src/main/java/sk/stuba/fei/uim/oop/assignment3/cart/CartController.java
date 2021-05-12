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
    public CartResponse findCartById(@PathVariable("id") Long  request){
        return new CartResponse(service.getById(request));

    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") Long request){
        service.delete(request);
    }
    @PostMapping("/{id}/add")
    public Cart addItem(@PathVariable("id") Long request, @RequestBody BodyRequest body){

        return service.addItem(request,body);
    }

    @Autowired
    public void setService(ICartService service) {
        this.service = service;
    }
}
