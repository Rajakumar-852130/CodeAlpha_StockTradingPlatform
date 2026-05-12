package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.service;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Stock;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository.StockRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    private final Random random = new Random();

    @PostConstruct
    public void initStocks() {
        if (stockRepository.count() == 0) {
            stockRepository.save(new Stock(null, "AAPL", "Apple Inc.", new BigDecimal("150.00"), BigDecimal.ZERO));
            stockRepository.save(new Stock(null, "GOOGL", "Alphabet Inc.", new BigDecimal("2800.00"), BigDecimal.ZERO));
            stockRepository.save(new Stock(null, "TSLA", "Tesla Inc.", new BigDecimal("700.00"), BigDecimal.ZERO));
            stockRepository.save(new Stock(null, "AMZN", "Amazon.com Inc.", new BigDecimal("3300.00"), BigDecimal.ZERO));
            stockRepository.save(new Stock(null, "MSFT", "Microsoft Corp.", new BigDecimal("300.00"), BigDecimal.ZERO));
            stockRepository.save(new Stock(null, "NFLX", "Netflix Inc.", new BigDecimal("500.00"), BigDecimal.ZERO));
        }
    }

    @Scheduled(fixedRate = 5000) // Every 5 seconds
    public void updatePrices() {
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            double changePercent = (random.nextDouble() * 4 - 2); // -2% to +2%
            BigDecimal changeValue = stock.getCurrentPrice().multiply(new BigDecimal(changePercent / 100));
            stock.setCurrentPrice(stock.getCurrentPrice().add(changeValue).setScale(2, RoundingMode.HALF_UP));
            stock.setPriceChange(new BigDecimal(changePercent).setScale(2, RoundingMode.HALF_UP));
            stockRepository.save(stock);
        }
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}
