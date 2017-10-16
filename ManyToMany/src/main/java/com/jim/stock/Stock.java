package main.java.com.jim.stock;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stock implements Serializable{
    private Integer stockId;
    private String stockCode;
    private String stockName;
    private Set<Category> categories = new HashSet<Category>(0);

    public Stock() {
    }

    public Stock(Integer stockId, String stockCode, String stockName, Set<Category> categories) {
        this.stockId = stockId;
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.categories = categories;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
