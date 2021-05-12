package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepo extends CrudRepository<Item,Long> {
List<Item> findAll();
}
