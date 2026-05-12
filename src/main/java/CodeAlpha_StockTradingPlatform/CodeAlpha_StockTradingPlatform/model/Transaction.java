package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String stockSymbol;
    private int quantity;
    private BigDecimal priceAtTransaction;
    private LocalDateTime timestamp;

    @ManyToOne
    private Trader trader;

    public Transaction() {}

    public Transaction(Long id, String type, String stockSymbol, int quantity, BigDecimal priceAtTransaction, LocalDateTime timestamp, Trader trader) {
        this.id = id;
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.timestamp = timestamp;
        this.trader = trader;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getPriceAtTransaction() { return priceAtTransaction; }
    public void setPriceAtTransaction(BigDecimal priceAtTransaction) { this.priceAtTransaction = priceAtTransaction; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Trader getTrader() { return trader; }
    public void setTrader(Trader trader) { this.trader = trader; }
}
