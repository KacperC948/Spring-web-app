package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

//Spring Data tworzy repozytorium dla encji Book dzieki, ktorej po rozszerzeniu interfejsu Crud
// Repository bedziemy mogli w kontrolerze wykorzystac wszyskie metody crudowych takie jak save, find...
// Jako parametr w dla interfejsu CrudRepository podajemy jako pierwszy dla jakiej encji chcemy sworzyc
// repozytorium oraz jako drugi typ klucza głównego tej encji
//
//Repozytorium jest to obiekt dzieki któremu wykonujemy operacje bezpośrednio na bazie danych
public interface BookRepository extends CrudRepository<Book, Long> {
}
