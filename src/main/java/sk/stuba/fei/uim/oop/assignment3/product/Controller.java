package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") long request) {
        return new ProductResponse(this.service.getProductById(request));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProductById(@PathVariable("id") long request, @RequestBody ProductRequest productRequest) {
        return new ProductResponse(this.service.updateProductById(request, productRequest));

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return new ProductResponse(this.service.create(request));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") long request) {
        this.service.delete(request);
    }

    @GetMapping("/{id}/amount")
    public AmountOfProduct getAmountOfProduct(@PathVariable("id") long request) {
        return new AmountOfProduct(this.service.getAmount(request));
    }

    @PostMapping("/{id}/amount")
    public AmountOfProduct postAmountOfProduct(@PathVariable("id") long request, @RequestBody ProductRequest productRequest) {
        this.service.changeAmount(request,productRequest);
        return new AmountOfProduct(this.service.getAmount(request));
    }

}