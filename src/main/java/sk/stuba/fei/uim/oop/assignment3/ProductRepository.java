package sk.stuba.fei.uim.oop.assignment3;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product>findAll();
    Product findAllById(Long id);
}
