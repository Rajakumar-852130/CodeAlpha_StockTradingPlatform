package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findBySymbol(String symbol);
}
