package main.java.com.jim;

import main.java.com.jim.stock.Category2;
import main.java.com.jim.stock.Stock2;
import main.java.com.jim.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class App2 {
    public static void main(String[] args) {
        System.out.println("Hibernate many to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Stock2 stock2 = new Stock2();
        stock2.setStockCode("1001");
        stock2.setStockName("JIM");

        Category2 category1 = new Category2("CONSUMER2", "CONSUMER2 COMPANY");
        Category2 category2 = new Category2("INVESTMENT", "INVESTMENT COMPANY");

        Set<Category2> categories = new HashSet<Category2>();
        categories.add(category1);
        categories.add(category2);

        stock2.setCategories(categories);

        session.save(stock2);

        session.getTransaction().commit();
        System.out.println("Done");
    }

}
