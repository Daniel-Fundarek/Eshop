package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private ProductRepository repository;
    @Autowired
    public ProductService(ProductRepository repository) {
      /*  this.repository = repository;
        Product a = new Product();
        a.setAmount(5);
        a.setDescription("cute");
        a.setName("sweatshirt");
        a.setPrice(500);
        a.setUnit("five");

        this.repository.save(a);
        Product b = new Product();
        b.setAmount(10);
        b.setDescription("ugly");
        b.setName("croptop");
        b.setPrice(100);
        b.setUnit("six");

        this.repository.save(b);*/
    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setAmount(request.getAmount());
        newProduct.setDescription(request.getDescription());
        newProduct.setName(request.getName());
        newProduct.setPrice(request.getPrice());
        newProduct.setUnit(request.getUnit());
        return this.repository.save(newProduct);

    }
}
