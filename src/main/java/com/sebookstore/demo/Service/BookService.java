package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.Book;

import java.util.List;

public interface BookService
{
    List<Book> findAll();
    Book findById(long id);
    Book save(Book book);
}
