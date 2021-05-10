package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;
import org.apache.coyote.ajp.AjpNio2Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")

public class Controller {
    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(product -> new ProductResponse(product)).collect(Collectors.toList());
      /*  var result = new ArrayList<ProductResponse>();
        for(Product a : this.service.getAll()){
            result.add(new ProductResponse(a));
        }
        return result*/
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") ProductRequestById request) {
        if (!this.service.doesProductExist(request)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ProductResponse(this.service.getProductById(request)), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable("id") ProductRequestById request, @RequestBody ProductRequest productRequest) {
        if (!this.service.doesProductExist(request)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ProductResponse(this.service.updateProductById(request, productRequest)), HttpStatus.OK);
        }
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return new ProductResponse(this.service.create(request));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") ProductRequestById request) {

        if (!this.service.doesProductExist(request)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.service.delete(request);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}