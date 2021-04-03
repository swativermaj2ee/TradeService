package com.dbs.TradeStoreService.util;

import com.dbs.TradeStoreService.entity.TradeData;
import com.dbs.TradeStoreService.service.TradePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

@Component
public class UpdateTradeExpiryTask implements Runnable {
    Timer timer;
    @Autowired
    TradePersistenceService tradePersistenceService;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void run() {
        System.out.println("Updating expired Trades!!!!");
        Iterator<Map.Entry<String, TradeData>> itr = tradePersistenceService.tradeDataMap.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, TradeData> entry = itr.next();
            try {
                if (entry.getValue().getMaturityDate().before(dateformat.parse(dateformat.format(new Date()))))
                    entry.getValue().setExpired(true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
