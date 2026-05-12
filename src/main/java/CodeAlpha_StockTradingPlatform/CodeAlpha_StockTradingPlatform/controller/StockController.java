package CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.controller;

import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.model.Stock;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.service.StockService;
import CodeAlpha_StockTradingPlatform.CodeAlpha_StockTradingPlatform.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private TradingService tradingService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("stocks", stockService.getAllStocks());
        model.addAttribute("trader", tradingService.getTrader());
        model.addAttribute("totalValue", tradingService.getTotalPortfolioValue());
        model.addAttribute("transactions", tradingService.getTransactionHistory());
        return "index";
    }

    @PostMapping("/buy")
    public String buy(@RequestParam String symbol, @RequestParam int quantity) {
        tradingService.buyStock(symbol, quantity);
        return "redirect:/?success=true";
    }

    @PostMapping("/sell")
    public String sell(@RequestParam String symbol, @RequestParam int quantity) {
        tradingService.sellStock(symbol, quantity);
        return "redirect:/?success=true";
    }

    @GetMapping("/api/stocks")
    @ResponseBody
    public List<Stock> getStocksApi() {
        return stockService.getAllStocks();
    }
}
