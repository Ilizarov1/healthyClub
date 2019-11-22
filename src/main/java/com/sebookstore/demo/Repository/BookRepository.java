package com.sebookstore.demo.Repository;

import com.sebookstore.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>
{
    List<Book> findAll();
    Book findById(long id);
}
