package main.java.com.jim.stock;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category", catalog = "stock")
public class Category2 {
    private Integer categoryId;
    private String name;
    private String desc;
    private Set<Stock2> stocks = new HashSet<Stock2>(0);

    public Category2() {
    }

    public Category2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Category2(String name, String desc, Set<Stock2> stocks) {
        this.name = name;
        this.desc = desc;
        this.stocks = stocks;
    }


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "NAME", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="[DESC]", nullable = false)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    public Set<Stock2> getStocks() {
        return this.stocks;
    }

    public void setStocks(Set<Stock2> stocks) {
        this.stocks = stocks;
    }
}
