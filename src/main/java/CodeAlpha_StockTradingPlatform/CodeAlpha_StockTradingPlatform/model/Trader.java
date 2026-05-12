package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private BigDecimal balance;

    @OneToMany(mappedBy = "trader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PortfolioItem> portfolio = new ArrayList<>();

    public Trader() {}

    public Trader(Long id, String name, BigDecimal balance, List<PortfolioItem> portfolio) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        if (portfolio != null) this.portfolio = portfolio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public List<PortfolioItem> getPortfolio() { return portfolio; }
    public void setPortfolio(List<PortfolioItem> portfolio) { this.portfolio = portfolio; }
}
