package com.dbs.TradeStoreService.service;

import com.dbs.TradeStoreService.entity.TradeData;
import com.dbs.TradeStoreService.exception.IncorrectTradeVersionException;
import com.dbs.TradeStoreService.exception.OldTradeMaturityDateException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TradePersistenceService {
    public Map<String, TradeData> tradeDataMap = new ConcurrentHashMap<>();
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

    public TradePersistenceService() throws ParseException {
        TradeData tradeData1 = new TradeData("T1", 2, "CP-1", "B1", dateformat.parse("20-05-2020"), new Date(), false);
        tradeDataMap.put("T1", tradeData1);
    }

    public TradeData persist(TradeData tradeData) throws IncorrectTradeVersionException, OldTradeMaturityDateException {
        if (tradeDataMap.containsKey(tradeData.getTradeId())) {
            if (tradeDataMap.get(tradeData.getTradeId()).getVersion() > tradeData.getVersion())
                throw new IncorrectTradeVersionException("Incorrect version, older version not accepted");
            if (tradeData.getMaturityDate().before(new Date()))
                throw new OldTradeMaturityDateException("Incorrect Maturity Date, older Maturity Date not accepted");
        }
        tradeDataMap.put(tradeData.getTradeId(), tradeData);
        return tradeData;
    }

    public List<TradeData> showAll() {

        List<TradeData> tradeDataList = new ArrayList<>();
        Iterator<Map.Entry<String, TradeData>> itr = tradeDataMap.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, TradeData> entry = itr.next();
            tradeDataList.add(entry.getValue());
        }
        return tradeDataList;
    }
}
