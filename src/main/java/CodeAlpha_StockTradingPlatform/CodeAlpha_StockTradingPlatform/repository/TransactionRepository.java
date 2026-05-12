package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.repository;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Transaction;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTraderOrderByTimestampDesc(Trader trader);
}
