package xyz.itshark.blog.javaadvent.intromicro.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import xyz.itshark.blog.javaadvent.intromicro.pojo.Book;
import xyz.itshark.blog.javaadvent.intromicro.service.BookService;

import java.util.List;

@Controller("/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @Get("/")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @Get("/{id}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.findById(id).orElse(null);
    }

    @Post("/")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public Book addBook(@Body Book book) {
        return bookService.addBook(book);
    }
}