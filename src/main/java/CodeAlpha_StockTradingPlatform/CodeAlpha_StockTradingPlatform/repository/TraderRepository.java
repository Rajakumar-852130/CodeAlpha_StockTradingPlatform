package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Long> {
}
