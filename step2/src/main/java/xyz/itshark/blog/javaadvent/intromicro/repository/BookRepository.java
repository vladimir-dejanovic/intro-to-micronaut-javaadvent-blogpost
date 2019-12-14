package xyz.itshark.blog.javaadvent.intromicro.repository;

import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.annotation.Repository;
import xyz.itshark.blog.javaadvent.intromicro.pojo.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
