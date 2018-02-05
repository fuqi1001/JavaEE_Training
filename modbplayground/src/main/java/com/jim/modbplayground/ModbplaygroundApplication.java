package com.jim.modbplayground;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ModbplaygroundApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ModbplaygroundApplication.class, args);
	}


	/*@Autowired
	public CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception{
		customerRepository.deleteAll();

		customerRepository.save(new Customer("Jim", "Fu"));
		customerRepository.save(new Customer("Qi", "Fu"));

		System.out.println("Find all exist customer");
		List<Customer> allCustomer = customerRepository.findAll();
		for(Customer cur : allCustomer) {
			System.out.println(cur.firstName+" "+cur.lastName);
		}
		System.out.println();

		System.out.println("find jim");
		System.out.println(customerRepository.findByFirstName("Jim"));

		System.out.println();

		System.out.println("find fu");
		System.out.println(customerRepository.findByLastName("Fu"));
	}*/

	@Autowired
	public TodoItemsRepository todoItemsRepository;

	@Override
	public void run(String... args) throws Exception {





		System.out.println("find all");
		List<TodoItems> allTodo = todoItemsRepository.findAll();
		for(TodoItems cur : allTodo) {
			System.out.println(cur.title +" " + cur.description +" " +cur.completed +" " + cur.completedAt);
		}


		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB("lab3");
		DBCollection collection = database.getCollection("todoItems");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("completed", true);
		DBCursor cursor = collection.find(searchQuery);
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}



}
