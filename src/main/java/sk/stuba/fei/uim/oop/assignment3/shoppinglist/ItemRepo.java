package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item,Long> {

}
