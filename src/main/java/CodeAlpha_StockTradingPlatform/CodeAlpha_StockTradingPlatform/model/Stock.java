package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String symbol;
    private String name;
    private BigDecimal currentPrice;
    private BigDecimal priceChange;

    public Stock() {}

    public Stock(Long id, String symbol, String name, BigDecimal currentPrice, BigDecimal priceChange) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
        this.priceChange = priceChange;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(BigDecimal currentPrice) { this.currentPrice = currentPrice; }
    public BigDecimal getPriceChange() { return priceChange; }
    public void setPriceChange(BigDecimal priceChange) { this.priceChange = priceChange; }
}
