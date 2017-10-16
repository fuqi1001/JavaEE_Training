package main.java.com.jim.stock;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock", catalog = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE")})
public class Stock2 implements java.io.Serializable{
    private Integer stockId;
    private String stockCode;
    private String stockName;
    private Set<Category2>  categories = new HashSet<Category2>(0);

    public Stock2() {
    }

    public Stock2(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Stock2(String stockCode, String stockName, Set<Category2> categories) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.categories = categories;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "stock_category", catalog = "stock", joinColumns = {
            @JoinColumn(name="STOCK_ID", nullable = false, updatable = false)
    }, inverseJoinColumns = {@JoinColumn(name="CATEGORY_ID", nullable = false, updatable = false)})
    public Set<Category2> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category2> categories) {
        this.categories = categories;
    }
}
