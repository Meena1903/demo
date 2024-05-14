package com.example.multidataset1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.multidataset1.model.Book;
import com.example.multidataset1.model.User;
import com.example.multidataset1.repository.bookRepository.BookRepository;
import com.example.multidataset1.repository.userRepository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.multidataset1.model"})
@EnableJpaRepositories(basePackages = {"com.example.multidataset1.repository"})
public class Multidataset1Application {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addData2DB(){

		userRepository.saveAll(Stream.of(
			new User(101, "John", "john@gmail.com", 5646799754L, 4),
			new User(102, "Jai", "jai@gmal.com", 8954356789L, 1),
			new User(103, "Javid", "javid@gmail.com",6768976543L, 2), 
			new User(104, "Jam", "jam@gmail.com", 8765647654L, 3)) 
			.collect(Collectors.toList()));

		bookRepository.saveAll(Stream.of(
			new Book(111, "Java 101"),
			new Book(112, "C 101"),
			new Book(113, "Python 101"),
			new Book(114, "C# 101"))
			.collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(Multidataset1Application.class, args);
	}

}
