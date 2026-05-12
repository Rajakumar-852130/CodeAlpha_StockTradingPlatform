package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.service;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.*;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradingService {

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private PortfolioItemRepository portfolioRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostConstruct
    public void initTrader() {
        if (traderRepository.count() == 0) {
            traderRepository.save(new Trader(null, "Raj Kumar", new BigDecimal("10000.00"), null));
        }
    }

    public Trader getTrader() {
        return traderRepository.findAll().get(0);
    }

    @Transactional
    public void buyStock(String symbol, int quantity) {
        Trader trader = getTrader();
        Stock stock = stockRepository.findBySymbol(symbol).orElseThrow();
        BigDecimal totalCost = stock.getCurrentPrice().multiply(new BigDecimal(quantity));

        if (trader.getBalance().compareTo(totalCost) >= 0) {
            trader.setBalance(trader.getBalance().subtract(totalCost));
            
            PortfolioItem item = portfolioRepository.findByTraderAndStock(trader, stock)
                    .orElse(new PortfolioItem(null, trader, stock, 0, java.math.BigDecimal.ZERO));
            
            // Calculate new average price
            java.math.BigDecimal totalQuantity = new java.math.BigDecimal(item.getQuantity() + quantity);
            java.math.BigDecimal currentTotalValue = item.getAveragePurchasePrice().multiply(new java.math.BigDecimal(item.getQuantity()));
            java.math.BigDecimal newTotalValue = currentTotalValue.add(totalCost);
            
            item.setAveragePurchasePrice(newTotalValue.divide(totalQuantity, 2, java.math.RoundingMode.HALF_UP));
            item.setQuantity(item.getQuantity() + quantity);
            
            portfolioRepository.save(item);
            traderRepository.save(trader);
            
            recordTransaction("BUY", symbol, quantity, stock.getCurrentPrice(), trader);
        }
    }

    public java.math.BigDecimal getTotalPortfolioValue() {
        Trader trader = getTrader();
        java.math.BigDecimal stockValue = java.math.BigDecimal.ZERO;
        for (PortfolioItem item : trader.getPortfolio()) {
            stockValue = stockValue.add(item.getStock().getCurrentPrice().multiply(new java.math.BigDecimal(item.getQuantity())));
        }
        return trader.getBalance().add(stockValue);
    }

    @Transactional
    public void sellStock(String symbol, int quantity) {
        Trader trader = getTrader();
        Stock stock = stockRepository.findBySymbol(symbol).orElseThrow();
        PortfolioItem item = portfolioRepository.findByTraderAndStock(trader, stock).orElseThrow();

        if (item.getQuantity() >= quantity) {
            BigDecimal totalGain = stock.getCurrentPrice().multiply(new BigDecimal(quantity));
            trader.setBalance(trader.getBalance().add(totalGain));
            item.setQuantity(item.getQuantity() - quantity);

            if (item.getQuantity() == 0) {
                portfolioRepository.delete(item);
            } else {
                portfolioRepository.save(item);
            }
            
            traderRepository.save(trader);
            recordTransaction("SELL", symbol, quantity, stock.getCurrentPrice(), trader);
        }
    }

    private void recordTransaction(String type, String symbol, int quantity, BigDecimal price, Trader trader) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        transaction.setStockSymbol(symbol);
        transaction.setQuantity(quantity);
        transaction.setPriceAtTransaction(price);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setTrader(trader);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionRepository.findByTraderOrderByTimestampDesc(getTrader());
    }
}
