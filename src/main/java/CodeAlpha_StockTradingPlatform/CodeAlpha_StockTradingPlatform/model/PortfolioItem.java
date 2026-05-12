package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trader trader;

    @ManyToOne
    private Stock stock;

    private int quantity;
    private BigDecimal averagePurchasePrice;

    public PortfolioItem() {}

    public PortfolioItem(Long id, Trader trader, Stock stock, int quantity, BigDecimal averagePurchasePrice) {
        this.id = id;
        this.trader = trader;
        this.stock = stock;
        this.quantity = quantity;
        this.averagePurchasePrice = averagePurchasePrice;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Trader getTrader() { return trader; }
    public void setTrader(Trader trader) { this.trader = trader; }
    public Stock getStock() { return stock; }
    public void setStock(Stock stock) { this.stock = stock; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getAveragePurchasePrice() { return averagePurchasePrice; }
    public void setAveragePurchasePrice(BigDecimal averagePurchasePrice) { this.averagePurchasePrice = averagePurchasePrice; }
}
