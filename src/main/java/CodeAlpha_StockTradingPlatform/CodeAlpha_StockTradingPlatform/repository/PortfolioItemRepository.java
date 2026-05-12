package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.PortfolioItem;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Stock;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    Optional<PortfolioItem> findByTraderAndStock(Trader trader, Stock stock);
}
