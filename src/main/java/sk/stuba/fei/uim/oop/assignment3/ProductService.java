package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository repository;
}
