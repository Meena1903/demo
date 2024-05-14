package com.example.restdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class RestdemoApplication {

	@Autowired
	private List<Dummy> dummyData;

    @PostConstruct
    public void init() {
        dummyData = new ArrayList<>();
        dummyData.add(new Dummy(1, "To Kill a Mockingbird"));
        dummyData.add(new Dummy(2, "1984"));
        dummyData.add(new Dummy(3, "The Great Gatsby"));
        dummyData.add(new Dummy(4, "The Catcher in the Rye"));
        dummyData.add(new Dummy(5, "The Hobbit"));
    }

    @GetMapping("/dummies")
    public List<Dummy> getDummy() {
        return dummyData;
    }

	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
	}

}
