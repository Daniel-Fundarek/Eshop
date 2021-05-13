package sk.stuba.fei.uim.oop.assignment3.product;

import java.util.List;

public interface IProductService {
 List<Product> getAll();
 Product create(ProductRequest request);
 Product getProductById(long request);
 Boolean doesProductExist(long request);
 Product updateProductById(long request, ProductRequest productRequest);
 void delete(long request);
 Integer getAmount(long request);
 void changeAmount(long request, ProductRequest productRequest);
}

