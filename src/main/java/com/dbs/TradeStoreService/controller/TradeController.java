package com.dbs.TradeStoreService.controller;

import com.dbs.TradeStoreService.entity.TradeData;
import com.dbs.TradeStoreService.exception.IncorrectTradeVersionException;
import com.dbs.TradeStoreService.exception.OldTradeMaturityDateException;
import com.dbs.TradeStoreService.service.TradePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeController {
    @Autowired
    TradePersistenceService tradePersistenceService;
    @RequestMapping(value = "/tradedata", method = RequestMethod.POST)
    public TradeData persist(@RequestBody TradeData tradeData) throws IncorrectTradeVersionException, OldTradeMaturityDateException {
        return tradePersistenceService.persist(tradeData);
    }

    @GetMapping(value = "/tradedatas")
    public List<TradeData> showAll() throws IncorrectTradeVersionException, OldTradeMaturityDateException {
        return tradePersistenceService.showAll();
    }
}
