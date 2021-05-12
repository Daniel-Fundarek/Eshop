package sk.stuba.fei.uim.oop.assignment3.cart2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInCartRepository extends CrudRepository<ItemInCart,Long> {
}
