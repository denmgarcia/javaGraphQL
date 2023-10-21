package com.graphQL.GraphQL.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphQL.GraphQL.model.Book;
import com.graphQL.GraphQL.repository.BookRepository;

@Controller
public class BookController {    
    
    private final BookRepository bookRepository;    
    
    public BookController(BookRepository bookRepository) {        
        this.bookRepository = bookRepository;    
    }

    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @SchemaMapping(typeName = "Query",value = "findBook")
    public Book findBook(@Argument Integer id) {
        return bookRepository.findOne(id);
    }


}