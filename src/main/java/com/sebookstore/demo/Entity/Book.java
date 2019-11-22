package com.sebookstore.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable
{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private  Long id;

    @Column
    private String bookName;
    @Column
    private String author;
    @Column
    private String publisher;
    @Column
    private double price;
    @Column
    private int amount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getBookName()
    {
        return bookName;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
}
