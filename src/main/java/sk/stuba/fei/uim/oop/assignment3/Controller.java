package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;
import org.apache.coyote.ajp.AjpNio2Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")

public class Controller {
    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(product -> new ProductResponse(product)).collect(Collectors.toList());
      /*  var result = new ArrayList<ProductResponse>();
        for(Product a : this.service.getAll()){
            result.add(new ProductResponse(a));
        }
        return result*/
    }
    @PostMapping()
    public ProductResponse addProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.create(request));


    }
}
