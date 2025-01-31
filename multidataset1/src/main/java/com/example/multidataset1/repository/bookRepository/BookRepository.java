package com.example.multidataset1.repository.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multidataset1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
