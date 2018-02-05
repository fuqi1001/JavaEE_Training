package com.jim.modbplayground;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoItemsRepository extends MongoRepository<TodoItems, String> {

    public List<TodoItems> findAll();
}
