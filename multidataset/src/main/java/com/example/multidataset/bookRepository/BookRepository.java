package com.example.multidataset.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multidataset.modelBook.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
