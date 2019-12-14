package xyz.itshark.blog.javaadvent.intromicro.service;

import xyz.itshark.blog.javaadvent.intromicro.pojo.Book;
import xyz.itshark.blog.javaadvent.intromicro.repository.BookRepository;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class BookService {

    private BookRepository bookRepository;

    public BookService( BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
