package com.sebookstore.demo.Service.Impl;

import com.sebookstore.demo.Entity.Book;
import com.sebookstore.demo.Repository.BookRepository;
import com.sebookstore.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll()
    {
      return  bookRepository.findAll();
    }
    @Override
    public Book findById(long id)
    {
        return bookRepository.findById(id);
    }
    @Override
    public Book save(Book book)
    {
        return bookRepository.save(book);
    }
}
